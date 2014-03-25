package server.model.players.Content;

import server.util.Misc;
import server.model.players.Client;
import server.model.players.PlayerHandler;

public class RequestHelp {

	public static boolean requestingHelp = false;
	public static String otherPlayer = "";
	
	public static void sendOnlineStaff(Client c) {
        String[][] Staff_Config = { {"bill", "28000", "28001"},  {"Rayne", "28004", "28005"}, {"Respect", "28006", "28007"}, {"Guido", "28008", "28009"}, {"Spec n Death", "28010", "28011"}, {"Love", "28012", "28013"} };
		for (int i = 0; i < Staff_Config.length; i++) {
			c.getPA().sendFrame126(Staff_Config[i][0], Integer.parseInt(Staff_Config[i][1]));
			if(PlayerHandler.isPlayerOn(Staff_Config[i][0])) {
				c.getPA().sendFrame126("@gre@Online", Integer.parseInt(Staff_Config[i][2]));
			}
		}
	}
	
	public static void setInterface(Client c) {
		if (!requestingHelp) {
			sendOnlineStaff(c);
			c.setSidebarInterface(2, 24999);
			c.getPA().sendFrame106(3);
		} else if (requestingHelp) {
                        sendOnlineStaff(c);
			c.setSidebarInterface(2, 24999);
			c.getPA().sendFrame106(3);
			requestingHelp = false;
		}
	}
	
	public static void callForHelp(Client c) {
                if (c.playerRights >= 1) {
			c.sendMessage("You can't Call for help, Your a staff!");
			return;
		}
		if (System.currentTimeMillis() - c.lastRequest < 30000) {
			c.sendMessage("It has only been "+ getTimeLeft(c) +" seconds since your last request for help!");
			c.sendMessage("Please only request help from the staff every 30 seconds!");
			if (!requestingHelp) {
				c.setSidebarInterface(2, 24999);
				c.getPA().sendFrame106(3);
			}
			return;
		}
		requestingHelp = true;
		otherPlayer = c.playerName;
		c.lastRequest = System.currentTimeMillis();
		setInterface(c);
		PlayerHandler.messageAllStaff(Misc.optimizeText(getPlayer().playerName) +"<shad=838383><col=838383> needs help, Please use ::teletoplayer", true);
	}
	
	public static long getTimeLeft(Client c) {
		return (System.currentTimeMillis() - c.lastRequest) / 1000;
	}

	public static Client getPlayer() {
		return PlayerHandler.getPlayerByName(otherPlayer);
	}
	
	public static String playerCoords() {
		return getPlayer().getX() +", "+ getPlayer().getY() +", "+ getPlayer().heightLevel;
	}

	public static void teleportToPlayer(Client c) {
		try {
			if (otherPlayer.equalsIgnoreCase(c.playerName)) {
				c.sendMessage("You can't teleport to yourself!");
				return;
			}
			if (otherPlayer != null && !otherPlayer.equalsIgnoreCase("")) {
				c.getPA().movePlayer(getPlayer().getX(), getPlayer().getY(), getPlayer().heightLevel);
				c.sendMessage("You telelported to "+ otherPlayer +".");
				otherPlayer = "";
			} else {
				c.sendMessage("There is no player to currently teleport to!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}