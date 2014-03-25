package server;
import server.model.npcs.*;

public class Config {

	public static final int[] RUNE_ECC 		=	{1436};
	public static final int[] DUNG_ARM 		=	{19893,19892,15786,15797,15837,15892,16185,16153,15808,15914,15925,15936,16013,16035,16127,16262,16002,16046,16057,16068,16105};
	public static final int[] ITEM_SELLABLE 		=	{3807,4056,4062,4063,4630,4632,4631,4640,4641,4642,4643,4644,4648,4649,4650,4651,4652,13196,13197,13198,20079,19934,9926,19935,20116,20117,20118,20119,20120,20121,20122,20123,20124,20125,20126,20127,20128,20129,20130,20131,20132,20133,20134,20135,20136,20137,20138,20139,20140,20141,20142,20143,20144,20145,20146,20147,20148,20149,20150,20151,20152,20153,20154,4084,9898,15017,2528,19140,19141,19138,19139,19142,19954,17951,17949,17947,17945,17943,17941,17939,17937,17935,19709,18508,18509,18510,15121,19111,1436,18353,18355,18357,18351,18349,681,1438,1440,1442,1444,1446,1448,13630,19281,10724,10725,10726,10727,10728,10735,13661,15241,13263,15432,15435,18359,18335,18509,18363,18355,18357,18361,12747,3842,3844,3840,8844,8845,8846,8847,8848,8849,8850,10551,6570,7462,7461,7460,7459,7458,7457,7456,7455,7454,7453,8839,8840,8842,11663,11664,11665,10499,9748,9754,9751,9769,9757,9760,9763,9802,9808,9784,9799,9805,9781,9796,9793,9775,9772,9778,9787,9811,9766,9749,9755,9752,9770,9758,9761,9764,9803,9809,9785,9800,9806,9782,9797,9794,9776,9773,9779,9788,9812,9767,9747,9753,9750,9768,9756,9759,9762,9801,9807,9783,9798,9804,9780,9795,9792,9774,9771,9777,9786,9810,9765,995,4202,6465}; // what items can't be sold in any store
	public static final int[] ITEM_TRADEABLE 		= 	{3807,4056,4062,4063,4630,4632,4631,4640,4641,4642,4643,4644,4648,4649,4650,4651,4652,13196,13197,13198,20079,19934,9926,19935,20116,20117,20118,20119,20120,20121,20122,20123,20124,20125,20126,20127,20128,20129,20130,20131,20132,20133,20134,20135,20136,20137,20138,20139,20140,20141,20142,20143,20144,20145,20146,20147,20148,20149,20150,20151,20152,20153,20154,4084,15017,9898,2528,19790,19140,19141,19138,19139,19142,19954,17951,17949,17947,17945,17943,17941,17939,17937,17935,19709,18508,18509,18510,15121,19111,1436,18353,18355,18357,18349,18351,681,1438,1440,1442,1444,1446,1448,13630,10724,19281,10725,10726,10727,10728,10735,13661,15241,13263,15432,15435,18359,18335,18509,18363,18361,18355,18357,15332,15333,15334,15335,15312,15313,15314,15315,15316,15317,15318,15319,15320,15321,15322,15323,15324,15325,15326,15327,15308,15309,15310,15311,9948,6575,9949,9950,8850,10551,8839,8840,8842,11663,11664,11665,3842,3844,3840,8844,8845,8846,8847,8848,8849,8850,10551,6570,7462,7461,7460,7459,7458,7457,7456,7455,7454,7453,8839,8840,8842,11663,11664,11665,10499,9748,9754,9751,9769,9757,9760,9763,9802,9808,9784,9799,9805,9781,9796,9793,9775,9772,9778,9787,9811,9766,9749,9755,9752,9770,9758,9761,9764,9803,9809,9785,9800,9806,9782,9797,9794,9776,9773,9779,9788,9812,9767,9747,9753,9750,9768,9756,9759,9762,9801,9807,9783,9798,9804,9780,9795,9792,9774,9771,9777,9786,9810,9765,4202,6465,12158,12159,12160,12161,12157,12156,12162,12163,12164,12165,12166,12167,19785,19786,12169,12170,12171,20072,12744,12747,12745,12748,15398}; // what items can't be traded or staked
	public static final int[] UNDROPPABLE_ITEMS 	= 	{3807,4056,4062,4063,4630,4632,4631,4640,4641,4642,4643,4644,4648,4649,4650,4651,4652,13196,13197,13198,20079,19934,9926,19935,20116,20117,20118,20119,20120,20121,20122,20123,20124,20125,20126,20127,20128,20129,20130,20131,20132,20133,20134,20135,20136,20137,20138,20139,20140,20141,20142,20143,20144,20145,20146,20147,20148,20149,20150,20151,20152,20153,20154,4084,15107,2528,9898,19790,19140,19141,19138,19139,19142,19954,17951,17949,17947,17945,17943,17941,17939,17937,17935,19709,18508,18509,18510,15121,19111,1436,18349,681,19281,15398,6575}; // what items can't be dropped
	public static final int[] FUN_WEAPONS	=	{2460,2461,2462,2463,2464,2465,2466,2467,2468,2469,2470,2471,2471,2473,2474,2475,2476,2477,}; // fun weapons for dueling
	public static final int[] CAT_ITEMS	=	{1555,6909,1556,12007,1557,1558,1559,1560,1561,1562,1563,1564,1565,7585,7584,12470,12472,12474,12513,12515,12517,12519,12521,12523,12476,18651}; // Cat Spawns	
	public static final int[] UNDEAD_NPCS = {90,91,92,93,94,103,104,73,74,75,76,77}; // undead npcs
	public static final int CLIENT_VERSION = 2;
	public static final int ITEM_LIMIT = 50000;
	public static final int MAXITEM_AMOUNT = Integer.MAX_VALUE;
	public static final int BANK_SIZE = 700;
	public static final int MAX_PLAYERS = 1024;
	public static final int MAX_NPCS = 1024;
	public static final int CLIENT_UID = 26342;//99735086
	public static final int CONNECTION_DELAY = 100;
	public static final int IPS_ALLOWED = 2;	
	public static final int MELEE_EXP_RATE = 1500;
	public static final int RANGE_EXP_RATE = 1500;
	public static final int MAGIC_EXP_RATE = 1700;
	public static final int INCREASE_SPECIAL_AMOUNT = 17500;
	public static final int INCREASE_SPECIAL_AMOUNT_WITH_RING = 10000;
	public static final int GOD_SPELL_CHARGE = 300000;
	public static final int SAVE_TIMER = 30;
	public static final int NPC_RANDOM_WALK_DISTANCE = 3;
	public static final int NPC_FOLLOW_DISTANCE = 30;											
	public static final int START_LOCATION_X = 3195;
	public static final int START_LOCATION_Y = 3429;
	public static final int RESPAWN_X = 3195;
	public static final int RESPAWN_Y = 3429;
	public static final int DUELING_RESPAWN_X = 3358; // when dead in duel area spawn here
	public static final int DUELING_RESPAWN_Y = 3269;
	public static final int RANDOM_DUELING_RESPAWN = 5; // random coords
	public static final int NO_TELEPORT_WILD_LEVEL = 20; // level you can't tele on and above
	public static final int SKULL_TIMER = 5000; // how long does the skull last? seconds x 2
	public static final int TELEBLOCK_DELAY = 200000; // how long does teleblock last for.

