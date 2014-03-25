package server.model.players.packets;

import server.Config;
import server.Connection;
import server.Server;
import server.model.players.Content.RequestHelp;
import server.model.players.Client;
import server.model.players.PacketType;
import server.model.players.PlayerHandler;
import server.model.players.BankPin;
import server.model.items.ItemAssistant;
import server.model.players.Achievements;
import server.model.players.AchievementManager;
import server.model.players.AchievementExtra;
import server.util.Misc;
import java.io.*;

 
public class Commands implements PacketType 
{

    
    @Override
    public void processPacket(Client c, int packetType, int packetSize) 
    {
    String playerCommand = c.getInStream().readString();
		if (!playerCommand.startsWith("/"))
		{
			c.getPA().writeCommandLog(playerCommand);
		}
				if (playerCommand.startsWith("report") && playerCommand.length() > 7) {
   try {
   BufferedWriter report = new BufferedWriter(new FileWriter("./Data/Reports.txt", true));
   String Report = playerCommand.substring(7);
   try {	
	report.newLine();
	report.write(c.playerName + ": " + Report);
	c.sendMessage("You have successfully submitted your report.");
	} finally {
	report.close();
	}
	} catch (IOException e) {
                e.printStackTrace();
	}
}

if (playerCommand.equals("corp") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(3304, 9375, 0, "modern");
			c.sendMessage("Use a sigil with a blessed spirit shield!");
		}

if (playerCommand.equals("helpzone") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(1971, 5001, 0, "modern");
			c.sendMessage("Welcome to The Helpzone , For Support request in Stafflist Tab.");
		}

if (playerCommand.equals("curses") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(3241, 3610, 0, "modern");
		}
if (playerCommand.equals("shops") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(3195, 3429, 0, "modern");
			c.sendMessage("Shops are located around Varrock.");
		}
if (playerCommand.equals("home") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(3195, 3429, 0, "modern");
			c.sendMessage("Home Sweet Home...");
		}
if (playerCommand.equals("customs") && (c.playerRights >= 0)) {
	c.getPA().startTeleport(2097, 3162, 0, "modern");
}

if (playerCommand.equals("exchange") && (c.playerRights >= 0)) {
	if (c.getItems().playerHasItem(5023, 1)) {
	c.getItems().deleteItem(5023, 1);
	c.getItems().addItem(4067, 1);
	c.sendMessage("You exchange your old tickets for stackable ones.");
} else {
	c.sendMessage("You do not have a 2b Check to exchange.");
}
}

if (playerCommand.equals("exchange5") && (c.playerRights >= 0)) {
	if (c.getItems().playerHasItem(5023, 5)) {
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().addItem(4067, 5);
	c.sendMessage("You exchange your old tickets for stackable ones.");
} else {
	c.sendMessage("You do not have 5 2b Checks to exchange.");
}
}

if (playerCommand.equals("exchange10") && (c.playerRights >= 0)) {
	if (c.getItems().playerHasItem(5023, 10)) {
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().addItem(4067, 10);
	c.sendMessage("You exchange your old tickets for stackable ones.");
} else {
	c.sendMessage("You do not have 10 2b Checks to exchange.");
}
}

if (playerCommand.equals("exchange27") && (c.playerRights >= 0)) {
	if (c.getItems().playerHasItem(5023, 27)) {
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().deleteItem(5023, 1);
	c.getItems().addItem(4067, 27);
	c.sendMessage("You exchange your old tickets for stackable ones.");
} else {
	c.sendMessage("You do not have 27 2b Checks to exchange.");
}
}
if (playerCommand.startsWith("fly") && (c.isDonator == 1)) {
			if (c.playerStandIndex != 1501) {
				c.startAnimation(1500);
				c.playerStandIndex = 1501;
				c.playerTurnIndex = 1851;
				c.playerWalkIndex = 1851;
				c.playerTurn180Index = 1851;
				c.playerTurn90CWIndex = 1501;
				c.playerTurn90CCWIndex = 1501;
				c.playerRunIndex = 1851;
				c.updateRequired = true;
				c.appearanceUpdateRequired = true;
				c.sendMessage("You start flying.");
			} else {
				c.playerStandIndex = 0x328;
				c.playerTurnIndex = 0x337;
				c.playerWalkIndex = 0x333;
				c.playerTurn180Index = 0x334;
				c.playerTurn90CWIndex = 0x335;
				c.playerTurn90CCWIndex = 0x336;
				c.playerRunIndex = 0x338;
				c.updateRequired = true;
				c.appearanceUpdateRequired = true;
				c.sendMessage("You gently land on your feet.");
			}
		}


if (playerCommand.equals("protector") && (c.playerRights >= 0)) {
	c.getPA().startTeleport(2847, 3490, 0, "modern");
}

if (playerCommand.equals("farm") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(2819, 3462, 0, "modern");
			c.sendMessage("Farming");
		}
if (playerCommand.equals("thieve") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(3233, 2910, 0, "modern");
			c.sendMessage("thieving");
		}

if (playerCommand.equals("prayer") && (c.isDonator >= 1)) {
			if(c.playerLevel[5] < c.getPA().getLevelForXP(c.playerXP[5])) {
				c.playerLevel[5] = c.getPA().getLevelForXP(c.playerXP[5]); c.getPA().getLevelForXP(c.playerXP[5]);
				c.sendMessage("You recharge your prayer points.");
				c.getPA().refreshSkill(5);
			} else {
				c.sendMessage("You already have full prayer points.");
			}
		}

	if (playerCommand.equals("duel") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(3358, 3269, 0, "modern");
		AchievementManager.increase(c, Achievements.ARENA);
		}	
if (playerCommand.equals("slayer") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(3428, 3538, 0, "modern");
			c.sendMessage("Welcome to the Slayer Tower!");
		}
		if (playerCommand.equals("dks") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(1912, 4367, 0, "modern");
			c.sendMessage("Welcome to the Dagganoth Area!");
		}
if (playerCommand.equals("achieve") && (c.playerRights >= 0)) {		
			AchievementManager.writeInterface(c);
			c.sendMessage("Under Construction!");
		}
if (playerCommand.equals("summon") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(3448, 3517, 0, "modern");
		}
if (playerCommand.equals("dzone") && (c.isDonator == 1)) {
			c.getPA().startTeleport(2393, 9894, 0, "modern");
			c.sendMessage("Welcome to the Donator Zone!");
		}
if (playerCommand.equals("funpk") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(2605, 3153, 0, "modern");
			c.sendMessage("Welcome to the FunPK arena!");
		}
if (playerCommand.equals("megazone") && (c.issDonator == 1)) {
			c.getPA().startTeleport(2130, 4913, 0, "modern");
			c.sendMessage("Welcome to the Mega Zone!");
		}
if (playerCommand.equals("mining") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(3040, 9802, 0, "modern");
			c.sendMessage("Welcome to the Mining zone");
		}
if (playerCommand.equals("staffzone") && (c.playerRights == 3)) {
			c.getPA().startTeleport(1865, 5348, 0, "modern");
		}
if (playerCommand.equals("staffzone") && (c.playerRights == 2)) {
			c.getPA().startTeleport(1865, 5348, 0, "modern");
		}		
if (playerCommand.equals("staffzone") && (c.playerRights == 1)) {
			c.getPA().startTeleport(1865, 5348, 0, "modern");
		}		
		
if (playerCommand.equals("train") && (c.playerRights >= 0)) {
			c.getPA().startTeleport(2683, 3725, 0, "modern");
			c.sendMessage("Welcome to the classic rock crab training area!");
		}
		if (playerCommand.startsWith("kdr")) {
				double KDR = ((double)c.KC)/((double)c.DC);
				c.forcedChat("My Kill/Death ratio is "+c.KC+"/"+c.DC+"; "+KDR+".");
		}

		if (playerCommand.startsWith("forums")) {
			c.getPA().sendFrame126("http://community.vestigex.com", 12000);
		}
		if (playerCommand.startsWith("hs")) {
			c.getPA().sendFrame126("http://highscores.vestigex.com", 12000);
		}
		if (playerCommand.startsWith("donate")) {
			c.getPA().sendFrame126("http://vestigex.com/mmo/game-extras.html", 12000);
		}
		
		if (playerCommand.startsWith("/") && playerCommand.length() > 1) {
			if (c.clanId >= 0) {
				System.out.println(playerCommand);
				playerCommand = playerCommand.substring(1);
				Server.clanChat.playerMessageToClan(c.playerId, playerCommand, c.clanId);
			} else {
				if (c.clanId != -1)
				c.clanId = -1;
				c.sendMessage("You are not in a clan.");
			}
			return;       
		}
    if (Config.SERVER_DEBUG)
        Misc.println(c.playerName+" playerCommand: "+playerCommand);
    
    if (c.playerRights >= 0)
        playerCommands(c, playerCommand);
    if (c.playerRights == 1 || c.playerRights == 2 || c.playerRights == 3)
        moderatorCommands(c, playerCommand);
    if (c.playerRights == 2 || c.playerRights == 3)
        administratorCommands(c, playerCommand);
    if (c.playerRights == 3) 
        ownerCommands(c, playerCommand);
    if (c.playerRights == 5) 
        ownerCommands(c, playerCommand);
    if (c.playerRights == 10) 
        ownerCommands(c, playerCommand);
    if (c.playerRights == 4) 
        DonatorCommands(c, playerCommand);
			
    }

    
    public void playerCommands(Client c, String playerCommand)
    {  
    if (playerCommand.equalsIgnoreCase("rules")) { 
    for(int i = 8144; i < 8195; i++) {
            c.getPA().sendFrame126("", i);
        }
    c.getPA().showInterface(8134);
c.getPA().sendFrame126("@blu@~ "+Config.SERVER_NAME+" Rules ~",8144);
c.getPA().sendFrame126("@blu@1. Do not argue Over ::yell - 24h Mute",8145);
c.getPA().sendFrame126("@blu@2. Scamming is not tolerated - Account Ban",8147);
c.getPA().sendFrame126("@blu@3. Autoing is not aloud! - 24h - Jail.",8148);
c.getPA().sendFrame126("@blu@4. Impersonating a donator or staff = IPBan.",8149);
c.getPA().sendFrame126("@blu@5. Do NOT abuse bugs! Report them immediately",8150);
c.getPA().sendFrame126("@blu@6. Don't encourage anyone to break the rules - IPBan",8151);
c.getPA().sendFrame126("@blu@7. NO GAMBLING OF ANY KIND - Account Ban.",8152);
c.getPA().sendFrame126("@blu@8. Giving out your password - IPBan",8153);
c.getPA().sendFrame126("@blu@9. Do not spam the owner for items - Mute",8154);
c.getPA().sendFrame126("@blu@10. Making another account to talk after mute - Perm Muted.",8155);
c.getPA().sendFrame126("@blu@11. Respect all the staff member's decisions",8156);
c.getPA().sendFrame126("@blu@12. Saying you voted and you didn't - 24h Mute",8157);
c.getPA().sendFrame126("@blu@14. Farming Loyalty = 24h IPJail.",8158);
c.getPA().sendFrame126("@blu@15. Threatening the server won't be taken lightly.",8159);
}
if (playerCommand.equalsIgnoreCase("commands")) { 
    c.getPA().showInterface(36000);
}
    if(playerCommand.startsWith("withdraw")) {
                String[] cAmount = playerCommand.split(" ");
                int amount = Integer.parseInt(cAmount[1]);
                if (c.inWild()) {
                        c.sendMessage("You cannot do this in the wilderness");
                        c.getPA().sendFrame126(""+c.MoneyCash+"", 8135); 
                        return;
                }
                if (amount < 1) {
		return; 
		}
                if(amount == 0) {
                        c.sendMessage("Why would I withdraw no coins?");
                        return;
                }
                if(c.MoneyCash == 0) {
                        c.sendMessage("You don't have any cash in the bag.");
                        c.getPA().sendFrame126(""+c.MoneyCash+"", 8135); 
                        return;
                }
                if(c.MoneyCash < amount) {
                        if(amount == 1) {
                                c.sendMessage("You withdraw 1 coin.");
                        } else  {
                                c.sendMessage("You withdraw "+c.MoneyCash+" coins.");
                        }
                        c.getItems().addItem(995, c.MoneyCash);
                        c.MoneyCash = 0;
                        c.getPA().sendFrame126(""+c.MoneyCash+"", 8134); 
                        c.getPA().sendFrame126(""+c.MoneyCash+"", 8135);
                        return;
                }
                if(c.MoneyCash != 0) {
                        if(amount == 1) {
                                c.sendMessage("You withdraw 1 coin.");
                        } else  {
                                c.sendMessage("You withdraw "+amount+" coins.");
                        }
                                c.MoneyCash -= amount;
                                c.getItems().addItem(995, amount);
                                c.getPA().sendFrame126(""+c.MoneyCash+"", 8135);
                if(c.MoneyCash > 99999 && c.MoneyCash <= 999999) {
                c.getPA().sendFrame126(""+c.MoneyCash/1000+"K", 8134); 
                } else if(c.MoneyCash > 999999 && c.MoneyCash <= 2147483647) {
                        c.getPA().sendFrame126(""+c.MoneyCash/1000000+"M", 8134);
                } else {
                                c.getPA().sendFrame126(""+c.MoneyCash+"", 8134);
                        }
                c.getPA().sendFrame126(""+c.MoneyCash+"", 8135);
                }
        }
		
if (playerCommand.equalsIgnoreCase("dice")) {
		if(c.inWild()) {
		        c.sendMessage("Er, it's not to smart to do this in the Wilderness.");
			return;
                }
                if (c.playerRights == 0) {
                	c.sendMessage("Only Donators Can Dice, This Is A Scam Precaution.");
					return;
                }
                //c.forcedText = "["+ c.playerName +"] Just Rolled "+ Misc.random(100) +" On The Dice!";
                //c.forcedChatUpdateRequired = true;
            	//c.updateRequired = true;
				c.sendMessage("Dicing has been disabled at a request of the community.");
			}
                        if (playerCommand.startsWith("resettask")) {
				c.taskAmount = -1;
				c.slayerTask = 0;
			}
			if (playerCommand.startsWith("resetdef")) {
				if (c.inWild())
				return;
				for (int j = 0; j < c.playerEquipment.length; j++) {
					if (c.playerEquipment[j] > 0) {
						c.sendMessage("Please take all your armour and weapons off before using this command.");
						return;
					}
				}
				try {
					int skill = 1;
					int level = 1;
					c.playerXP[skill] = c.getPA().getXPForLevel(level)+5;
					c.playerLevel[skill] = c.getPA().getLevelForXP(c.playerXP[skill]);
					c.getPA().refreshSkill(skill);
				} catch (Exception e){}
			}
                        if (playerCommand.equalsIgnoreCase("enddung")){
			if (c.InDung() || c.inDungBossRoom()) {
					c.getPA().movePlayer(3085, 3495, 0);
				c.playerLevel[5] = c.getPA().getLevelForXP(c.playerXP[5]);
					c.playerLevel[3] = c.getPA().getLevelForXP(c.playerXP[3]);
					c.prayerId = -1;
					c.hasFollower = 0;
					c.isSkulled = true;
					c.getPA().closeAllWindows();
					c.getPA().refreshSkill(5);
					c.getPA().refreshSkill(3);
					c.getItems().deleteAllItems();
					c.hasChoosenDung = false;
					c.getDungeoneering().setDaBooleans();
					//c.hassentrelogmessage = false;
					c.needstorelog = true;
					c.InDung = false;
					c.getPA().closeAllWindows();
					} else {
					c.sendMessage("YOU ARE NOT IN DUNGEONEERING!");
	return;
	}
	}
			if (playerCommand.equalsIgnoreCase("damage")){
		c.sendMessage("Damage dealt : "+c.barbDamage+" ");
		}
	
	
				if (playerCommand.equalsIgnoreCase("endgame")){
if (c.inBarbDef) {
			Server.barbDefence.endGame(c, false);
			} else {
			c.sendMessage("Your not in the minigame!");
		}
		}
			if (playerCommand.startsWith("rest")) {
c.startAnimation(5713);
                        }
                        
                        if (playerCommand.equalsIgnoreCase("bank") && c.issDonator == 1 && !c.inWild() && !c.isInPbox() && !c.isInArd() && !c.isInFala() && !c.inFunPk()) {
				c.getPA().openUpBank();
                        }
						if (playerCommand.equalsIgnoreCase("bank") && c.isDonator == 1 && !c.inWild() && !c.isInPbox() && !c.isInArd() && !c.isInFala() && !c.inFunPk()) {
				c.getPA().openUpBank();
                        }
		        if (playerCommand.equalsIgnoreCase("players")) {
			c.sendMessage("There are currently "
					+ PlayerHandler.getPlayerCount() + " players online.");
			c.getPA().sendFrame126(Config.SERVER_NAME + " - Online Players",
					8144);
			c.getPA().sendFrame126(
					"@dbl@Online players(" + PlayerHandler.getPlayerCount()
							+ "):", 8145);
			int line = 8147;
			for (int i = 1; i < Config.MAX_PLAYERS; i++) {
				Client p = c.getClient(i);
				if (!c.validClient(i))
					continue;
				if (p.playerName != null) {
					String title = "";
					if (p.playerRights == 1) {
						title = "Mod, ";
					} else if (p.playerRights == 2) {
						title = "Admin, ";
					} else if (p.playerRights == 3) {
						title = "Owner, ";
					} else if (p.playerRights == 4) {
						title = "Donator, ";
					}
					title += "level-" + p.combatLevel;
					String extra = "";
					if (c.playerRights > 0) {
						extra = "(" + p.playerId + ") ";
					}
					c.getPA().sendFrame126(
							"@dre@" + extra + p.playerName + "@dbl@ (" + title
									+ ") @dre@Kills: @dbl@ " + p.KC
									+ ",  @dre@Deaths: @dbl@" + p.DC, line);
					line++;
				}
			}
			c.getPA().showInterface(8134);
			c.flushOutStream();
		}
			if (playerCommand.startsWith("changepassword") && playerCommand.length() > 15) {
				c.playerPass = playerCommand.substring(15);
				c.sendMessage("Your password is now: " + c.playerPass);			
			}
			if (playerCommand.startsWith("claim")) {
				if (c.buryDelay < 120) {
        		c.sendMessage("You cannot mass claim.");
        	} else {
				if (c.checkVotes(c.playerName)) {
                    c.getItems().addItem(995, 40000000);
                    c.getItems().addItem(989, 1);
                    c.customPoints += 50;
					c.pcPoints += 100;
					c.buryDelay = System.currentTimeMillis();
                    c.sendMessage("Thanks for voting, You Received 50 Custom & 100 Vestige Points.");
				} else {
					c.sendMessage("You have not voted yet today.");
				return;
				}
        	}

        }
			
			if (playerCommand.startsWith("ep") || playerCommand.startsWith("Ep") || playerCommand.startsWith("EP") || playerCommand.startsWith("eP")) {
			c.sendMessage("EP: "+ c.earningPotential+"");
			} // add player spawning here
			if (playerCommand.startsWith("vote") || playerCommand.startsWith("VOTE") || playerCommand.startsWith("Vote") || playerCommand.startsWith("vOTE")) {
                        c.getPA().sendFrame126("http://www.vestigex.com/vote.php", 12000);
                        }	
                        if (playerCommand.startsWith("skull"))
                        if(c.skullTimer > 0) {
			        c.skullTimer--;
			        if(c.skullTimer == 1) {
				        c.isSkulled = false;
				        c.attackedPlayers.clear();
				        c.headIconPk = -1;
				        c.skullTimer = -1;
				        c.getPA().requestUpdates();
			        }	
		        }
                        if (playerCommand.startsWith("empty")) {
                                c.getItems().removeAllItems();
                                c.sendMessage("You empty your inventory");
			}
			if (playerCommand.startsWith("yell") || playerCommand.equalsIgnoreCase("Yell") || playerCommand.equalsIgnoreCase("YELL") || playerCommand.equalsIgnoreCase("yel")) { 
				String text = playerCommand.substring(5);
					String[] bad = {"chalreq", "duelreq", "tradereq", ". com",
							"org", "net", "biz", ". net", ". org", ". biz", 
							". no-ip", "- ip", ".no-ip.biz", "no-ip.org", "servegame",
							".com", ".net", ".org", "no-ip", "****", "<", "is gay", "****",
							"crap", "rubbish", ". com", ". serve", ". no-ip", ". net", ". biz"};
					for(int i = 0; i < bad.length; i++){
						if(text.indexOf(bad[i]) >= 0){
							return;
						}
					}
				for (int j = 0; j < Server.playerHandler.players.length; j++) {
					if (Server.playerHandler.players[j] != null) {
						Client c2 = (Client)Server.playerHandler.players[j];
							
							if (!Connection.isMuted(c)) {

							if (c.playerName.equalsIgnoreCase("bill")){
								c2.sendMessage("<shad=800000000><img=1>[Owner & Dev]</col><img=1>"+ Misc.optimizeText(c.playerName) +":</col> "
							    + Misc.optimizeText(playerCommand.substring(5)) +"");
							}else if (c.playerName.equalsIgnoreCase("rayne")) {
								c2.sendMessage("<col225><shad=838383><img=1>[Head-Admin]</col><img=1><shad=838383>"+ Misc.optimizeText(c.playerName) +": "
												+ Misc.optimizeText(playerCommand.substring(5)) +"");
							
							}else if (c.playerRights == 2){
								c2.sendMessage("<shad=200000000>[Admin]</col><img=1>"+ Misc.optimizeText(c.playerName) +": "
												+ Misc.optimizeText(playerCommand.substring(5)) +"");
							
							}else if (c.playerRights == 1){
								c2.sendMessage("<col=255><shad=255>[Mod]</col><img=0>"+ Misc.optimizeText(c.playerName) +": "
												+ Misc.optimizeText(playerCommand.substring(5)) +"");
							
							}else if (c.playerRights == 10){
								c2.sendMessage("<col=255><shad=2505>[Server Support]</col>"+ Misc.optimizeText(c.playerName) +": "
												+ Misc.optimizeText(playerCommand.substring(5)) +"");
                                                        }else if (c.playerRights == 3){
								c2.sendMessage("<img=1><shad=330000>[Co-Owner]<img=1>"+ Misc.optimizeText(c.playerName) +": "
												+ Misc.optimizeText(playerCommand.substring(5)) +"");
                                                        }else if (c.playerRights == 4 && c.issDonator == 0){
								c2.sendMessage("<col=800000000><shad=255>[Donator]<img=3>"+ Misc.optimizeText(c.playerName) +": "
												+ Misc.optimizeText(playerCommand.substring(5)) +"");
                                                        }else if (c.playerRights == 4 && c.issDonator == 1){
								c2.sendMessage("<col=225><shad=255>[Super Donator]<img=3>"+ Misc.optimizeText(c.playerName) +": "
												+ Misc.optimizeText(playerCommand.substring(5)) +"");
							}else if (c.playerRights == 0){
								c2.sendMessage("<shad=6081134>[Player]</col>"+ Misc.optimizeText(c.playerName) +": "
												+ Misc.optimizeText(playerCommand.substring(5)) +"");
							} else if (c.playerLevel[21] <= 99) {
						c.sendMessage("You must have 99 summoning to use this command!");
					} else {
						if (c.isInJail()) {
							c.sendMessage("You cannot yell while you are in Jail!");
							return;
						}
									
							}
						}
					}
				}  
    }}

