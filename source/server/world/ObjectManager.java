package server.world;

import java.util.ArrayList;

import server.model.objects.Object;
import server.util.Misc;
import server.model.players.Client;
import server.Server;

/**
 * @author Sanity
 */

public class ObjectManager {

	public ArrayList<Object> objects = new ArrayList<Object>();
	private ArrayList<Object> toRemove = new ArrayList<Object>();
	public void process() {
		for (Object o : objects) {
			if (o.tick > 0)
				o.tick--;
			else {
				updateObject(o);
				toRemove.add(o);
			}		
		}
		for (Object o : toRemove) {
			if (isObelisk(o.newId)) {
				int index = getObeliskIndex(o.newId);
				if (activated[index]) {
					activated[index] = false;
					teleportObelisk(index);
				}
			}
			objects.remove(o);	
		}
		toRemove.clear();
	}
	public void removeObject(int x, int y) {
		for (int j = 0; j < Server.playerHandler.players.length; j++) {
			if (Server.playerHandler.players[j] != null) {
				Client c = (Client)Server.playerHandler.players[j];
				c.getPA().object(-1, x, y, 0, 10);			
			}	
		}	
	}
	
	public void updateObject(Object o) {
		for (int j = 0; j < Server.playerHandler.players.length; j++) {
			if (Server.playerHandler.players[j] != null) {
				Client c = (Client)Server.playerHandler.players[j];
				c.getPA().object(o.newId, o.objectX, o.objectY, o.face, o.type);			
			}	
		}	
	}
	
	public void placeObject(Object o) {
		for (int j = 0; j < Server.playerHandler.players.length; j++) {
			if (Server.playerHandler.players[j] != null) {
				Client c = (Client)Server.playerHandler.players[j];
				if (c.distanceToPoint(o.objectX, o.objectY) <= 60)
					c.getPA().object(o.objectId, o.objectX, o.objectY, o.face, o.type);
			}	
		}
	}
	
	public Object getObject(int x, int y, int height) {
		for (Object o : objects) {
			if (o.objectX == x && o.objectY == y && o.height == height)
				return o;
		}	
		return null;
	}
	
	public void loadObjects(Client c) {
		if (c == null)
			return;
		for (Object o : objects) {
			if (loadForPlayer(o,c))
				c.getPA().object(o.objectId, o.objectX, o.objectY, o.face, o.type);
		}
		loadCustomSpawns(c);
		if (c.distanceToPoint(2813, 3463) <= 60) {
			//c.getFarming().updateHerbPatch();
		}
	}
	
	private int[][] customObjects = {{}};
	public void loadCustomSpawns(Client c) { 

	/***VESTIGE-X***\
	\***OBJECTMAN***/
	
	
	c.getPA().checkObjectSpawn(-1, 3312, 3235, 0, 0);//DuelArenaGate
	c.getPA().checkObjectSpawn(-1, 3312, 3234, 0, 0);//DuelArenaGate
	c.getPA().checkObjectSpawn(-1, 3183, 3434, 0, 0);//VarrockBankStairsDoor
	
	c.getPA().checkObjectSpawn(-1, 2421, 4677, 0, 10);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2425, 4675, 0, 10);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2406, 4683, 0, 10);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2411, 4685, 0, 10);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2411, 4686, 0, 10);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2410, 4686, 0, 10);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2412, 4686, 0, 10);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2405, 4676, 0, 10);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2406, 4676, 0, 10);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2407, 4676, 0, 10);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2406, 4677, 0, 10);//Remove-Column
	
	c.getPA().checkObjectSpawn(-1, 2421, 4677, 0, 2);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2425, 4675, 0, 2);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2406, 4683, 0, 2);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2411, 4685, 0, 2);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2411, 4686, 0, 2);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2410, 4686, 0, 2);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2412, 4686, 0, 2);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2405, 4676, 0, 2);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2406, 4676, 0, 2);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2407, 4676, 0, 2);//Remove-Column
	c.getPA().checkObjectSpawn(-1, 2406, 4677, 0, 2);//Remove-Column
	
	c.getPA().checkObjectSpawn(2644, 2742, 3443, 0, 10);
	
	//EndOfCustomsCave
//startnewdungbill
	c.getPA().checkObjectSpawn(-1, 2527, 3306, 0, 10);//RemoveDungeoneeringNew
	c.getPA().checkObjectSpawn(-1, 2535, 3306, 0, 10);//RemoveDungeoneeringNew
	c.getPA().checkObjectSpawn(-1, 2527, 3304, 0, 10);//RemoveDungeoneeringNew
	c.getPA().checkObjectSpawn(-1, 2535, 3304, 0, 10);//RemoveDungeoneeringNew
	c.getPA().checkObjectSpawn(26972, 2527, 3305, 3, 10);//Bank booth
	c.getPA().checkObjectSpawn(26972, 2527, 3306, 3, 10);//Bank booth
	c.getPA().checkObjectSpawn(26972, 2527, 3304, 3, 10);//Bank booth
	
	c.getPA().checkObjectSpawn(26972, 2531, 3306, 3, 10);//Bank booth
	c.getPA().checkObjectSpawn(26972, 2531, 3305, 3, 10);//Bank booth
	c.getPA().checkObjectSpawn(26972, 2531, 3304, 3, 10);//Bank booth
	
	c.getPA().checkObjectSpawn(26972, 2530, 3303, 2, 10);//Bank booth
	c.getPA().checkObjectSpawn(26972, 2528, 3303, 2, 10);//Bank booth
	c.getPA().checkObjectSpawn(26972, 2528, 3307, 2, 10);//Bank booth
	c.getPA().checkObjectSpawn(26972, 2529, 3307, 2, 10);//Bank booth
	c.getPA().checkObjectSpawn(26972, 2530, 3307, 2, 10);//Bank booth