	public static int MESSAGE_DELAY = 6000;

	public static final boolean SERVER_DEBUG = false;//needs to be false for Real world to work
	public static final boolean WORLD_LIST_FIX = false; //true stops world--8
	public static final boolean ALLOWPINS = true;
    public static final boolean DEBUG_SOF_REWARDS = false;
	public static final boolean SINGLE_AND_MULTI_ZONES = true;
	public static final boolean COMBAT_LEVEL_DIFFERENCE = true; // wildy levels and combat level differences matters
	public static final boolean itemRequirements = true;
	public static final boolean PRAYER_POINTS_REQUIRED = true; // you need prayer points to use prayer
	public static final boolean PRAYER_LEVEL_REQUIRED = true; // need prayer level to use different prayers
	public static final boolean MAGIC_LEVEL_REQUIRED = true; // need magic level to cast spell
	public static final boolean RUNES_REQUIRED = true; // magic rune required?
	public static final boolean CORRECT_ARROWS = true; // correct arrows for bows?
	public static final boolean CRYSTAL_BOW_DEGRADES = false; // magic rune required?
	
	public static boolean LOCK_EXPERIENCE = false;
	public static boolean MINI_GAMES = true;
	public static boolean DOUBLE_EXP = true;
	public static boolean ADMIN_CAN_TRADE = true;
	public static boolean ADMIN_CAN_SELL_ITEMS = false;
	public static boolean ADMIN_DROP_ITEMS = false;
	
	public static String SERVER_NAME = "Vestige-x";
	public static String LOGOUT_MESSAGE = "Click here to logout!";
	public static String DEATH_MESSAGE = "Oh dear you are dead!";