    public void moderatorCommands(Client c, String playerCommand)
    {
			if(playerCommand.startsWith("jail")) {
				try {
					String playerToBan = playerCommand.substring(5);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
					if(Server.playerHandler.players[i] != null) {
					if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
					Client c2 = (Client)Server.playerHandler.players[i];
					c2.teleportToX = 2606;
					c2.teleportToY = 3105;
					c2.Jail = true;
					c2.sendMessage("You have been jailed by "+c.playerName+"");
					c.sendMessage("Successfully Jailed "+c2.playerName+".");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
}
			if (playerCommand.startsWith("xteleto")) {
				String name = playerCommand.substring(8);
				for (int i = 0; i < Config.MAX_PLAYERS; i++) {
					if (Server.playerHandler.players[i] != null) {
						if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(name)) {
							c.getPA().movePlayer(Server.playerHandler.players[i].getX(), Server.playerHandler.players[i].getY(), Server.playerHandler.players[i].heightLevel);
						}
					}
				}			
			}
if (playerCommand.startsWith("mute")) {
			try {	
				String playerToBan = playerCommand.substring(5);
				Connection.addNameToMuteList(playerToBan);
				for(int i = 0; i < Config.MAX_PLAYERS; i++) {
					if(Server.playerHandler.players[i] != null) {
						if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
							Client c2 = (Client)Server.playerHandler.players[i];
							c2.sendMessage("You have been muted by: " + c.playerName);
							c.sendMessage("You have muted: " + c2.playerName);
							break;
						} 
					}
				}
			if (playerCommand.startsWith("checkinv") && c.playerRights == 2) {
				try {
					String[] args = playerCommand.split(" ", 2);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						Client o = (Client) Server.playerHandler.players[i];
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(args[1])) {
                 						c.getPA().otherInv(c, o);
											break;
							}
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline."); 
					}
			}
			if (playerCommand.startsWith("fixinv")) {
				c.sendMessage("You have disconnected to fix your inventory");
				c.disconnected = true;
						}
			} catch(Exception e) {
				c.sendMessage("Player Must Be Offline.");
			}			
		}	
		
