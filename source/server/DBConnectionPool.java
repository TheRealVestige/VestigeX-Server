/******************\
* www.vestigex.com *
*******************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;

public class DBConnectionPool {
    
    public static final int POOL_SIZE = 10;
    private static int port;
    private static String host, user, pass, database;
    private static ArrayBlockingQueue<Statement> dbStatements = new ArrayBlockingQueue<Statement>(POOL_SIZE);
    private static Statement statement;

    public DBConnectionPool(String host, int port, String user, String pass, String database) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.database = database;
    }

    public void connect() {
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
                statement = conn.createStatement();
                statement.setEscapeProcessing(true);
                dbStatements.offer(statement);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Cannot connect to database!");
            }
        }
    }
    
    public static ResultSet executeQuery(String query) {
        try {
            statement = dbStatements.poll();
            ResultSet results = statement.executeQuery(query);
            dbStatements.offer(statement);
            return results;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static int executeUpdate(String query) {
        try {
            statement = dbStatements.poll();
            int results = statement.executeUpdate(query);
            dbStatements.offer(statement);
            return results;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public static Statement getNextStatement() {
        return dbStatements.poll();
    }

    public static void closeConnection() {
        try {
            for (int i = 0; i < dbStatements.size(); i++)
                dbStatements.remove(i);
            statement.getConnection().close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}