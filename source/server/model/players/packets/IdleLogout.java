package server.model.players.packets;


import server.model.players.Client;
import server.model.players.PacketType;


public class IdleLogout implements PacketType {
	
	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		//if (!c.playerName.equalsIgnoreCase("Sabsabi"))
			//c.logout();
			switch (packetType) {
			case 202:
			if (c.underAttackBy > 0 || c.underAttackBy2 > 0) {
				return;
			} else {
				c.logout();
			}
			break;
		}
	}

}