	public static final String WELCOME_MESSAGE = "Welcome to Vestige-x ALPHA, Report ALL Bugs/Glitches On Forums.";
	public static final String FORUMS = "www.Vestigex.com";
	
	public static final double SERVER_EXP_BONUS = 1;
		

	/**
	 * Barrows Reward
	 */
	
	
	/**
	 * Glory
	 */
	public static final int EDGEVILLE_X = 3087;
	public static final int EDGEVILLE_Y = 3492;
	public static final String EDGEVILLE = "";
	public static final int AL_KHARID_X = 3293;
	public static final int AL_KHARID_Y = 3174;
	public static final String AL_KHARID = "";
	public static final int DRAYNOR_X = 3104;
	public static final int DRAYNOR_Y = 3250;
	public static final String DRAYNOR = "";
	public static final int MAGEBANK_X = 2538;
	public static final int MAGEBANK_Y = 4716;
	public static final String MAGEBANK = "";
	
	/**
	* Teleport Spells
	**/
	public static final int VARROCK_X = 3210;
	public static final int VARROCK_Y = 3424;
	public static final String VARROCK = "";
	public static final int LUMBY_X = 3222;
	public static final int LUMBY_Y = 3218;
	public static final String LUMBY = "";
	public static final int FALADOR_X = 2964;
	public static final int FALADOR_Y = 3378;
	public static final String FALADOR = "";
	public static final int CAMELOT_X = 2757;
	public static final int CAMELOT_Y = 3477;
	public static final String CAMELOT = "";
	public static final int ARDOUGNE_X = 2662;
	public static final int ARDOUGNE_Y = 3305;
	public static final String ARDOUGNE = "";
	public static final int WATCHTOWER_X = 3087;
	public static final int WATCHTOWER_Y = 3500;
	public static final String WATCHTOWER = "";
	public static final int TROLLHEIM_X = 3243;
	public static final int TROLLHEIM_Y = 3513;
	public static final String TROLLHEIM = "";
	
	/**
	 * Ancient Coords
	 */
	public static final int PADDEWWA_X = 3098;
	public static final int PADDEWWA_Y = 9884;
	public static final int SENNTISTEN_X = 3322;
	public static final int SENNTISTEN_Y = 3336;
    public static final int KHARYRLL_X = 3492;
	public static final int KHARYRLL_Y = 3471;
	public static final int LASSAR_X = 3006;
	public static final int LASSAR_Y = 3471;
	public static final int DAREEYAK_X = 3161;
	public static final int DAREEYAK_Y = 3671;
	public static final int CARRALLANGAR_X = 3156;
	public static final int CARRALLANGAR_Y = 3666;
	public static final int ANNAKARL_X = 3288;
	public static final int ANNAKARL_Y = 3886;
	public static final int GHORROCK_X = 2977;
	public static final int GHORROCK_Y = 3873;
  
     /**
	 * Buffer Update
	 */
	public static final int TIMEOUT = 20;
	public static final int CYCLE_TIME = 475;
	public static final int BUFFER_SIZE = 10000;
	public static final int MAX_PROCESS_PACKETS = 15; // was 7
	
	/**
	 * Slayer Variables
	 */
	public static final int[][] SLAYER_TASKS = {{1,87,90,4,5}, //low tasks
												{6,7,8,9,10}, //med tasks
												{11,12,13,14,15}, //high tasks
												{16,17,18,19,20},//elite tasks
												{1,1,15,20,25}, //low reqs
												{30,35,40,45,50}, //med reqs
												{60,75,80,85,90}, //high reqs
												{70,85,90,99}}; //elite reqs
	
	/**
	* Skill Experience Multipliers
	*/	
	public static final int WOODCUTTING_EXPERIENCE = 70;
	public static final int MINING_EXPERIENCE = 70;
	public static final int SMITHING_EXPERIENCE = 70;
	public static final int FARMING_EXPERIENCE = 50;
	public static final int FIREMAKING_EXPERIENCE = 50;
	public static final int HERBLORE_EXPERIENCE = 70;
	public static final int FISHING_EXPERIENCE = 55;
	public static final int AGILITY_EXPERIENCE = 65;
	public static final int PRAYER_EXPERIENCE = 100;
    public static final int PRAYER_EXPERIENCEINHOUSE = 70;
	public static final int RUNECRAFTING_EXPERIENCE = 90;
	public static final int CRAFTING_EXPERIENCE = 75;
	public static final int THIEVING_EXPERIENCE = 75;
	public static final int SLAYER_EXPERIENCE = 65;
	public static final int COOKING_EXPERIENCE = 50;
	public static final int FLETCHING_EXPERIENCE = 65;
}
