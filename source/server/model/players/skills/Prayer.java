package server.model.players.skills;


import server.Config;
import server.model.players.Client;
import server.model.minigames.Event;
import server.model.minigames.EventContainer;
import server.model.minigames.EventManager;
import server.model.players.Achievements;
import server.model.players.AchievementManager;
import server.model.players.AchievementExtra;

public class Prayer {

	Client c;
	
	public int[][] bonesExp = {{526,5},{532,15},{534,30},{536,72},{6729,125},{18830,600}};	
	
	public Prayer(Client c) {
		this.c = c;
	}
	
	public void buryBone(int id, int slot) {
		if(System.currentTimeMillis() - c.buryDelay > 1500) {
			c.getItems().deleteItem(id, slot, 1);
			c.sendMessage("You bury the bones.");
			c.getPA().addSkillXP(getExp(id)*Config.PRAYER_EXPERIENCE,5);
			c.buryDelay = System.currentTimeMillis();
			c.startAnimation(827);
		}	
	}
	
	public void bonesOnAltar(int id) {
	if(System.currentTimeMillis() - c.buryDelay > 1000) {
		c.getItems().deleteItem(id, c.getItems().getItemSlot(id), 1);
		c.sendMessage("The gods are pleased with your offering.");
		AchievementManager.increase(c, Achievements.PRIEST);
		c.buryDelay = System.currentTimeMillis();
		c.getPA().addSkillXP(getExp(id)*2*Config.PRAYER_EXPERIENCE, 5);
	}
	}
		public void bonesOnHouseAltar(int id) {
		if(c.COLectt > 3) {
		c.getItems().deleteItem(id, c.getItems().getItemSlot(id), 1);
		c.sendMessage("The gods are pleased with your offering.");
		c.sendMessage("You receive more XP from you're lecterns.");
		c.getPA().addSkillXP(getExp(id)*2*Config.PRAYER_EXPERIENCEINHOUSE, 5);
	} else {
	c.sendMessage("You need to have Lecterns built to do this.");
	}
	}

        private int boneAmount;
		public void bonesOnAltar2(final int id, int amount) {
			if(amount >= 1 && c.usingAltar && c.getItems().playerHasItem(id,1)) {
				if(System.currentTimeMillis() - c.buryDelay > 1000) {
				c.getItems().deleteItem(id, c.getItems().getItemSlot(id), 1);
				c.sendMessage("The gods are pleased with your offering.");
				AchievementManager.increase(c, Achievements.PRIEST);
				c.getPA().addSkillXP(getExp(id)*2*Config.PRAYER_EXPERIENCE, 5);
				c.startAnimation(713);
				if (c.absX == 3091 && c.absY == 3506) {
					c.getPA().stillGfx(624, 3092, 3506, 0, 0);
				} else if (c.absX == 3092 && c.absY == 3505) {
					c.getPA().stillGfx(624, 3092, 3506, 0, 0);
				} else if (c.absX == 3093 && c.absY == 3505) {
					c.getPA().stillGfx(624, 3093, 3506, 0, 0);
				} else if (c.absX == 3094 && c.absY == 3506) {
				c.getPA().stillGfx(624, 3093, 3506, 0, 0);
				c.buryDelay = System.currentTimeMillis();
				}
				}
			}
			amount--;
			boneAmount = amount;
                        EventManager.getSingleton().addEvent(new Event() {
			@Override
				public void execute(EventContainer altar) {
				if(System.currentTimeMillis() - c.buryDelay > 1000) {
					if (boneAmount > 0&&c.usingAltar && c.getItems().playerHasItem(id,1)) {
						boneAmount--; 
						c.getItems().deleteItem(id, c.getItems().getItemSlot(id), 1);
						c.sendMessage("The gods are pleased with your offering.");
						AchievementManager.increase(c, Achievements.PRIEST);
						c.getPA().addSkillXP(getExp(id)*2*Config.PRAYER_EXPERIENCE, 5);
						c.startAnimation(713);
						c.buryDelay = System.currentTimeMillis();
						if (c.absX == 3091 && c.absY == 3506) {
							c.getPA().stillGfx(624, 3092, 3506, 0, 0);
						} else if (c.absX == 3092 && c.absY == 3505) {
							c.getPA().stillGfx(624, 3092, 3506, 0, 0);
						} else if (c.absX == 3093 && c.absY == 3505) {
							c.getPA().stillGfx(624, 3093, 3506, 0, 0);
						} else if (c.absX == 3094 && c.absY == 3506) {
							c.getPA().stillGfx(624, 3093, 3506, 0, 0);
						}
					} else 
						altar.stop();
						}
				}
				public void stop() {
					c.usingAltar=false;	
				}
			}, 6);
		
		}
	
	public boolean isBone(int id) {
		for (int j = 0; j < bonesExp.length; j++)
			if (bonesExp[j][0] == id)
				return true;
		return false;
	}
	
	public int getExp(int id) {
		for (int j = 0; j < bonesExp.length; j++) {
			if (bonesExp[j][0] == id)
				return bonesExp[j][1];
		}
		return 0;
	}
}