//dunend         
          c.getPA().checkObjectSpawn(11190, 2936, 3281, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2936, 3282, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2936, 3283, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2936, 3284, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2698, 9836, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2698, 9837, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2698, 9838, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2698, 9839, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2698, 9840, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2698, 9841, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2698, 9842, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2707, 9840, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2707, 9841, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2707, 9842, 0, 10);
          c.getPA().checkObjectSpawn(11190, 2707, 9843, 0, 10);
         
          /*StaffZone*/
 
 
          c.getPA().checkObjectSpawn(-1, 1863, 5343, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1863, 5344, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1863, 5345, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1863, 5346, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1863, 5347, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1863, 5348, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1863, 5349, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1863, 5350, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1863, 5351, 0, 10);
 
          c.getPA().checkObjectSpawn(-1, 1864, 5343, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1864, 5344, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1864, 5345, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1864, 5346, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1864, 5347, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1864, 5348, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1864, 5349, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1864, 5350, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1864, 5351, 0, 10);
          c.getPA().checkObjectSpawn(-1, 1862, 5350, 0, 10);
	  
	  
	  c.getPA().checkObjectSpawn(11190, 2403, 4675, 0, 10);
	  c.getPA().checkObjectSpawn(11190, 2403, 4676, 0, 10);
	  c.getPA().checkObjectSpawn(11190, 2403, 4677, 0, 10);
	  c.getPA().checkObjectSpawn(11190, 2403, 4678, 0, 10);
	  c.getPA().checkObjectSpawn(11190, 2403, 4679, 0, 10);
	  c.getPA().checkObjectSpawn(11190, 2403, 4680, 0, 10);
	  c.getPA().checkObjectSpawn(11190, 2403, 4681, 0, 10);
	  c.getPA().checkObjectSpawn(11190, 2403, 4682, 0, 10);
	  c.getPA().checkObjectSpawn(11190, 2403, 4683, 0, 10);
	  c.getPA().checkObjectSpawn(11190, 2403, 4684, 0, 10);
	  c.getPA().checkObjectSpawn(11190, 2403, 4685, 0, 10);
	  c.getPA().checkObjectSpawn(12768, 3547, 3563, 0, 10);
	  
	  c.getPA().checkObjectSpawn(-1, 3546, 3563, 0, 10);
	  c.getPA().checkObjectSpawn(-1, 3549, 3563, 0, 10);
	  c.getPA().checkObjectSpawn(-1, 3606, 3564, 0, 10);
	
	
	
        c.getPA().checkObjectSpawn(-1, 2964, 3206, 0, 2);//Door
        c.getPA().checkObjectSpawn(-1, 2956, 3212, 0, 10);//Center well
        c.getPA().checkObjectSpawn(-1, 2967, 3205, 0, 10);//Colodron
        c.getPA().checkObjectSpawn(-1, 2968, 3207, 0, 10);//Chair
        c.getPA().checkObjectSpawn(-1, 2967, 3207, 0, 10);//Table
        c.getPA().checkObjectSpawn(-1, 2967, 3203, 0, 10);//Fireplace
        c.getPA().checkObjectSpawn(-1, 2970, 3206, 0, 10);//rocky chair
        c.getPA().checkObjectSpawn(-1, 2970, 3205, 0, 10);//Broom
        c.getPA().checkObjectSpawn(-1, 2970, 3204, 0, 10);//Table
        c.getPA().checkObjectSpawn(-1, 2969, 3203, 0, 10);//Bed
        c.getPA().checkObjectSpawn(-1, 2965, 3204, 0, 10);//Table
        c.getPA().checkObjectSpawn(-1, 2965, 3203, 0, 10);//wardrobe1
        c.getPA().checkObjectSpawn(-1, 2970, 3208, 0, 10);//Wardrobe2
        c.getPA().checkObjectSpawn(-1, 2965, 3208, 0, 10);//Wardrobe3
        c.getPA().checkObjectSpawn(-1, 2967, 3208, 0, 10);//Shelf1
        c.getPA().checkObjectSpawn(-1, 2968, 3208, 0, 10);//Shelf2
        c.getPA().checkObjectSpawn(-1, 2969, 3208, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3219, 3436, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3220, 3436, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3219, 3437, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3220, 3437, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3180, 3437, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3180, 3438, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3180, 3442, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3180, 3443, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3180, 3433, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3180, 3444, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3180, 3447, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3181, 3447, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3182, 3447, 0, 10);//Shelf3
        c.getPA().checkObjectSpawn(-1, 3183, 3447, 0, 10);//Shelf3


        c.getPA().checkObjectSpawn(2403, 3210, 3428, 3, 10); //RFD CHEST
        c.getPA().checkObjectSpawn(12356, 3210, 3430, 3, 10); //RFD PORTAL
		c.getPA().checkObjectSpawn(410, 3206, 3437, 2, 10); //lunar altar varrock
		c.getPA().checkObjectSpawn(6552, 3218, 3438, 2, 10); //ancient altar varrock

        c.getPA().checkObjectSpawn(26972, 2969, 3208, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2966, 3208, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(-1, 2965, 3215, 0, 10);//Stairs
        c.getPA().checkObjectSpawn(-1, 2611, 3096, 0, 10);//Stairs
        c.getPA().checkObjectSpawn(-1, 2612, 3096, 0, 10);//Stairs
        c.getPA().checkObjectSpawn(-1, 2612, 3097, 0, 10);//Stairs
        c.getPA().checkObjectSpawn(-1, 2611, 3088, 0, 10);//Stairs
        c.getPA().checkObjectSpawn(-1, 2612, 3097, 0, 10);//Stairs
        //Brand new Shopping center
        c.getPA().checkObjectSpawn(-1, 2948, 3203, 0, 10);//table
        c.getPA().checkObjectSpawn(-1, 2947, 3204, 0, 10);//table2
        c.getPA().checkObjectSpawn(-1, 2947, 3207, 0, 10);//small table
        c.getPA().checkObjectSpawn(-1, 2951, 3205, 0, 10);//Clothes
        c.getPA().checkObjectSpawn(-1, 2951, 3204, 0, 10);//Clothes
        c.getPA().checkObjectSpawn(-1, 2951, 3203, 0, 10);//Clothes
        c.getPA().checkObjectSpawn(-1, 2951, 3202, 0, 10);//Clothes
        c.getPA().checkObjectSpawn(-1, 2946, 3207, 0, 10);//crate
        c.getPA().checkObjectSpawn(-1, 2947, 3208, 0, 10);//crate
        c.getPA().checkObjectSpawn(-1, 2946, 3208, 0, 10);//crate
        c.getPA().checkObjectSpawn(-1, 2946, 3202, 0, 10);//crate
        c.getPA().checkObjectSpawn(-1, 2962, 3207, 0, 10);//Tree
        c.getPA().checkObjectSpawn(-1, 2958, 3207, 0, 10);//Bench
        c.getPA().checkObjectSpawn(-1, 2952, 3211, 0, 10);//Bench
        c.getPA().checkObjectSpawn(-1, 2946, 3202, 0, 10);//crate
		//Bills Home Zone
		c.getPA().checkObjectSpawn(-1, 2613, 3081, 0, 10);//removeshoproom
		c.getPA().checkObjectSpawn(-1, 2614, 3084, 0, 10);//removeshoproom
		c.getPA().checkObjectSpawn(-1, 2616, 3081, 0, 10);//removeshoproom
		c.getPA().checkObjectSpawn(-1, 2616, 3080, 0, 10);//removeshoproom
		c.getPA().checkObjectSpawn(-1, 2614, 3078, 0, 10);//removeshoproom
		c.getPA().checkObjectSpawn(-1, 2613, 3077, 0, 10);//removeshoproom
		c.getPA().checkObjectSpawn(-1, 2613, 3078, 0, 10);//removeshoproom
		c.getPA().checkObjectSpawn(-1, 2610, 3080, 0, 10);//removeshoproom
		c.getPA().checkObjectSpawn(-1, 2611, 3080, 0, 10);//removeshoproom
		c.getPA().checkObjectSpawn(-1, 2610, 3081, 0, 10);//removeshoproom
		c.getPA().checkObjectSpawn(-1, 2609, 3096, 0, 10);//removebankroom
		c.getPA().checkObjectSpawn(-1, 2609, 3089, 0, 10);//removebankroom
		c.getPA().checkObjectSpawn(-1, 2611, 3095, 0, 10);//removebankroom
		c.getPA().checkObjectSpawn(-1, 2602, 3092, 0, 10);//removebankroom
		c.getPA().checkObjectSpawn(-1, 2601, 3094, 0, 10);//removebankroom
		c.getPA().checkObjectSpawn(-1, 2603, 3082, 0, 22);//removethievdoor
		c.getPA().checkObjectSpawn(-1, 2603, 3082, 0, 9);//removethievdoor
		c.getPA().checkObjectSpawn(-1, 2603, 3082, 0, 10);//removethievdoor
		c.getPA().checkObjectSpawn(-1, 2605, 3081, 0, 10);//removethievdoor
		c.getPA().checkObjectSpawn(-1, 2606, 3081, 0, 10);//removethievdoor
		c.getPA().checkObjectSpawn(-1, 2607, 3081, 0, 10);//removethievdoor
		c.getPA().checkObjectSpawn(-1, 2607, 3077, 0, 10);//removethievdoor
        c.getPA().checkObjectSpawn(13405, 2597, 3087, 3, 10);//Portal
        c.getPA().checkObjectSpawn(13405, 2060, 3262, 0, 10);//Portal2
        c.getPA().checkObjectSpawn(26972, 2059, 3262, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2062, 3262, 2, 10);//Bank booth
		c.getPA().checkObjectSpawn(-1, 2951, 3222, 0, 10);//old Portal
		c.getPA().checkObjectSpawn(-1, 2966, 3212, 0, 10);//table
        c.getPA().checkObjectSpawn(-1, 2969, 3216, 0, 2);//Door
        c.getPA().checkObjectSpawn(-1, 2967, 3216, 0, 2);//Wall
        c.getPA().checkObjectSpawn(-1, 2967, 3215, 0, 2);//Wall2
        c.getPA().checkObjectSpawn(-1, 2968, 3216, 0, 2);//Wall
        c.getPA().checkObjectSpawn(-1, 2968, 3215, 0, 2);//Wall2
		//smithing
		c.getPA().checkObjectSpawn(3044, 3304, 3292, 3, 10);
        c.getPA().checkObjectSpawn(2783, 3301, 3292, 0, 10);
        c.getPA().checkObjectSpawn(2783, 3301, 3296, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2966, 3213, 0, 10);//chair
		c.getPA().checkObjectSpawn(-1, 2967, 3213, 0, 10);//chair
		c.getPA().checkObjectSpawn(-1, 2966, 3211, 0, 10);//chair
		c.getPA().checkObjectSpawn(-1, 2967, 3211, 0, 10);//chair
		c.getPA().checkObjectSpawn(-1, 2970, 3212, 0, 10);//piano
		c.getPA().checkObjectSpawn(-1, 2970, 3214, 0, 10);//table
        c.getPA().checkObjectSpawn(-1, 2964, 3209, 0, 10);//chest
		c.getPA().checkObjectSpawn(-1, 2963, 3209, 0, 10);//hat
		c.getPA().checkObjectSpawn(-1, 2963, 3215, 0, 10);//plant
		c.getPA().checkObjectSpawn(-1, 2966, 3209, 0, 10);//table
		c.getPA().checkObjectSpawn(-1, 2966, 3209, 0, 10);//sink
		c.getPA().checkObjectSpawn(-1, 2970, 3209, 0, 10);//Range
		c.getPA().checkObjectSpawn(-1, 2970, 3216, 0, 10);//plant
		c.getPA().checkObjectSpawn(-1, 2969, 3212, 0, 10);//Piano stool
		c.getPA().checkObjectSpawn(-1, 2963, 3216, 0, 10);//Corner table
		c.getPA().checkObjectSpawn(-1, 2968, 3208, 0, 10);//shelf1
		c.getPA().checkObjectSpawn(-1, 2969, 3208, 0, 10);//shelf2
        //booths
        c.getPA().checkObjectSpawn(26972, 2970, 3215, 1, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2970, 3214, 1, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2970, 3213, 1, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2970, 3211, 1, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2970, 3210, 1, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2969, 3209, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2968, 3209, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2967, 3209, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2966, 3209, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2963, 3215, 1, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2965, 3209, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2964, 3209, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2963, 3211, 1, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2963, 3210, 1, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2970, 3212, 1, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2964, 3216, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2965, 3216, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2966, 3216, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2967, 3216, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2420, 4689, 2, 10);//Bank booth
        c.getPA().checkObjectSpawn(26972, 2421, 4689, 2, 10);//Bank booth
        //corners
        c.getPA().checkObjectSpawn(26969, 2970, 3216, 0, 10);//Bank Deposit box
        c.getPA().checkObjectSpawn(26969, 2970, 3209, 0, 10);//Bank Deposit box
        c.getPA().checkObjectSpawn(26969, 2963, 3209, 0, 10);//Bank Deposit box
        c.getPA().checkObjectSpawn(26969, 2963, 3212, 1, 10);//Bank Deposit box 
        c.getPA().checkObjectSpawn(26969, 2968, 3216, 0, 10);//Bank Deposit box 
        c.getPA().checkObjectSpawn(26969, 2963, 3214, 1, 10);//Bank Deposit box 
        c.getPA().checkObjectSpawn(26969, 2963, 3216, 1, 10);//Bank Deposit box      
        //END bank
        //home removes + lunar isle
        c.getPA().checkObjectSpawn(-1, 2104, 3911, 1, 10);
        c.getPA().checkObjectSpawn(-1, 3088, 3509, 0, 10);
        c.getPA().checkObjectSpawn(-1, 3092, 3488, 0, 10);
        c.getPA().object(6951, 2583, 9896, 2, 10);
		c.getPA().object(6951, 2578, 9899, 2, 10);
		c.getPA().object(6951, 2572, 9895, 2, 10);
		c.getPA().object(6951, 2577, 9894, 2, 10);
		c.getPA().object(6951, 2580, 9894, 2, 10);
		c.getPA().object(6951, 2577, 9893, 2, 10);
		c.getPA().object(6951, 2578, 9893, 2, 10);
		c.getPA().object(6951, 2579, 9893, 2, 10);
		c.getPA().object(6951, 2580, 9893, 2, 10);
		c.getPA().object(6951, 2585, 9895, 2, 10);
		c.getPA().checkObjectSpawn(27254, 3214, 3212, 2, 10); //score
		c.getPA().checkObjectSpawn(16152, 2861, 3546, 1, 10); //block
		//dungeoneering
		c.getPA().checkObjectSpawn(4412, 3251, 9335, 1, 10);
		c.getPA().checkObjectSpawn(4412, 3233, 9334, 1, 10);
		c.getPA().checkObjectSpawn(4412, 3220, 9328, 1, 10);
		c.getPA().checkObjectSpawn(1, 3212, 9334, 1, 10);
		c.getPA().checkObjectSpawn(7318, 3212, 9333, 1, 10);
		c.getPA().checkObjectSpawn(1, 3207, 9329, 1, 10);
		c.getPA().checkObjectSpawn(1, 3207, 9328, 1, 10);
		c.getPA().checkObjectSpawn(1, 3230, 9332, 1, 10);
		c.getPA().checkObjectSpawn(1, 3229, 9332, 1, 10);
		c.getPA().checkObjectSpawn(1, 3223, 9334, 1, 10);
		c.getPA().checkObjectSpawn(1, 3223, 9333, 1, 10);
		c.getPA().checkObjectSpawn(6553, 3218, 9328, 2, 10);
		c.getPA().checkObjectSpawn(6553, 3218, 9327, 2, 10);
		c.getPA().checkObjectSpawn(-1, 3261, 9329, -1, 10);
		c.getPA().checkObjectSpawn(-1, 3233, 9322, -1, 10);
		c.getPA().checkObjectSpawn(409, 3238, 9315, 3, 10); // Normal praying altar
		c.getPA().checkObjectSpawn(410, 3229, 9315, 0, 10); //lunar altar
		c.getPA().checkObjectSpawn(-1, 3232, 9314, 2, 10); // Removing that lion thing in lobby
		c.getPA().checkObjectSpawn(-1, 3233, 9314, 2, 10); // Removing that chair thing in lobby
		c.getPA().checkObjectSpawn(-1, 3234, 9314, 2, 10); // Removing that lion thing in lobby
		c.getPA().checkObjectSpawn(6553, 3261, 9330, 1, 10);
		c.getPA().checkObjectSpawn(6553, 3260, 9330, 1, 10);
		c.getPA().checkObjectSpawn(6553, 3215, 9311, 2, 10);
		c.getPA().checkObjectSpawn(6553, 3215, 9310, 2, 10);
		c.getPA().checkObjectSpawn(6553, 3245, 9333, 2, 10);
		c.getPA().checkObjectSpawn(6553, 3245, 9334, 2, 10);
		c.getPA().checkObjectSpawn(411, 3230, 9320, 2, 10);
		c.getPA().checkObjectSpawn(4641, 3239, 9293, 2, 10);
		c.getPA().checkObjectSpawn(4641, 3239, 9294, 2, 10);
		c.getPA().checkObjectSpawn(4641, 3233, 9289, 2, 10);
		c.getPA().checkObjectSpawn(4641, 3232, 9289, 2, 10);
		c.getPA().checkObjectSpawn(4641, 3218, 9302, 2, 10);
		c.getPA().checkObjectSpawn(4641, 3218, 9303, 2, 10);
        c.getPA().checkObjectSpawn(1277, 2049, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2050, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2051, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2052, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2053, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2054, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2055, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2056, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2057, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2058, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2059, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2060, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2061, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2062, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2063, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2064, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2065, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2066, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2067, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2068, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2069, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2070, 3217, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3217, 0, 10);
        c.getPA().checkObjectSpawn(2561, 2667, 3310, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2048, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2049, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2050, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2051, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2052, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2053, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2054, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2055, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2056, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2057, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2058, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2059, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2060, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2061, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2062, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2063, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2064, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2065, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2066, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2067, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2068, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2069, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2070, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3245, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3246, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3247, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3248, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3249, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3250, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3251, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3252, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3253, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3254, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3255, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3256, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3257, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3258, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3259, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3260, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3261, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3262, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3263, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3245, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3246, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3247, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3248, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3249, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3250, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3251, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3252, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3253, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3254, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3255, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3256, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3257, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3258, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3259, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3260, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3261, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3262, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3263, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2048, 3244, 0, 10);

		c.getPA().checkObjectSpawn(2996, 3180, 3436, 3, 10);//crystal chest varrock

		c.getPA().checkObjectSpawn(1277, 2049, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2050, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2051, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2052, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2053, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2054, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2055, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2056, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2057, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2058, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2059, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2060, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2061, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2062, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2063, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2064, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2065, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2066, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2067, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2068, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2069, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2070, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3244, 0, 10);
        c.getPA().checkObjectSpawn(2561, 2667, 3310, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2048, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2049, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2050, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2051, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2052, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2053, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2054, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2055, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2056, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2057, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2058, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2059, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2060, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2061, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2062, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2063, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2064, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2065, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2066, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2067, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2068, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2069, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2070, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3243, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3245, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3246, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3247, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3248, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3249, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3250, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3251, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3252, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3253, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3254, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3255, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3256, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3257, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3258, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3259, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3260, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3261, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3262, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2071, 3263, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3244, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3245, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3246, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3247, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3248, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3249, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3250, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3251, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3252, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3253, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3254, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3255, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3256, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3257, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3258, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3259, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3260, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3261, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3262, 0, 10);
		c.getPA().checkObjectSpawn(1277, 2072, 3263, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2069, 3247, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2065, 3247, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2061, 3247, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2057, 3247, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2053, 3247, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2049, 3247, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2067, 3248, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2063, 3248, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2059, 3248, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2055, 3248, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2051, 3248, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2069, 3249, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2065, 3249, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2061, 3249, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2057, 3249, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2053, 3249, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2049, 3249, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2067, 3250, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2063, 3250, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2059, 3250, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2055, 3250, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2051, 3250, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2069, 3251, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2065, 3251, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2061, 3251, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2057, 3251, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2053, 3251, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2049, 3251, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2067, 3252, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2063, 3252, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2059, 3252, 0, 10);		
		c.getPA().checkObjectSpawn(11214, 2055, 3252, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2051, 3252, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2069, 3253, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2065, 3253, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2061, 3253, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2057, 3253, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2053, 3253, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2049, 3253, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2067, 3254, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2063, 3254, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2059, 3254, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2055, 3254, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2051, 3254, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2069, 3255, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2065, 3255, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2061, 3255, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2057, 3255, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2053, 3255, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2049, 3255, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2067, 3256, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2063, 3256, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2059, 3256, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2055, 3256, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2051, 3256, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2069, 3257, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2065, 3257, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2061, 3257, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2057, 3257, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2053, 3257, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2049, 3257, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2067, 3258, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2063, 3258, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2059, 3258, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2055, 3258, 0, 10);
		c.getPA().checkObjectSpawn(11214, 2051, 3258, 0, 10);
		c.getPA().checkObjectSpawn(-1, 3270, 3161, 0, 10); // Mining Gold ore
		c.getPA().checkObjectSpawn(-1, 3271, 3161, 0, 10); // Mining Gold ore
		c.getPA().checkObjectSpawn(-1, 3270, 3163, 0, 10); // Mining Gold ore
		c.getPA().checkObjectSpawn(-1, 3271, 3163, 0, 10); // Mining Gold ore
		c.getPA().checkObjectSpawn(3994, 3270, 3162, 0, 10); // Mining Gold ore
		c.getPA().checkObjectSpawn(2098, 3296, 3287, 0, 10); // Mining Gold ore
		c.getPA().checkObjectSpawn(2098, 3297, 3288, 0, 10); // Mining Gold ore
		c.getPA().checkObjectSpawn(2092, 3300, 3286, 0, 10); // Mining iron ore
		c.getPA().checkObjectSpawn(2092, 3300, 3287, 0, 10); // Mining iron ore
		c.getPA().checkObjectSpawn(2092, 3301, 3301, 0, 10); // Mining iron ore
		c.getPA().checkObjectSpawn(2092, 3302, 3302, 0, 10); // Mining iron ore
		c.getPA().checkObjectSpawn(2092, 3302, 3309, 0, 10); // Mining iron ore
		c.getPA().checkObjectSpawn(2092, 3303, 3310, 0, 10); // Mining iron ore
		c.getPA().checkObjectSpawn(2092, 3297, 3310, 0, 10); // Mining iron ore
		c.getPA().checkObjectSpawn(2092, 3296, 3312, 0, 10); // Mining iron ore
		c.getPA().checkObjectSpawn(2100, 3303, 3313, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(2100, 3293, 3300, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(2100, 3294, 3301, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(2100, 3295, 3303, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(2100, 3303, 3312, 0, 10); // Mining silver ore
		
		
		c.getPA().checkObjectSpawn(2100, 3303, 3312, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2404, 4685, 0, 10); // Mining silver ore
		
		
		c.getPA().checkObjectSpawn(11190, 2405, 4685, 0, 10); // Mining silver ore
		
		c.getPA().checkObjectSpawn(11190, 2404, 4682, 0, 10); // Mining silver ore
		
		c.getPA().checkObjectSpawn(11190, 2404, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2405, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2406, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2407, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2405, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2406, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2407, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2409, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2410, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2411, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2412, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2413, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2414, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2415, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2416, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2417, 4686, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2418, 4686, 0, 10); // Mining silver ore
		
		
		
		
		c.getPA().checkObjectSpawn(11190, 2408, 4674, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4676, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4677, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4678, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4679, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4680, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4681, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4682, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4683, 0, 10); // Mining silver ore
		
		
		
		c.getPA().checkObjectSpawn(11190, 2409, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2410, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2411, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2412, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2413, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2414, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2415, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2416, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2417, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2418, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2419, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2420, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2421, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2422, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2423, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2424, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2425, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2426, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2427, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2428, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2429, 4675, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2429, 4676, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2429, 4677, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2429, 4678, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2429, 4679, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2429, 4680, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2429, 4681, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2429, 4682, 0, 10); // Mining silver ore
		
		
		c.getPA().checkObjectSpawn(11190, 2405, 4682, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2406, 4682, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2407, 4682, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4682, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2409, 4682, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2404, 4683, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2405, 4683, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2406, 4683, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2407, 4683, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4683, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2409, 4683, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2404, 4684, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2405, 4684, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2406, 4684, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2407, 4684, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4684, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2409, 4684, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2406, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2407, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2408, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2409, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2412, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2410, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2411, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2413, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2414, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2415, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2416, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2417, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2418, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2419, 4685, 0, 10); // Mining silver ore
		c.getPA().checkObjectSpawn(11190, 2419, 4686, 0, 10); // Mining silver ore
		
		
		c.getPA().checkObjectSpawn(6551, 3297, 3311, 0, 10); // Mining teleport to eccense
		c.getPA().checkObjectSpawn(-1, 3090, 3496, 0, 10); // Edgeville bank removeing objects in bank Chair
		c.getPA().checkObjectSpawn(-1, 3092, 3496, 0, 10); // Edgeville bank removeing objects in bank Chair
		c.getPA().checkObjectSpawn(-1, 3091, 3495, 0, 10); // Edgeville bank removeing objects in bank Table
		c.getPA().checkObjectSpawn(-1, 2809, 3463, 0, 10); // Farming patch remove THE SINGLE ONE
		c.getPA().checkObjectSpawn(-1, 2806, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2806, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2805, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2819, 3463, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2805, 3466, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2806, 3466, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2805, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2804, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2804, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2803, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2803, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2809, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2809, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2808, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2808, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2807, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2807, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2814, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2814, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2813, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2813, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2812, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2812, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2810, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2810, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2811, 3467, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2811, 3468, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2808, 3460, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2808, 3459, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2807, 3459, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2807, 3460, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2806, 3460, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2806, 3461, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2806, 3459, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2805, 3459, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2805, 3461, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2805, 3460, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2804, 3459, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2804, 3460, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2812, 3459, 0, 10); // Farming patch remove
		c.getPA().checkObjectSpawn(-1, 2812, 3460, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2811, 3460, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2811, 3459, 0, 10);
		c.getPA().checkObjectSpawn(-1, 2809, 3460, 0, 10); // Farming patch remove
		c.getPA().checkObjectSpawn(-1, 2813, 3460, 0, 10); // Farming patch remove
		c.getPA().checkObjectSpawn(-1, 2813, 3459, 0, 10); // Farming patch remove
		c.getPA().checkObjectSpawn(-1, 2810, 3460, 0, 10); // Farming patch remove
		c.getPA().checkObjectSpawn(-1, 2810, 3459, 0, 10); // Farming patch remove
		c.getPA().checkObjectSpawn(-1, 2814, 3460, 0, 10); // Farming patch remove
		c.getPA().checkObjectSpawn(-1, 2814, 3459, 0, 10); // Farming patch remove
		c.getPA().checkObjectSpawn(-1, 2809, 3459, 0, 10); // Farming patch remove
		c.getPA().checkObjectSpawn(-1, 2819, 3462, 0, 10); // Farming table remove
		c.getPA().checkObjectSpawn(2152, 3451, 3514, 0, 10); //SUMMON OBELISK
		c.getPA().checkObjectSpawn(14367, 3333, 3333, 2, 10); // VARROCK HOMEBANK 1
		c.getPA().checkObjectSpawn(14367, 3333, 3333, 2, 10); // VARROCK HOMEBANK 2
		c.getPA().checkObjectSpawn(411, 3215, 3438, 2, 10); // Curse Prayers
		c.getPA().checkObjectSpawn(1596, 3008, 3849, -1, 0);
		c.getPA().checkObjectSpawn(-1, 3217, 3436, -1, 10); //remvoe portal
		c.getPA().checkObjectSpawn(-1, 3220, 3437, -1, 10); //remvoe  stall varrock
		c.getPA().checkObjectSpawn(409, 3209, 3438, 0, 10); // Normal praying altar
		c.getPA().checkObjectSpawn(7273, 3204, 3857, -1, 10); //remvoe portal

		c.getPA().checkObjectSpawn(7315, 3217, 3437, 1, 10);//funpk teleporter

		c.getPA().checkObjectSpawn(411, 3095, 3506, 2, 10); // Curse Prayers
		c.getPA().checkObjectSpawn(409, 3092, 3506, 2, 10); // Normal praying altar
		c.getPA().checkObjectSpawn(410, 3098, 3503, 0, 10); //lunar altar
		c.getPA().checkObjectSpawn(6552, 3095, 3500, 0, 10); //ancient altar

		c.getPA().checkObjectSpawn(4874, 3242, 2908, 0, 10);//thiev staff
		c.getPA().checkObjectSpawn(4875, 3240, 2908, 0, 10);//thiev stall
		c.getPA().checkObjectSpawn(4876, 3238, 2908, 0, 10);//thiev stall
		c.getPA().checkObjectSpawn(4877, 3236, 2908, 0, 10);//thiev stall
		c.getPA().checkObjectSpawn(4878, 3234, 2908, 0, 10);//thiev stall

		c.getPA().checkObjectSpawn(-1, 3508, 9494, -1, 10); //remvoe portal
		c.getPA().checkObjectSpawn(-1, 3508, 9494, -2, 10); //remvoe portal
		c.getPA().checkObjectSpawn(-1, 2841, 4828, -1, 10); //remvoe portal
		//c.getPA().checkObjectSpawn(1, 2842, 4829, 1, 10); //CRATES AIR ALTAR FIX
		//c.getPA().checkObjectSpawn(1, 2842, 4828, 1, 10); //CRATES AIR ALTAR FIX
		//c.getPA().checkObjectSpawn(1, 2842, 4827, 1, 10); //CRATES AIR ALTAR FIX
		//c.getPA().checkObjectSpawn(1, 2841, 4827, 1, 10); //CRATES AIR ALTAR FIX
		//c.getPA().checkObjectSpawn(1, 2840, 4827, 1, 10); //CRATES AIR ALTAR FIX
		//c.getPA().checkObjectSpawn(1, 2840, 4828, 1, 10); //CRATES AIR ALTAR FIX
		//c.getPA().checkObjectSpawn(1, 2840, 4829, 1, 10); //CRATES AIR ALTAR FIX
		//c.getPA().checkObjectSpawn(-1, 2841, 4828, -1, 10); //CRATES AIR ALTAR FIX
		c.getPA().checkObjectSpawn(-1, 2574, 4850, -1, 10); //REMOVE fire altar teleport rc
		c.getPA().checkObjectSpawn(-1, 3090, 3503, -1, 10); //REMOVE DEPOSIT BOX
		c.getPA().checkObjectSpawn(-1, 3095, 3499, -1, 10); //REMOVE CHAIR IN BANK
		c.getPA().checkObjectSpawn(-1, 3095, 3498, -1, 10); //REMOVE TABLE IN BANK
		c.getPA().checkObjectSpawn(-1, 3078, 3510, -1, 10); //REMOVE TABLE IN SHOP
		c.getPA().checkObjectSpawn(-1, 3080, 3510, -1, 10); //REMOVE BOXES in shop
		c.getPA().checkObjectSpawn(-1, 3077, 3512, -1, 10); //REMOVE STEPLADDERS
		c.getPA().checkObjectSpawn(-1, 3081, 3510, -1, 10); //REMOVE TABLE IN SHOP
		c.getPA().checkObjectSpawn(-1, 3098, 3496, -1, 10); //REMOVE TREE AT HOME
		c.getPA().checkObjectSpawn(-1, 3096, 3501, -1, 10); //REMOVE TREE AT HOME
		//START OF NOMAD MINIGAME
		c.getPA().checkObjectSpawn(400, 3487, 9948, 1, 10); //Nomad gravestones
		c.getPA().checkObjectSpawn(400, 3488, 9948, 1, 10); //Nomad gravestones
		c.getPA().checkObjectSpawn(400, 3493, 9938, 1, 10); //Nomad gravestones
		c.getPA().checkObjectSpawn(400, 3493, 9937, 1, 10); //Nomad gravestones
		c.getPA().checkObjectSpawn(400, 3482, 9937, 1, 10); //Nomad gravestones
		c.getPA().checkObjectSpawn(400, 3481, 9937, 1, 10); //Nomad gravestones
		c.getPA().checkObjectSpawn(400, 3480, 9937, 1, 10); //Nomad gravestones
		c.getPA().checkObjectSpawn(400, 3477, 9945, 1, 10); //Nomad gravestones
		c.getPA().checkObjectSpawn(400, 3477, 9944, 1, 10); //Nomad gravestones
		c.getPA().checkObjectSpawn(400, 3477, 9943, 1, 10); //Nomad gravestones
		c.getPA().checkObjectSpawn(1, 2933, 9654, 1, 10); //Nomad CRATE
		c.getPA().checkObjectSpawn(1, 2933, 9655, 1, 10); //Nomad CRATE
		c.getPA().checkObjectSpawn(1, 2934, 9648, 1, 10); //Nomad CRATE
		c.getPA().checkObjectSpawn(1, 2500, 3018, 1, 10); //Nomad CRATE
		c.getPA().checkObjectSpawn(1, 2501, 3018, 1, 10); //Nomad CRATE
		c.getPA().checkObjectSpawn(1, 2505, 3012, 1, 10); //Nomad CRATE
		c.getPA().checkObjectSpawn(1, 2505, 3011, 1, 10); //Nomad CRATE
		//c.getPA().checkObjectSpawn(11, 2936, 9647, 1, 10); //Nomad LADDer
		//c.getPA().checkObjectSpawn(11, 2936, 9655, 1, 10); //Nomad LADDer
		//c.getPA().checkObjectSpawn(11, 2937, 9655, 1, 10); //Nomad LADDer
		//c.getPA().checkObjectSpawn(11, 2938, 9655, 1, 10); //Nomad LADDer
		//c.getPA().checkObjectSpawn(11, 2935, 9655, 1, 10); //Nomad LADDer
		//c.getPA().checkObjectSpawn(11, 2934, 9655, 1, 10); //Nomad LADDer*/
		c.getPA().checkObjectSpawn(11, 2498, 3014, 1, 10); //Nomad SPIRIT TREE
		//END OF NOMAD MINIGAME
		//remove edge well
		c.getPA().checkObjectSpawn(-1, 3084, 3502, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3085, 3502, 1, 10);
		//removed
		//START OF GOBLIN MINIGAME ANGRY
		c.getPA().checkObjectSpawn(672, 2539, 3032, 1, 10); //GOBLIN BARREL
		c.getPA().checkObjectSpawn(718, 2539, 3033, 1, 10); //GOBLIN BARREL
		c.getPA().checkObjectSpawn(2024, 2540, 3036, 1, 10); //GOBLIN ESCAPE
		c.getPA().checkObjectSpawn(2024, 2541, 3036, 1, 10); //GOBLIN ESCAPE
		c.getPA().checkObjectSpawn(2024, 2540, 3029, 1, 10); //GOBLIN ESCAPE
		c.getPA().checkObjectSpawn(2024, 2541, 3029, 1, 10); //GOBLIN ESCAPE
		c.getPA().checkObjectSpawn(2024, 2541, 3029, 1, 10); //GOBLIN ESCAPE
		c.getPA().checkObjectSpawn(2024, 2542, 3029, 1, 10); //GOBLIN ESCAPE
		c.getPA().checkObjectSpawn(2024, 2543, 3029, 1, 10); //GOBLIN ESCAPE
		c.getPA().checkObjectSpawn(2024, 2544, 3029, 1, 10); //GOBLIN ESCAPE
		c.getPA().checkObjectSpawn(2024, 2545, 3029, 1, 10); //GOBLIN ESCAPE
		//END OF GOBLIN MINIGAME
		c.getPA().checkObjectSpawn(4151, 2605, 3153, 1, 10); //portal home FunPk
		c.getPA().checkObjectSpawn(2619, 2602, 3156, 1, 10); //barrel FunPk
		c.getPA().checkObjectSpawn(1032, 2605, 3156, 2, 10); //warning sign FunPk
		c.getPA().checkObjectSpawn(1032, 2603, 3156, 2, 10); //warning sign FunPk
		c.getPA().checkObjectSpawn(1032, 2602, 3155, 1, 10); //warning sign FunPk
		c.getPA().checkObjectSpawn(1032, 2602, 3153, 1, 10); //warning sign FunPk
		c.getPA().checkObjectSpawn(1032, 2536, 4778, 0, 10); //warning sign donor
		c.getPA().checkObjectSpawn(1032, 2537, 4777, 1, 10); //warning sign donor
		c.getPA().checkObjectSpawn(1032, 2536, 4776, 2, 10); //warning sign donor
		c.getPA().checkObjectSpawn(7315, 2536, 4777, 0, 10); //funpk portals
		c.getPA().checkObjectSpawn(7316, 2605, 3153, 0, 10); //funpk portals
		c.getPA().checkObjectSpawn(4008, 2851, 2965, 1, 10); //spec alter
		c.getPA().checkObjectSpawn(11356, 2610, 3104, 0, 10); //frost dragon portals
	/*	c.getPA().checkObjectSpawn(194, 2423, 3525, 0, 10); //Dungeoneering Rock
		c.getPA().checkObjectSpawn(23, 2385, 4719, 0, 10); //Dungeoneering sack
		c.getPA().checkObjectSpawn(23, 2384, 4719, 0, 10); //Dungeoneering sack
		c.getPA().checkObjectSpawn(16081, 1879, 4620, 0, 10); //Dungeoneering lvl 1 tele
		c.getPA().checkObjectSpawn(2014, 1921, 4640, 0, 10); //Dungeoneering Money
		c.getPA().checkObjectSpawn(16078, 1869, 4622, 0, 10); //Dungeoneering Rope
		c.getPA().checkObjectSpawn(2930, 2383, 4714, 3, 10); //Dungeoneering Boss 1 door
		c.getPA().checkObjectSpawn(1032, 2382, 4714, 1, 10); //warning sign FunPk
	//	c.getPA().checkObjectSpawn(11356, 3087, 3483, 0, 10); //Frost drags portal
		c.getPA().checkObjectSpawn(79, 3044, 5105, 1, 10); //dungie blocker
		c.getPA().checkObjectSpawn(9767, 2000, 4636, 0, 10); //slave blocker floor 1
		c.getPA().checkObjectSpawn(9767, 2001, 4636, 0, 10); //slave blocker floor 1
		c.getPA().checkObjectSpawn(9767, 1999, 4637, 0, 10); //slave blocker floor 1
		c.getPA().checkObjectSpawn(9767, 2002, 4636, 0, 10); //slave blocker floor 1
		c.getPA().checkObjectSpawn(10778, 2867, 9530, 1, 10); //dung floor 4 portal
		c.getPA().checkObjectSpawn(7272, 3233, 9316, 1, 10); //dung floor 5 portal
		c.getPA().checkObjectSpawn(4408, 2869, 9949, 1, 10); //dung floor 6 portalEND
		c.getPA().checkObjectSpawn(410, 1860, 4625, 1, 10); //dung floor 6 portalEND
		c.getPA().checkObjectSpawn(9947, 1914, 4639, 0, 10); // pillar dung floor 1
		c.getPA().checkObjectSpawn(6552, 1859, 4617, 1, 10); //dung floor 6 portalEND
		c.getPA().checkObjectSpawn(7318, 2772, 4454, 1, 10); //dung floor 7 portalEND
		c.getPA().checkObjectSpawn(4412, 1919, 4640, 0, 10); //escape ladder
		c.getPA().checkObjectSpawn(4412, 3048, 5233, 0, 10); //escape ladder*/
		c.getPA().checkObjectSpawn(195, 2980, 5111, 0, 10); //escape ladder
		c.getPA().checkObjectSpawn(4412, 2867, 9527, 0, 10); //escape ladder
		c.getPA().checkObjectSpawn(4412, 3234, 9327, 0, 10); //escape ladder
		c.getPA().checkObjectSpawn(4412, 2387, 4721, 0, 10); //escape ladder
		//start of dungkill
		c.getPA().checkObjectSpawn(3379, 2410, 3531, 0, 10); //dung kill cave
		//end of dung kill portal
		c.getPA().checkObjectSpawn(4412, 2790, 9328, 0, 10); //escape ladder
		c.getPA().checkObjectSpawn(4412, 3229, 9312, 0, 10); //escape ladder
		c.getPA().checkObjectSpawn(4412, 2805, 4440, 0, 10); //escape ladder
		c.getPA().checkObjectSpawn(4412, 2744, 4453, 0, 10); //escape ladder
		c.getPA().checkObjectSpawn(4412, 2427, 9411, 0, 10); //escape ladder
		c.getPA().checkObjectSpawn(2465, 2426, 9415, 0, 10); //escape ladder
        c.getPA().checkObjectSpawn(2094, 3032, 9836, 0, 10);
        c.getPA().checkObjectSpawn(2094, 3033, 9836, 0, 10);
        c.getPA().checkObjectSpawn(2091, 3034, 9836, 0, 10);
        c.getPA().checkObjectSpawn(2091, 3035, 9836, 0, 10);
        c.getPA().checkObjectSpawn(2092, 3036, 9836, 0, 10);
        c.getPA().checkObjectSpawn(2092, 3037, 9836, 0, 10);
        c.getPA().checkObjectSpawn(2103, 3038, 9836, 0, 10);
        c.getPA().checkObjectSpawn(2103, 3039, 9836, 0, 10);
        c.getPA().checkObjectSpawn(2097, 3040, 9836, 0, 10);
        c.getPA().checkObjectSpawn(2097, 3041, 9836, 0, 10);
        c.getPA().checkObjectSpawn(14859, 3042, 9836, 0, 10);
		c.getPA().checkObjectSpawn(14859, 3043, 9836, 0, 10);
        c.getPA().checkObjectSpawn(3044, 3036, 9831, -1, 10);
		c.getPA().checkObjectSpawn(2213, 3037, 9835, -1, 10);
        c.getPA().checkObjectSpawn(2783, 3034, 9832, 0, 10);
		c.getPA().checkObjectSpawn(-1, 3077, 3495, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3077, 3496, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3079, 3501, 1, 10);
		c.getPA().checkObjectSpawn(-1, 3080, 3501, 1, 10);
		//c.getPA().checkObjectSpawn(2286, 2598, 4778, 1, 10);
		c.getPA().checkObjectSpawn(12356, 2845, 2957, 1, 10);
		c.getPA().checkObjectSpawn(2996, 2854, 2962, 1, 10);//al key chest
		c.getPA().checkObjectSpawn(14859, 2839, 3439, 0, 10);//runite ore skilling.
	    c.getPA().checkObjectSpawn(14859, 2520, 4773, 0, 10);//runite ore donor.
		c.getPA().checkObjectSpawn(14859, 2518, 4775, 0, 10);//runite ore donor.
		c.getPA().checkObjectSpawn(14859, 3298, 3308, 0, 10);//runite ore  mining spot
		c.getPA().checkObjectSpawn(14859, 2518, 4774, 0, 10);//runite ore donor.
		c.getPA().checkObjectSpawn(13617, 2384, 9899, 3, 10); //Barrelportal donor	
		//c.getPA().checkObjectSpawn(411, 3374, 9806, 2, 10); // Curse Prayers
		c.getPA().checkObjectSpawn(13615, 2525, 4770, 2, 10); // hill giants donor
		c.getPA().checkObjectSpawn(13620, 2384, 9895, 3, 10); // steel drags donor
		c.getPA().checkObjectSpawn(13619, 2384, 9891, 3, 10); // tormented demons donor
		c.getPA().checkObjectSpawn(6163, 2029, 4527, 1, 10);
		c.getPA().checkObjectSpawn(6165, 2029, 4529, 1, 10);
		c.getPA().checkObjectSpawn(6166, 2029, 4531, 1, 10);
		c.getPA().checkObjectSpawn(410, 2864, 2955, 1, 10); 
		// CAMELOT WOODCUTTING
		c.getPA().checkObjectSpawn(1281, 2712, 3465, 0, 10);//OAK TREE CAMELOT WC
		c.getPA().checkObjectSpawn(1277, 2709, 3466, 0, 10);//NORMAL TREE CAMELOT WC
		c.getPA().checkObjectSpawn(1306, 2710, 3459, 0, 10);//MAGIC TREE CAMELOT WC
		//end of camelot woodcutting
		c.getPA().checkObjectSpawn(4874, 2849, 2995, 1, 10);
		c.getPA().checkObjectSpawn(4875, 2849, 2996, 1, 10);
		c.getPA().checkObjectSpawn(4876, 2849, 2997, 0, 10);
		c.getPA().checkObjectSpawn(4877, 2849, 2998, 0, 10);
		c.getPA().checkObjectSpawn(4878, 2849, 2999, 0, 10);	
		c.getPA().checkObjectSpawn(1596, 3008, 3850, 1, 0);
		c.getPA().checkObjectSpawn(1596, 3008, 3849, -1, 0);
		c.getPA().checkObjectSpawn(1596, 3040, 10307, -1, 0);
		c.getPA().checkObjectSpawn(1596, 3040, 10308, 1, 0);
		c.getPA().checkObjectSpawn(1596, 3022, 10311, -1, 0);
		c.getPA().checkObjectSpawn(1596, 3022, 10312, 1, 0);
		c.getPA().checkObjectSpawn(1596, 3044, 10341, -1, 0);
		c.getPA().checkObjectSpawn(1596, 3044, 10342, 1, 0);
		c.getPA().checkObjectSpawn(6552, 2842, 2954, 1, 10); //ancient prayers
		c.getPA().checkObjectSpawn(409, 2852, 2950, 2, 10);
		c.getPA().checkObjectSpawn(409, 2530, 4779, 3, 10);
		c.getPA().checkObjectSpawn(2213, 3047, 9779, 1, 10);
		c.getPA().checkObjectSpawn(2213, 3080, 9502, 1, 10);
		c.getPA().checkObjectSpawn(2213, 2516, 4780, 1, 10);
		c.getPA().checkObjectSpawn(2213, 2516, 4775, 1, 10);
		c.getPA().checkObjectSpawn(1530, 3093, 3487, 1, 10);
		c.getPA().checkObjectSpawn(2213, 2855, 3439, -1, 10);
		c.getPA().checkObjectSpawn(2090, 2839, 3440, -1, 10);
		c.getPA().checkObjectSpawn(2094, 2839, 3441, -1, 10);
		c.getPA().checkObjectSpawn(2092, 2839, 3442, -1, 10);
		c.getPA().checkObjectSpawn(2096, 2839, 3443, -1, 10);
		c.getPA().checkObjectSpawn(2102, 2839, 3444, -1, 10);
		c.getPA().checkObjectSpawn(2105, 2839, 3445, 0, 10);
		c.getPA().checkObjectSpawn(1278, 2843, 3442, 0, 10);
		c.getPA().checkObjectSpawn(1281, 2844, 3499, 0, 10);
		c.getPA().checkObjectSpawn(4156, 3083, 3440, 0, 10);
		c.getPA().checkObjectSpawn(1308, 2846, 3436, 0, 10);
		c.getPA().checkObjectSpawn(1309, 2846, 3439, -1, 10);
		c.getPA().checkObjectSpawn(1306, 2850, 3439, -1, 10);
		c.getPA().checkObjectSpawn(2783, 2841, 3436, 0, 10);
		c.getPA().checkObjectSpawn(2728, 2861, 3429, 0, 10);
		c.getPA().checkObjectSpawn(2728, 2429, 9416, 0, 10);//cooking range dung!
		c.getPA().checkObjectSpawn(3044, 2857, 3427, -1, 10);
		c.getPA().checkObjectSpawn(320, 3048, 10342, 0, 10);
		
		//NewDonorZone-MadeByBill
		
		//adds
		c.getPA().checkObjectSpawn(104, 2396, 9896, 3, 10); //Donatorchest
		c.getPA().checkObjectSpawn(2996, 2396, 9899, 3, 10); //DonatorCChest
		c.getPA().checkObjectSpawn(409, 2393, 9909, 2, 10); //donatoraltar
		c.getPA().checkObjectSpawn(410, 2398, 9907, 2, 10); //Donatoraltar
		c.getPA().checkObjectSpawn(411, 2389, 9909, 2, 10); //Donatoraltar
		c.getPA().checkObjectSpawn(6552, 2387, 9907, 1, 10); //Donatoraltar
		c.getPA().checkObjectSpawn(2213, 2391, 9909, 2, 10); //Donatorbank
		c.getPA().checkObjectSpawn(2213, 2392, 9909, 2, 10); //Donatorbank
		c.getPA().checkObjectSpawn(2213, 2097, 3164, 2, 10); //Donatorbank
		c.getPA().checkObjectSpawn(13660, 3198, 3419, 2, 10); //Pokeball
		
		
		//removes
		c.getPA().checkObjectSpawn(-1, 2389, 9907, -1, 10);//woodenDefence
		c.getPA().checkObjectSpawn(-1, 2394, 9907, -1, 10);//woodenDefence
		c.getPA().checkObjectSpawn(-1, 2395, 9908, -1, 10);//woodenCrate
		c.getPA().checkObjectSpawn(-1, 2397, 9902, -1, 10);//woodenCrates
		c.getPA().checkObjectSpawn(-1, 2396, 9905, -1, 10);//glider
		c.getPA().checkObjectSpawn(-1, 2388, 9902, -1, 10);//gliderlever
		c.getPA().checkObjectSpawn(-1, 2384, 9902, -1, 10);//glider
		c.getPA().checkObjectSpawn(-1, 2383, 9904, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2397, 9891, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2400, 9890, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2383, 9905, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2388, 9898, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2384, 9894, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2388, 9894, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2388, 9890, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2384, 9890, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2388, 9886, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2384, 9886, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2387, 9881, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2394, 9883, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2396, 9884, -1, 10);//WoodenCrates
		c.getPA().checkObjectSpawn(-1, 2384, 9881, -1, 10);//WoodenCrates
		
		
		/*MegaZone*/

		
		
		c.getPA().checkObjectSpawn(6552, 2131, 4914, 2, 10);
		c.getPA().checkObjectSpawn(104, 2118, 9414, 3, 10); 
		c.getPA().checkObjectSpawn(410, 2122, 4911, 2, 10);
		c.getPA().checkObjectSpawn(411, 2122, 4917, 2, 10);
		c.getPA().checkObjectSpawn(409, 2126, 4916, 3, 10);
		c.getPA().checkObjectSpawn(-1, 2128, 4915, -1, 0);
		c.getPA().checkObjectSpawn(-1, 2128, 4922, -1, 0);
		c.getPA().checkObjectSpawn(-1, 2129, 4921, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2129, 4920, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2129, 4925, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2129, 4926, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2129, 4927, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2130, 4920, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2130, 4925, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2130, 4927, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2131, 4925, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2131, 4926, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2131, 4927, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2132, 4919, -1, 0);
		c.getPA().checkObjectSpawn(-1, 2132, 4925, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2132, 4926, -1, 10);
		c.getPA().checkObjectSpawn(2996, 2135, 4907, 3, 10);
		c.getPA().checkObjectSpawn(-1, 2141, 4922, -1, 0);

		
		
		
		
		
		//end
		c.getPA().checkObjectSpawn(-1, 2844, 3440, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2846, 3437, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2840, 3439, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2841, 3443, -1, 10);
		c.getPA().checkObjectSpawn(-1, 2851, 3438, -1, 10);

	 if (c.heightLevel == 0) {
			//c.getPA().checkObjectSpawn(2492, 2911, 3614, 1, 10);
		 }else{
			c.getPA().checkObjectSpawn(-1, 2911, 3614, 1, 10);
	}
	}
	
	public final int IN_USE_ID = 14825;
	public boolean isObelisk(int id) {
		for (int j = 0; j < obeliskIds.length; j++) {
			if (obeliskIds[j] == id)
				return true;
		}
		return false;
	}
	public int[] obeliskIds = {14829,14830,14827,14828,14826,14831};
	public int[][] obeliskCoords = {{3154,3618},{3225,3665},{3033,3730},{3104,3792},{2978,3864},{3305,3914}};
	public boolean[] activated = {false,false,false,false,false,false};
	
	public void startObelisk(int obeliskId) {
		int index = getObeliskIndex(obeliskId);
		if (index >= 0) {
			if (!activated[index]) {
				activated[index] = true;
				addObject(new Object(14825, obeliskCoords[index][0], obeliskCoords[index][1], 0, -1, 10, obeliskId,16));
				addObject(new Object(14825, obeliskCoords[index][0] + 4, obeliskCoords[index][1], 0, -1, 10, obeliskId,16));
				addObject(new Object(14825, obeliskCoords[index][0], obeliskCoords[index][1] + 4, 0, -1, 10, obeliskId,16));
				addObject(new Object(14825, obeliskCoords[index][0] + 4, obeliskCoords[index][1] + 4, 0, -1, 10, obeliskId,16));
			}
		}	
	}
	
	public int getObeliskIndex(int id) {
		for (int j = 0; j < obeliskIds.length; j++) {
			if (obeliskIds[j] == id)
				return j;
		}
		return -1;
	}
	
	public void teleportObelisk(int port) {
		int random = Misc.random(5);
		while (random == port) {
			random = Misc.random(5);
		}
		for (int j = 0; j < Server.playerHandler.players.length; j++) {
			if (Server.playerHandler.players[j] != null) {
				Client c = (Client)Server.playerHandler.players[j];
				int xOffset = c.absX - obeliskCoords[port][0];
				int yOffset = c.absY - obeliskCoords[port][1];
				if (c.goodDistance(c.getX(), c.getY(), obeliskCoords[port][0] + 2, obeliskCoords[port][1] + 2, 1)) {
					c.getPA().startTeleport2(obeliskCoords[random][0] + xOffset, obeliskCoords[random][1] + yOffset, 0);
				}
			}		
		}
	}
	
	public boolean loadForPlayer(Object o, Client c) {
		if (o == null || c == null)
			return false;
		return c.distanceToPoint(o.objectX, o.objectY) <= 60 && c.heightLevel == o.height;
	}
	
	public void addObject(Object o) {
		if (getObject(o.objectX, o.objectY, o.height) == null) {
			objects.add(o);
			placeObject(o);
		}	
	}




}