		if (playerCommand.startsWith("unmute")) {
			try {	
				String playerToBan = playerCommand.substring(7);
				Connection.unMuteUser(playerToBan);
				c.sendMessage("Unmuted.");
			} catch(Exception e) {
				c.sendMessage("Player Must Be Offline.");
			}			
		}	

				if (playerCommand.startsWith("checkbank")) {
				String[] args = playerCommand.split("_");
				for(int i = 0; i < Config.MAX_PLAYERS; i++)
				{
					Client o = (Client) Server.playerHandler.players[i];
					if(Server.playerHandler.players[i] != null)
					{
						if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(args[1]))
						{
                 						c.getPA().otherBank(c, o);
						break;
						}
					}
				}
			}
			if (playerCommand.startsWith("kick") && playerCommand.charAt(4) == ' ') {
				try {	
					String playerToBan = playerCommand.substring(5);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
								Server.playerHandler.players[i].disconnected = true;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
				}
			if (playerCommand.startsWith("ban") && playerCommand.charAt(3) == ' ') {
				try {	
					String playerToBan = playerCommand.substring(4);
					Connection.addNameToBanList(playerToBan);
					Connection.addNameToFile(playerToBan);
					c.getPA().writeBanLog(playerCommand);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
								Server.playerHandler.players[i].disconnected = true;
						Client c2 = (Client)Server.playerHandler.players[i];
								c2.sendMessage(" " +c2.playerName+ " Got Banned By " + c.playerName+ ".");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
				}
			if (playerCommand.startsWith("teletoplayer")) {
					c.sendMessage("<col=838383><shad=838383>You teleport to the person who requested help!");
                                        c.t2p();
			}
                        if (playerCommand.startsWith("unban")) {
				try {	
					String playerToBan = playerCommand.substring(6);
					Connection.removeNameFromBanList(playerToBan);
					c.sendMessage(playerToBan + " has been unbanned.");
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}
			if(playerCommand.startsWith("unjail")) {
				try {
					String playerToBan = playerCommand.substring(7);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
					if(Server.playerHandler.players[i] != null) {
					if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
					Client c2 = (Client)Server.playerHandler.players[i];
					c2.teleportToX = 2606;
                        		c2.teleportToY = 3104;
					c2.monkeyk0ed = 0;
					c2.Jail = false;
					c2.sendMessage("You have been unjailed by "+c.playerName+".");
					c.sendMessage("Successfully unjailed "+c2.playerName+".");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}
        
    }
    
    public void administratorCommands(Client c, String playerCommand)
    {
			if (playerCommand.startsWith("alert") && c.playerRights > 1) {
				String msg = playerCommand.substring(6);
				for (int i = 0; i < Config.MAX_PLAYERS; i++) {
					if (Server.playerHandler.players[i] != null) {
						 Client c2 = (Client)Server.playerHandler.players[i];
						c2.sendMessage("Alert##"+Config.SERVER_NAME+" Notification##" + msg + "##By: " + c.playerName);

					}
				}
			}
			 if (playerCommand.startsWith("copy")) {
	 int[]  arm = new int[14];
	 String name = playerCommand.substring(5);
                        for (int j = 0; j < Server.playerHandler.players.length; j++) {
                        if (Server.playerHandler.players[j] != null) {
                                Client c2 = (Client)Server.playerHandler.players[j];
                   if(c2.playerName.equalsIgnoreCase(playerCommand.substring(5))){
	 for(int q = 0; q < c2.playerEquipment.length; q++) {
		 arm[q] = c2.playerEquipment[q];
		c.playerEquipment[q] = c2.playerEquipment[q];
						}
		for(int q = 0; q < arm.length; q++) {
                   c.getItems().setEquipment(arm[q],1,q);
						}
					}	
				}
                        }
}
			if (playerCommand.startsWith("ipmute")) {
				try {	
					String playerToBan = playerCommand.substring(7);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
								Connection.addIpToMuteList(Server.playerHandler.players[i].connectedFrom);
								c.sendMessage("You have IP Muted the user: "+Server.playerHandler.players[i].playerName);
								Client c2 = (Client)Server.playerHandler.players[i];
								c2.sendMessage("You have been muted by: " + c.playerName);
								c2.sendMessage(" " +c2.playerName+ " Got IpMuted By " + c.playerName+ ".");
								break;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}	
				}	


if (playerCommand.equalsIgnoreCase("master")) {
				for (int i = 0; i < 23; i++) {
					c.playerLevel[i] = 99;
					c.playerXP[i] = c.getPA().getXPForLevel(99);
					c.getPA().refreshSkill(i);	
				}
				c.getPA().requestUpdates();
			}
			
			if (playerCommand.startsWith("object")) {
				String[] args = playerCommand.split(" ");				
				c.getPA().object(Integer.parseInt(args[1]), c.absX, c.absY, 0, 10);
			}
			
			if (playerCommand.equalsIgnoreCase("mypos")) {
				c.sendMessage("X: "+c.absX+" Y: "+c.absY+" H: "+c.heightLevel);
			}

			if (playerCommand.startsWith("interface")) {
				String[] args = playerCommand.split(" ");
				c.getPA().showInterface(Integer.parseInt(args[1]));
			}
			
			if (playerCommand.startsWith("giveitem") && c.playerName.equalsIgnoreCase("rayne")) {
            try {
                String[] args = playerCommand.split(" ");
                int newItemID = Integer.parseInt(args[1]);
                int newItemAmount = Integer.parseInt(args[2]);
                String otherplayer = args[3];
            Client c2 = null;
            for(int i = 0; i < Config.MAX_PLAYERS; i++) {
                if(Server.playerHandler.players[i] != null) {
                if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(otherplayer)) {
                    c2 = (Client)Server.playerHandler.players[i];
            break;
            }
        }
    }
                if (c2 == null) {
                    c.sendMessage("Player doesn't exist.");
            return;
        }
            c.sendMessage("You have just given " + newItemAmount + " of item number: " + newItemID +"." );
            c2.sendMessage("You have just been given item(s)." );
            c2.getItems().addItem(newItemID, newItemAmount);    
        } catch(Exception e) {
            c.sendMessage("Use as ::giveitem ID AMOUNT PLAYERNAME.");
        }            
    }
			
			if (playerCommand.startsWith("gfx")) {
				String[] args = playerCommand.split(" ");
				c.gfx0(Integer.parseInt(args[1]));
			}
			if (playerCommand.startsWith("tele")) {
				String[] arg = playerCommand.split(" ");
				if (arg.length > 3)
					c.getPA().movePlayer(Integer.parseInt(arg[1]),Integer.parseInt(arg[2]),Integer.parseInt(arg[3]));
				else if (arg.length == 3)
					c.getPA().movePlayer(Integer.parseInt(arg[1]),Integer.parseInt(arg[2]),c.heightLevel);
			}

                        if (playerCommand.startsWith("item") && c.playerRights == 2) {
				try {
					String[] args = playerCommand.split(" ");
					if (args.length == 3) {
						int newItemID = Integer.parseInt(args[1]);
						int newItemAmount = Integer.parseInt(args[2]);
						if ((newItemID <= 20500) && (newItemID >= 0)) {
							c.getItems().addItem(newItemID, newItemAmount);		
						} else {
							c.sendMessage("That item ID does not exist.");
						}
					} else {
						c.sendMessage("Wrong usage: (eg:(::item 995 1))");
					}
				} catch(Exception e) {
					
				}
			}
                        
			if (playerCommand.equalsIgnoreCase("bank")) {
				c.getPA().openUpBank();
			}
            if (playerCommand.startsWith("pnpc"))
                {
                try {
                    int newNPC = Integer.parseInt(playerCommand.substring(5));
                    if (newNPC <= 200000 && newNPC >= 0) {
                        c.npcId2 = newNPC;
                        c.isNpc = true;
                        c.updateRequired = true;
                        c.setAppearanceUpdateRequired(true);
                    } 
                    else {
                        c.sendMessage("No such P-NPC.");
                    }
                } catch(Exception e) {
                    c.sendMessage("Wrong Syntax! Use as ::pnpc #");
                }
            }
if(playerCommand.startsWith("unpc")) {
c.isNpc = false;
c.updateRequired = true;
c.appearanceUpdateRequired = true;
}
			if (playerCommand.startsWith("unipmute")) {
				try {	
					String playerToBan = playerCommand.substring(9);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
								Connection.unIPMuteUser(Server.playerHandler.players[i].connectedFrom);
								c.sendMessage("You have Un Ip-Muted the user: "+Server.playerHandler.players[i].playerName);
								break;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
						}			
					}
if(playerCommand.startsWith("who")) {
try {
String playerToCheck = playerCommand.substring(4);
	for(int i = 0; i < Config.MAX_PLAYERS; i++) {
		if(Server.playerHandler.players[i] != null) {
			if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToCheck)) {
				Client c2 = (Client)Server.playerHandler.players[i];
				c.sendMessage("<col=255>Name: " + c2.playerName +"");
				c.sendMessage("<col=15007744>IP: " + c2.connectedFrom + "");
				c.sendMessage("<col=255>X: " + c2.absX +"");
				c.sendMessage("<col=255>Y: " + c2.absY +"");
			break;
						} 
					}
				}
			} catch(Exception e) {
		c.sendMessage("Player is offline.");
	}			
}


						if (playerCommand.startsWith("reloadnpc")) {
				Server.npcHandler = null;
				Server.npcHandler = new server.model.npcs.NPCHandler();
				for (int j = 0; j < Server.playerHandler.players.length; j++) {
					if (Server.playerHandler.players[j] != null) {
						Client c2 = (Client)Server.playerHandler.players[j];
						c2.sendMessage("<shad=15695415>[" + c.playerName + "] " + "Has Reloaded All Npc Spawns.</col>");
					}
				}

						}
                        if (playerCommand.startsWith("xteletome") && c.playerRights >= 2 && c.playerRights <=3) {
				try {	
					String playerToTele = playerCommand.substring(10);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToTele)) {
								Client c2 = (Client)Server.playerHandler.players[i];
								c2.sendMessage("You have been teleported to " + c.playerName);
								c2.getPA().movePlayer(c.getX(), c.getY(), c.heightLevel);
								break;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}			
			}
					if(playerCommand.startsWith("getid")) {
                                String a[] = playerCommand.split(" ");
                                String name = "";
                                int results = 0;
                                for(int i = 1; i < a.length; i++)
                                        name = name + a[i]+ " ";
                                name = name.substring(0, name.length()-1);
                                c.sendMessage("Searching: " + name);
                                for (int j = 0; j < Server.itemHandler.ItemList.length; j++) {
                                        if (Server.itemHandler.ItemList[j] != null)
                                                if (Server.itemHandler.ItemList[j].itemName.replace("_", " ").toLowerCase().contains(name.toLowerCase())) {
                                                        c.sendMessage("<col=255>" 
                                                                        + Server.itemHandler.ItemList[j].itemName.replace("_", " ") 
                                                                        + " - " 
                                                                        + Server.itemHandler.ItemList[j].itemId);
                                                        results++;
                                                }
                                }
                                c.sendMessage(results + " results found...");
                        }
			if (playerCommand.startsWith("ipban")) {
				try {
					c.getPA().writeIPBanLog(playerCommand);
					String playerToBan = playerCommand.substring(6);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
								Connection.addIpToBanList(Server.playerHandler.players[i].connectedFrom);
								Connection.addIpToFile(Server.playerHandler.players[i].connectedFrom);
								c.sendMessage("You have IP banned the user: "+Server.playerHandler.players[i].playerName+" with the host: "+Server.playerHandler.players[i].connectedFrom);
						Client c2 = (Client)Server.playerHandler.players[i];
								Server.playerHandler.players[i].disconnected = true;
								c2.sendMessage(" " +c2.playerName+ " Got IpBanned By " + c.playerName+ ".");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}
			}

        
    }
    
    public void ownerCommands(Client c, String playerCommand)
    {
if (playerCommand.startsWith("giveitem")) {
            try {
                String[] args = playerCommand.split(" ");
                int newItemID = Integer.parseInt(args[1]);
                int newItemAmount = Integer.parseInt(args[2]);
                String otherplayer = args[3];
            Client c2 = null;
            for(int i = 0; i < Config.MAX_PLAYERS; i++) {
                if(Server.playerHandler.players[i] != null) {
                if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(otherplayer)) {
                    c2 = (Client)Server.playerHandler.players[i];
            break;
            }
        }
    }
                if (c2 == null) {
                    c.sendMessage("Player doesn't exist.");
            return;
        }
            c.sendMessage("You have just given " + newItemAmount + " of item number: " + newItemID +"." );
            c2.sendMessage("You have just been given item(s)." );
            c2.getItems().addItem(newItemID, newItemAmount);    
        } catch(Exception e) {
            c.sendMessage("Use as ::giveitem ID AMOUNT PLAYERNAME.");
        }            
    } 
	if (playerCommand.startsWith("load")) {
			String loadData = playerCommand.substring(5);
			switch(loadData) {
				case "npcs":case "Npcs":
					Server.npcHandler = new server.model.npcs.NPCHandler();
					c.sendMessage("Npcs reloaded.");
				break;	
				case "drops":case "Drops":
					Server.npcDrops = new server.model.npcs.NPCDrops();
					c.sendMessage("Drops reloaded.");
				break;	
				case "shops":case "Shops":
					Server.shopHandler = new server.world.ShopHandler();
					c.sendMessage("Shops reloaded.");
				break;	
				case "items":case "Items":
					Server.itemHandler = new server.world.ItemHandler();
					c.sendMessage("Items reloaded.");
				break;
			}
		}
