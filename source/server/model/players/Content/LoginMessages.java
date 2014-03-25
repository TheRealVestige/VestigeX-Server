package server.model.players.Content;

import server.Server;
import server.model.players.*;

/**
* Handles all Login Messages
* @author Gabbe
*/
public class LoginMessages {

	public static void handleAllLoginMessages(Client c) {
	 handleOwner(c);
	handleDonator(c);
    handlesDonator(c);
        handleMod(c);
        handleAdmin(c);
	}
	public static void handleOwner(Client c) {
	for (int j = 0; j < Server.playerHandler.players.length; j++) {
	if (Server.playerHandler.players[j] != null) {
	Client c2 = (Client)Server.playerHandler.players[j];
	if (c.playerName.equalsIgnoreCase("Bill")) {
	c2.sendMessage("<shad=800000000>Owner & Developer<img=2> Bill, Just signed in.");
	}
	}
	}
	}	
	public static void handleDonator(Client c) {
	for (int j = 0; j < Server.playerHandler.players.length; j++) {
	if (Server.playerHandler.players[j] != null) {
	Client c2 = (Client)Server.playerHandler.players[j];
	if (c.playerRights == 4 && c.issDonator == 0) {
	c2.sendMessage("<col=800000000><shad=255>Donator "+c.playerName.toLowerCase()+" Has Just Logged in!");
	}
	}
	}
	}
        public static void handlesDonator(Client c) {
	for (int j = 0; j < Server.playerHandler.players.length; j++) {
	if (Server.playerHandler.players[j] != null) {
	Client c2 = (Client)Server.playerHandler.players[j];
	if (c.playerRights == 4 && c.issDonator == 1) {
	c2.sendMessage("<col=225><shad=255>Super Donator "+c.playerName.toLowerCase()+" Has Just Logged in!");
	}
	}
	}
	}
        public static void handleMod(Client c) {
	for (int j = 0; j < Server.playerHandler.players.length; j++) {
	if (Server.playerHandler.players[j] != null) {
	Client c2 = (Client)Server.playerHandler.players[j];
	if (c.playerRights == 1) {
	c2.sendMessage("<col=255><shad=255><img=0>Moderator "+c.playerName.toLowerCase()+" Has just Logged in!");
	}
	}
	}
	}
        public static void handleAdmin(Client c) {
	for (int j = 0; j < Server.playerHandler.players.length; j++) {
	if (Server.playerHandler.players[j] != null) {
	Client c2 = (Client)Server.playerHandler.players[j];
	if (c.playerRights == 2) {
	c2.sendMessage("<shad=200000000><img=1>Administrator "+c.playerName.toLowerCase()+" Has just Logged in!");
	}
	}
	}
	}
}