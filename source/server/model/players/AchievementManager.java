package server.model.players;

import server.CycleEvent;
import server.CycleEventContainer;
import server.CycleEventHandler;
import server.model.players.Client;
import server.model.players.PlayerSave;

public class AchievementManager {

public static final int MAX_ACHIEVEMENTS = 100;

private static final int[] REQUIRED_AMOUNT = {100, 1, 1, 1, 10, 1, 500, 10, 100, 1, 50, 1, 1, 1, 1, 1, 300, 1, 1, 1, 1, 100, 100, 200, 30, 50, 1, 1, 10, 1000, 1, 50, 15, 200, 150, 500, 1, 250, 1, 1};

private static final int[] ACHIEVEMENT_POINTS = { 5, 1, 10, 1, 20, 5, 50, 50, 100, 10, 10, 3, 3, 3, 3, 3, 100, 5, 10, 250, 10, 5, 150, 400, 30, 25, 10, 10, 50, 50, 20, 100, 100, 100, 100, 100, 150, 200, 200, 100};

private static final String[] ACHIEVEMENT_NAME = { "Hungry?", "PokeMaster", "Not Afraid", "Banking", "Catch Em All", "Treasure", "Mad Treasure", "Dedication", "Veteran", "Prayer", "PrayerMaster", "Cursed", "Purity", "Modern", "Ancient", "Lunar", "Priest", "Help Me", "Guitar", "Donor Tab", "Home Tele", "Tele Home", "Yak Hunter", "Rockcrab Hunter", "Vesbeast Slayer", "Patience", "Summon Me", "Splashing Out", "Pika", "Pika Pika", "Venturing Out", "Tormentor", "Pokemon Trainer", "Pokemon Killer", "Woodcutter", "Fire Starter", "Nomads Boss", "Fishy Feelin'", "Angry Goblin", "Ah, That Arena"};

private static final String[] ACHIEVEMENT = { "Eat any food 100 times", "Kill Zapdos", "Dont Be Afraid", "Visit The Bank", "Catch Em All", "Open The C Chest", "Open The C Chest x 500", "Play 10 Hours", "Play Enough to Be A Vet", "Recharge Your Prayer", "Prayer Master", "Cursed", "Purity", "Modern", "Ancient", "Switch to Lunar", "Use 300 Bones", "Call for help", "Air Guitar", "Open The Donor Tab", "Teleport Home", "Teleport Home x 100", "Kill 100 Yaks", "Kill 200 Rockcrabs", "Slay Vesbeast x 30", "Gnome Course x 50", "Create A Pouch", "Buy A Custom", "Kill Pikachu x 10", "Pikaaaa", "Uknown? Leggo.", "TD's x 50", "Pokemon Mini x ?", "Kill ? Pokemon", "Cut ? Trees", "Make 500 Fires", "Nomad Minigame", "Catch ? Fish", "Angry Goblin", "Arena?"};
			
			
	public static void increase(final Client c, int achievement) {
		c.achievement[achievement]++;
		
		if (c.achievement[achievement] == REQUIRED_AMOUNT[achievement]) {
			c.achieved[achievement] = true;
			c.sendMessage("<col=176>Congratulations! You've completed the achievement <col=129>" + ACHIEVEMENT_NAME[achievement] + "!");
			c.achievementPoints += ACHIEVEMENT_POINTS[achievement];
			c.sendMessage("<col=176>You recieve " + ACHIEVEMENT_POINTS[achievement]	+ " points! <col=146>You now have the total of " + c.achievementPoints + " achievement points.");
			c.getPA().sendFrame126("You completed the achievement\\n" + ACHIEVEMENT_NAME[achievement] + "!", 25136);
			c.hasAchieved = true;
			c.getPA().showInterface(25133);
			
			AchievementExtra.addExtra(c, achievement);
			PlayerSave.saveGame(c);
			CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
				@Override
				public void execute(CycleEventContainer container) {
					c.hasAchieved = false;
					container.stop();
				}
				@Override
				public void stop() {

				}
			}, 5);
		}
	}

	public static void writeInterface(Client c) {
		for (int i = 0; i < ACHIEVEMENT.length; i++) {
			c.getPA().sendFrame126("" + (c.achieved[i] ? "" : "@red@") + "" + ACHIEVEMENT[i] + "", 25141 + i);
		}
		c.getPA().sendFrame126("You currently have\\n"+c.achievementPoints+" achievement points.", 25131);
		c.getPA().showInterface(25139);
	}
}