if (playerCommand.startsWith("takeitem")) {
        try {
        String[] args = playerCommand.split(" ");
            int takenItemID = Integer.parseInt(args[1]);
            int takenItemAmount = Integer.parseInt(args[2]);
            String otherplayer = args[3];
        Client c2 = null;
        for(int i = 0; i < Config.MAX_PLAYERS; i++) {
            if(Server.playerHandler.players[i] != null) {
            if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(otherplayer)) {
                c2 = (Client)Server.playerHandler.players[i];
            break;
            }
        }
    }
        if (c2 == null) {
            c.sendMessage("Player doesn't exist.");
        return;
        }
        c.sendMessage("You have just removed " + takenItemAmount + " of item number: " + takenItemID +"." );
        c2.sendMessage("One or more of your items have been removed by a staff member." );
        c2.getItems().deleteItem(takenItemID, takenItemAmount);    
    } catch(Exception e) {
        c.sendMessage("Use as ::takeitem ID AMOUNT PLAYERNAME.");
        }            
    }
                        if(playerCommand.startsWith("getnpc")) {
                                String a[] = playerCommand.split(" ");
                                String name = "";
                                int results = 0;
                                for(int i = 1; i < a.length; i++)
                                        name = name + a[i]+ " ";
                                name = name.substring(0, name.length()-1);
                                c.sendMessage("Searching npc: " + name);
                                for (int j = 0; j < Server.npcHandler.NpcList.length; j++) {
                                        if (Server.npcHandler.NpcList[j] != null)
                                                if (Server.npcHandler.NpcList[j].npcName.replace("_", " ").toLowerCase().contains(name.toLowerCase())) {
                                                        c.sendMessage("<col=255>" 
                                                                        + Server.npcHandler.NpcList[j].npcName.replace("_", " ") 
                                                                        + " - " 
                                                                        + Server.npcHandler.NpcList[j].npcId);
                                                        results++;
                                                }
                                }
                                c.sendMessage(results + " results found...");
                        }

			if (playerCommand.startsWith("regnow") && c.playerName.equalsIgnoreCase("Bill")) {
			try { 
				String playerToBan = playerCommand.substring(7);
				for(int i = 0; i < Config.MAX_PLAYERS; i++) {
				if(Server.playerHandler.players[i] != null) {
				if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan))
				{
				Client c2 = (Client)Server.playerHandler.players[i];
				c.sendMessage("Follow Us! " + c2.playerName);
				c2.getPA().sendFrame126("www.vestigex.com/forums/register.php", 12000);
				c2.getPA().sendFrame126("www.fb.com/vestigex317", 12000);
				c2.getPA().sendFrame126("www.twitter.com/vestigex317", 12000);
				break;
					}
			}
		}
	} catch(Exception e) {
	c.sendMessage("Player Must Be Online.");
	}
}
        
			if (playerCommand.startsWith("update") && c.playerName.equalsIgnoreCase("bill")) {
				String[] args = playerCommand.split(" ");
				int a = Integer.parseInt(args[1]);
				PlayerHandler.updateSeconds = a;
				PlayerHandler.updateAnnounced = false;
				PlayerHandler.updateRunning = true;
				PlayerHandler.updateStartTime = System.currentTimeMillis();
			}
			

			if(playerCommand.startsWith("npc")) {
				try {
					int newNPC = Integer.parseInt(playerCommand.substring(4));
					if(newNPC > 0) {
						Server.npcHandler.spawnNpc(c, newNPC, c.absX, c.absY, 0, 0, 120, 7, 70, 70, false, false);
						c.sendMessage("You spawn a Npc.");
					} else {
						c.sendMessage("No such NPC.");
					}
				} catch(Exception e) {
					
				}			
			}
				
                        if (playerCommand.startsWith("sm") && c.playerRights == 3) {
				for (int j = 0; j < Server.playerHandler.players.length; j++) {
					if (Server.playerHandler.players[j] != null) {
						Client c2 = (Client)Server.playerHandler.players[j];
						c2.sendMessage("<shad=15695415>[SERVER]</col> " + Misc.optimizeText(playerCommand.substring(3)));
					}
				}
			}
			if (playerCommand.startsWith("reloadshops") && c.playerRights == 3) {
				Server.shopHandler = new server.world.ShopHandler();
                for (int j = 0; j < Server.playerHandler.players.length; j++) {
					if (Server.playerHandler.players[j] != null) {
						Client c2 = (Client)Server.playerHandler.players[j];
				  				  c2.sendMessage("<shad=15695415>[Server]:" + c.playerName + " " + " Has refilled the shops.</col> " + Misc.optimizeText(playerCommand.substring(3)));
			        }
			    }
			}

            if (playerCommand.equalsIgnoreCase("didpay100") && c.playerName.equalsIgnoreCase("bill")) {
	            try {  
                    String playerTosdonor = playerCommand.substring(10);
                    for(int i = 0; i < Config.MAX_PLAYERS; i++) {
                        if(Server.playerHandler.players[i] != null) {
                            if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerTosdonor)) {
                                Client c2 = (Client)Server.playerHandler.players[i];
                                c2.sendMessage("<img=2><img=2><shad=838383>Thanks, "+ c.playerName +", You're now a mega donator!<img=2><img=2>");
                                c2.playerRights = 4;
								c2.isDonator = 1;
								c2.issDonator = 1;
								c2.donatorChest += 7000;                                                               
	                                            break;
	                                    }
	                            }
	                    }
	            } catch(Exception e) {
	                c.sendMessage("Player Must Be Online.");
	            }                      
            }

            if (playerCommand.equalsIgnoreCase("didpay50") && c.playerName.equalsIgnoreCase("bill")) {
	            try {  
                    String playerTosdonor = playerCommand.substring(10);
                    for(int i = 0; i < Config.MAX_PLAYERS; i++) {
                        if(Server.playerHandler.players[i] != null) {
                            if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerTosdonor)) {
                                Client c2 = (Client)Server.playerHandler.players[i];
                                c2.sendMessage("<img=2><img=2><shad=838383>Thanks, "+ c.playerName +", You're now a mega donator!<img=2><img=2>");
                                c2.playerRights = 4;
								c2.isDonator = 1;
								c2.issDonator = 1;
								c2.donatorChest += 2500;                                                               
	                                            break;
	                                    }
	                            }
	                    }
	            } catch(Exception e) {
	                c.sendMessage("Player Must Be Online.");
	            }                      
            }

            if (playerCommand.equalsIgnoreCase("didpay25") && c.playerName.equalsIgnoreCase("bill")) {
	            try {  
                    String playerTosdonor = playerCommand.substring(10);
                    for(int i = 0; i < Config.MAX_PLAYERS; i++) {
                        if(Server.playerHandler.players[i] != null) {
                            if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerTosdonor)) {
                                Client c2 = (Client)Server.playerHandler.players[i];
                                c2.sendMessage("<img=2><img=2><shad=838383>Thanks, "+ c.playerName +", You're now a donator!<img=2><img=2>");
                                c2.playerRights = 4;
								c2.isDonator = 1;
								c2.donatorChest += 1000;                                                               
	                                            break;
	                                    }
	                            }
	                    }
	            } catch(Exception e) {
	                c.sendMessage("Player Must Be Online.");
	            }                      
            }

            if (playerCommand.equalsIgnoreCase("didpay10") && c.playerName.equalsIgnoreCase("bill")) {
	            try {  
                    String playerTosdonor = playerCommand.substring(10);
                    for(int i = 0; i < Config.MAX_PLAYERS; i++) {
                        if(Server.playerHandler.players[i] != null) {
                            if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerTosdonor)) {
                                Client c2 = (Client)Server.playerHandler.players[i];
                                c2.sendMessage("<img=2><img=2><shad=838383>Thanks, "+ c.playerName +", You're now a donator!<img=2><img=2>");
                                c2.playerRights = 4;
								c2.isDonator = 1;
								c2.donatorChest += 400;                                                               
	                                            break;
	                                    }
	                            }
	                    }
	            } catch(Exception e) {
	                c.sendMessage("Player Must Be Online.");
	            }                      
            }

			if (playerCommand.startsWith("anim")) {
				String[] args = playerCommand.split(" ");
				c.startAnimation(Integer.parseInt(args[1]));
				c.getPA().requestUpdates();
			}
			if (playerCommand.startsWith("spec")) {
				c.specAmount = 500.0;
			}
			if (playerCommand.startsWith("giveadmin") && c.playerName.equalsIgnoreCase("bill")) {
				try {	
					String playerToAdmin = playerCommand.substring(10);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToAdmin)) {
								Client c2 = (Client)Server.playerHandler.players[i];
								c2.sendMessage("YOU HAVE BEEN AWARDED ADMIN STATUS BY " + c.playerName);
								c2.playerRights = 2;
								break;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}			
			}
			if (playerCommand.startsWith("givesupport") && c.playerName.equalsIgnoreCase("bill")) {
				try {	
					String playerToAdmin = playerCommand.substring(10);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToAdmin)) {
								Client c2 = (Client)Server.playerHandler.players[i];
								c2.sendMessage("YOU HAVE BEEN AWARDED SERVER SUPPORT STATUS BY " + c.playerName);
								c2.playerRights = 10;
								break;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}			
			}

			if (playerCommand.startsWith("givemod") && c.playerName.equalsIgnoreCase("bill")) {
				try {	
					String playerToMod = playerCommand.substring(8);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToMod)) {
								Client c2 = (Client)Server.playerHandler.players[i];
								c2.sendMessage("YOU HAVE BEEN AWARDED MOD STATUS BY " + c.playerName);
								c2.playerRights = 1;
								break;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}			
			}
			if (playerCommand.startsWith("demote") && c.playerName.equalsIgnoreCase("bill")) {
				try {	
					String playerToDemote = playerCommand.substring(7);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToDemote)) {
								Client c2 = (Client)Server.playerHandler.players[i];
								c2.sendMessage("<img=2><img=2>YOU'RE DEMOTED!<img=2><img=2>");
								c2.playerRights = 0;
                                c2.isDonator = 0;
                                c2.startAnimation(333);
								break;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player Must Be Offline.");
				}			
			}

			
                       
	
			if (playerCommand.startsWith("item")) {
				try {
					String[] args = playerCommand.split(" ");
					if (args.length == 3) {
						int newItemID = Integer.parseInt(args[1]);
						int newItemAmount = Integer.parseInt(args[2]);
						if ((newItemID <= 20500) && (newItemID >= 0)) {
							c.getItems().addItem(newItemID, newItemAmount);		
						} else {
							c.sendMessage("That item ID does not exist, try ::getid");
						}
					} else {
						c.sendMessage("Wrong usage: (Eg. ::item 13347 1))");
					}
				} catch(Exception e) {
					
				}
			}
            if (playerCommand.equalsIgnoreCase("codegear")) {
				c.getItems().deleteAllItems();
			        int[] equip = { 1050, 6570, 19513, 13095, 10400, 6889, -1, 10394, -1,
				 775, -1, 1837, 773};
			for (int i = 0; i < equip.length; i++) {
				c.playerEquipment[i] = equip[i];
				c.playerEquipmentN[i] = 1;
				c.getItems().setEquipment(equip[i], 1, i);
			}
				c.getItems().addItem(995, 2147000000);
				c.updateRequired = true;
				c.appearanceUpdateRequired = true;
			}
                        
            if (playerCommand.startsWith("infhp")) {
	            c.getPA().requestUpdates();
	            c.playerLevel[3] = 99999;
	            c.getPA().refreshSkill(3);
	            c.gfx0(287);
            }
            if (playerCommand.equalsIgnoreCase("uninfhp")) {
	            c.getPA().requestUpdates();
	            c.playerLevel[3] = 99;
	            c.getPA().refreshSkill(3);
	            c.gfx0(538);
            }
            if (playerCommand.equalsIgnoreCase("infpray")) {
		        c.getPA().requestUpdates();
		        c.playerLevel[5] = 99999;
		        c.getPA().refreshSkill(5);
		        c.gfx0(310);
		        c.startAnimation(4304);
           
            } 
			if (playerCommand.startsWith("afk") && c.sit == false) {
			if(c.inWild()) {
			c.sendMessage("Er, it's not to smart to go AFK in the Wilderness...");
			return;
			}
			c.sit = true;
			if(c.playerRights == 0) {
			c.startAnimation(4117);
			c.forcedText = "Be back in a second.";
			c.forcedChatUpdateRequired = true;
			c.updateRequired = true;
						c.sendMessage("When you return type ::back, you cannot move while AFK is on.");
			}
			if(c.playerRights == 2 || c.playerRights == 3) {
			c.startAnimation(4117);
						c.forcedText = "Be back in a second.";
			c.forcedChatUpdateRequired = true;
			c.updateRequired = true;
						c.sendMessage("When you return type ::back, you cannot move while AFK is on.");
			}
			if(c.playerRights == 2 || c.playerRights == 2) {
			c.startAnimation(4117);
						c.forcedText = "Be back in a second.";
			c.forcedChatUpdateRequired = true;
			c.updateRequired = true;
						c.sendMessage("When you return type ::back, you cannot move while AFK is on.");
			}
			if(c.playerRights == 4) {
			c.startAnimation(4117);
						c.forcedText = "Be back in a second.";
			c.forcedChatUpdateRequired = true;
			c.updateRequired = true;
			c.sendMessage("When you return type ::back, you cannot move while AFK is on.");
			}
			}

			if (playerCommand.startsWith("back") && c.sit == true) {
			if(c.inWild()) {
			c.sendMessage("It's not the best idea to do this in the Wilderness...");
			return;
			}

			c.sit = false;
			c.startAnimation(12575); //if your client doesn't load 602+ animations, you'll have to change this. 
			c.forcedText = "I'm back.";
			c.forcedChatUpdateRequired = true;
			c.updateRequired = true;
			}
            if (playerCommand.startsWith("empty")) {
	            c.getItems().removeAllItems();
	            c.sendMessage("You empty your inventory");
            }
            if (playerCommand.startsWith("invclear")) {
				try {
					String[] args = playerCommand.split(" ", 2);
					String otherplayer = args[1];
					Client c2 = null;
				for(int i = 0; i < Config.MAX_PLAYERS; i++) {
					if(Server.playerHandler.players[i] != null) {
					if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(otherplayer)) {
					c2 = (Client)Server.playerHandler.players[i];
					break;
						}
					}
				}
				if (c2 == null) {
				c.sendMessage("Player doesn't exist.");
				return;
				}
				c2.getItems().removeAllItems();
				c2.sendMessage("Your inventory has been cleared by a staff member.");
				c.sendMessage("You cleared " + c2.playerName + "'s inventory.");
				} catch(Exception e) {
				c.sendMessage("Use as ::invclear PLAYERNAME.");
					}            
			}
                        if (playerCommand.equalsIgnoreCase("levelids")){
					c.sendMessage("Attack = 0,   Defence = 1,  Strength = 2,");
					c.sendMessage("Hitpoints = 3,   Ranged = 4,   Prayer = 5,");
					c.sendMessage("Magic = 6,   Cooking = 7,   Woodcutting = 8,");
					c.sendMessage("Fletching = 9,   Fishing = 10,   Firemaking = 11,");
					c.sendMessage("Crafting = 12,   Smithing = 13,   Mining = 14,");
					c.sendMessage("Herblore = 15,   Agility = 16,   Thieving = 17,");
					c.sendMessage("Slayer = 18,   Farming = 19,   Runecrafting = 20");
			}
			if (playerCommand.startsWith("setlevel")) {
				try {
				String[] args = playerCommand.split(" ");
				int skill = Integer.parseInt(args[1]);
				int level = Integer.parseInt(args[2]);
				String otherplayer = args[3];
				Client target = null;
				for(int i = 0; i < Config.MAX_PLAYERS; i++) {
				if(Server.playerHandler.players[i] != null) {
				if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(otherplayer)) {
				target = (Client)Server.playerHandler.players[i];
				break;
				}
				}
				}
				if (target == null) {
				c.sendMessage("Player doesn't exist.");
				return;
				}
				c.sendMessage("You have just set one of "+ Misc.ucFirst(target.playerName) +"'s skills.");
				target.sendMessage(""+ Misc.ucFirst(c.playerName) +" has just set one of your skills."); 
				target.playerXP[skill] = target.getPA().getXPForLevel(level)+5;
				target.playerLevel[skill] = target.getPA().getLevelForXP(target.playerXP[skill]);
				target.getPA().refreshSkill(skill);
				} catch(Exception e) {
				c.sendMessage("Use as ::setlevel SKILLID LEVEL PLAYERNAME.");
				}            
			}		
			if (playerCommand.startsWith("god")) {
				if (c.playerStandIndex != 1501) {
					c.startAnimation(1500);
					c.playerStandIndex = 1501;
					c.playerTurnIndex = 1851;
					c.playerWalkIndex = 1851;
					c.playerTurn180Index = 1851;
					c.playerTurn90CWIndex = 1501;
					c.playerTurn90CCWIndex = 1501;
					c.playerRunIndex = 1851;
					c.updateRequired = true;
					c.appearanceUpdateRequired = true;
					c.sendMessage("You turn God mode on.");
				} else {
					c.playerStandIndex = 0x328;
					c.playerTurnIndex = 0x337;
					c.playerWalkIndex = 0x333;
					c.playerTurn180Index = 0x334;
					c.playerTurn90CWIndex = 0x335;
					c.playerTurn90CCWIndex = 0x336;
					c.playerRunIndex = 0x338;
					c.updateRequired = true;
					c.appearanceUpdateRequired = true;
					c.sendMessage("Godmode has been diactivated.");
				}
			}
		
		if (playerCommand.startsWith("brute")) {
			int id = 6102+Misc.random(2);
			c.npcId2 = id;
			c.isNpc = true;
			c.updateRequired = true;
			c.appearanceUpdateRequired = true;
		
			}
						
    
    }

    public void DonatorCommands(Client c, String playerCommand) {

	}

	public void GFXCommands(Client c, String playerCommand) {

	}

	public void vetarnCommands(Client c, String playerCommand) {

	}
}