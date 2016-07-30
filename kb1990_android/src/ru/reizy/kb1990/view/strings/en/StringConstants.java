package ru.reizy.kb1990.view.strings.en;

public interface StringConstants {
	String MAIN_TREASURE_NAME = "Scepter of Order";
	String MAIN_SEARCH_NAME = "Staff Authorities";
	// castle
	String ATTACK = "Attack";
	String GARNISON = "Garnison";
	String ARMY = "Army";
	String REMOVE = "Remove";
	String EXIT = "Exit";
	String CASTLE_NAME = "Castle %1$2s";
	String[] CASTLE_LORD = { "%1$2s and army", "occuped this castle." };
	String[] CASTLE_BAND = { "A band of monsters", "occuped the castle." };
	String CASTLE_ATTACK_Q = "Attack?";
	String[] CASTLE_NEED_SEIGE = { "You need seige weapon", "to attack the castle." };
	String GP = "GP=%1$2s";
	String EMPTY = "Empty";
	String N_A = "n/a";
	String CLICK_TO = "Click to";
	// army
	String HIT_PTS = "HitPts:%1$2s";
	String SL = "SL:%1$2s";
	String MV = "MV:%1$2s";
	String DAMAGE = "Damage:%1$2s-%2$2s";
	String MORALE = "Morale:%1$2s";
	String OUT_OF_CONTROL = "Out of control";
	String COST = "G-Cost:%1$5s";
	// villains
	String VILLAIN_NAME = " Name: %1$2s";
	String VILLAIN_ALIAS = " Alias:  %1$2s";
	String VILLAIN_REWARD = " Reward: %1$5s gold";
	String VILLAIN_CONTINENT = " Last seen: %1$5s ";
	String VILLAIN_CASTLE_NAME = "    Castle: %1$2s";
	String VILLAIN_FEATURES = "Distinguishing Features: ";
	String VILLAIN_CRIMES = "Crimes: %1$2s";
	String NO_CONTRACT = "You have no Contract!";
	// residence
	String RESIDENCE_NO_UNITS = "In the settlement is not enough soldiers";
	String RESIDENCE_NO_MONEY = "Not enough money";
	String RESIDENCE_NO_LEADERSHIP = "We need more leadership";
	String RESIDENCE_NO_SLOTS = "In the army there are no slots for the war:%1$2s";
	String RESIDENCE_BUY = "You have acquired the war:%1$2s +%2$2s";

	String RESIDENCE_NAME = "          %1$10s";
	String RESIDENCE_LINE = "            ------";
	String RESIDENCE_AVAIBLE = "%1$3s %2$2s are avaible.";
	String RESIDENCE_PRICE = "Cost= %1$4s each. GP=%2$4s";
	String RESIDENCE_COUNT = "You may recruit up to %1$3s ";
	String RESIDENCE_Q = "Recruit How many? ";

	// kings castle
	String KINGS_AUDIENCE = "Audience with the King";
	// town
	String TOWN_NAME = "Town of %1$3s";
	String TOWN_GP = "                    GP=%1$3s";

	String TOWN_CONTRACT = "A) Get New Contract";
	String TOWN_BOAT_CANCEL = "B) Cancel boat rental";
	String TOWN_BOAT_RENT = "B) Rent boat (%1$3s week)";

	String TOWN_CASTLE_INFO = "C) Gather information";
	String TOWN_MAGIC = "D) %1$3s(%2$3s)";
	String TOWN_SEIGE = "E) Buy seige weapons (3000)";
	String TOWN_SEIGE_HAD = "E) You already have seige weapons.";

	// character
	String CHARACTER_NAME = "%1$3s  the  %1$3s";
	String CHARACTER_LEAD /*------------*/= "Leadership        %1$9s ";
	String CHARACTER_COMMISSION /*------*/= "Commission/Week   %1$9s ";
	String CHARACTER_GOLD /*------------*/= "Gold              %1$9s ";
	String CHARACTER_SPELLS_POWER /*----*/= "Spell power       %1$9s ";
	String CHARACTER_SPELLS_COUNT /*----*/= "Max # of spells   %1$9s ";
	String CHARACTER_VILLIANS_COUNT /*--*/= "Villains caught   %1$9s ";
	String CHARACTER_ARTIFACT_COUNT /*--*/= "Artifacts found   %1$9s ";
	String CHARACTER_CASTLES_COUNT /*---*/= "Castles garrisoned%1$9s ";
	String CHARACTER_FOLLOWERS_KILLED /**/= "Followers killed  %1$9s ";
	String CHARACTER_SCORE /*-----------*/= "Currect score     %1$9s ";

	String BATTLE_RESULT_FAIL = "After being disgraced on the field of battle, King Maximus summons you tohis castle."
			+ "After a lesson in tactics, he reluctantly reissues your commission and sends you on your way.";

	String BATTLE_RESULT_TITLE = "               Victory!";
	String[] BATTLE_RESULT_GLORY = { "Well done, %1$3s the %2$3s ,", "You have successfully vanquished", "yet another foe. " };
	String BATTLE_RESULT_BOUNTY = "Spoils of War: %1$5s gold.";

	String[] BATTLE_RESULT_VILLIAN = { ".. and", "captured  %1$5s" };

	String[] BATTLE_RESULT_VILLIAN_WIN = {//
	/*----*/"For the execution of the contract you ", //
			"additionally received %1$5s gold ", //
			"... and as a reward a piece of map", //
			"to " + MAIN_SEARCH_NAME + " search" };
	String[] BATTLE_RESULT_VILLIAN_FAIL = {//
	/*----*/"Since you have not signed a contract ", //
			"so Lord escaped. " };
	String ENEMY_ARMY_INFO = "Your scouts have sighted:\n"//
			+ "%7$1s %8$1s\n"//
			+ "%3$1s %4$1s\n"//
			+ "%1$1s %2$1s\n"//
			+ "%5$1s %6$1s\n"//
			+ "%9$1s %10$1s\n"//
			+ "                       Attack?";

	// artifacts
	String[] ARTIFACT_FOUND_INFO = { "Ridding the countryside of a fercious beast, the Magistrate " + "presents you with: The %1$1s...",
			"Freeing a virtuous maiden from the clutches of a despicable " + "criminal, you have been granted: The %1$1s...",
			"You discover ancient scrolls that describe the patterns of" + " the oceans. Mariners, in gratitude, bestow upon you: " + "The %1$1s...",
			"Challenged to a joust by the dread Dark Knight, you quickly " + "dispose of his and receive: The %1$1s...",
			"Im the study of a deserted wizard's tower, you have found: " + "%1$1s...",
			"Resting on a throne in a phantom castle you have found: " + "The %1$1s...",
			"Following rumors of a great and powerful sword, you defeat " + "its fearsome guardian and gain possession of: " + "The %1$1s...",
			"Hidden within an enchanted grove, you find: The %1$1s..." };
	String ARTIFACT_FOUND_INFO_PASLE = "\n... and a piece of map to " + MAIN_SEARCH_NAME + " search";
	String[] ARTIFACT_NAME = { "Ring of Heroism", "Atricles of Nobility", "Anchor of Admiralty", "Shield of Protection", "Book of Necros", "Crown of Command",
			"Sword of Prowess", "Amulet of Augmentation" };

	// treasures
	String TREASURE_FOUND_INFO_GOLD = "After scouring the area, you fall upon " + "a hidden treasure cache. You may:\n"//
			+ " А)Take the %1$1s gold. \n"//
			+ " В)Distribute the gold to thr peasants, increasing your " + "leadership by %2$1s.";
	String TREASURE_FOUND_INFO_FULL_MAP = "\nPeering through a magical orb you " + "are able to view the entire continent. Your map of this area "
			+ "is complete. ";
	String TREASURE_FOUND_INFO_NEXT_MAP = "\nHidden within an ancient chest, you " + "find maps and charts describing passage to %1$5s.";
	String TREASURE_FOUND_INFO_RANDOM_SPELL = "You have captured a mischievious " + "imp which has been terrorizing the region. In exchange for its "
			+ "release, you receive:\n %1$1s";
	String TREASURE_FOUND_INFO_RICH_MINERAL = "After surveying the area, you " + "discover that it is rich in mineral deposits. \n"
			+ "The King rewards you for your find by increasing your " + "weekly income by %1$1s";
	String TREASURE_FOUND_INFO_SPELL_CAPACITY = "A tribe of nomads greet you " + "and your army warmly. Their shaman, in awe of your prowess, "
			+ "teaches you the secret of his tribe's magic." + "Your maximum spell capacity is increased by %1$1s";
	String TREASURE_FOUND_INFO_SPELL_POWER = "Traversing the area, you stumble " + "upon a time worn canister. Curious, you unclog the bottle, releasing "
			+ "a powerful genie who raises your Spell Power by %1$1s and vanishes.";
	String TREASURE_FOUND_INFO_UNIT1 = "%1$1s  %2$1s ,\n" + "with desires of greater glory, wish to join you... \n\n" + "  Accept? (y/n)";//
	String TREASURE_FOUND_INFO_UNIT2 = "%1$1s  %2$1s,\n" + "with desires of greater glory, wish to join you... \n" + "They will terror you! \n"//
			+ "  Accept? (y/n)";;//
	String TREASURE_FOUND_INFO_UNIT3 = "%1$1s  %2$1s,\n" + "flee in terror at the sight your vast army.\n";//

	// weekend
	String WEEKEND_INFO = "Week #%1$-14s " + "\n" //
			+ "Astrologers proclaim:\n" //
			+ "Week of the %2$5s\n" //
			+ "\n" //
			+ "All %2$5s dwellings are repopulated.\n";

	String WEEKEND_BALANCE = "Week #%1$-14s Budget\n" + "\n" //
			+ "On hand %2$6s %7$-9s %12$7s\n" //
			+ "Payment %3$6s %8$-9s %13$7s\n" //
			+ "Boat    %4$6s %9$-9s %14$7s\n" //
			+ "Army    %5$6s %10$-9s %15$7s\n" //
			+ "Balance %6$6s %11$-9s %16$7s\n";

	String WEEKEND_LEAVE = "Leave";

	// king dialog
	String[] KING_DIALOG = {
			"Trumpets announce your arrival with regal fanfare." + "\n\n King Maximus rises from his throne " + "to greet you and proclaims:           (click)",
			"My dear %1$1s, \n\n ", "I can aid you better after you've captured " + "%1$1s more villain%2$1s", "Congratulations! I now promote you to %1$1s",
			"Hurry and recover my " + MAIN_TREASURE_NAME + " or all will be lost!" };

	// units
	String UNIT_NAME_ARCHERS = "Archers";
	String UNIT_NAME_ARCHMAGES = "Archmages";
	String UNIT_NAME_BARBARIANS = "Barbarian";
	String UNIT_NAME_CAVALRY = "Cavalry";
	String UNIT_NAME_DEMONS = "Demons";
	String UNIT_NAME_DRAGONS = "Dragons";
	String UNIT_NAME_DRUIDS = "Druids";
	String UNIT_NAME_DWARVES = "Dwarves";
	String UNIT_NAME_ELVES = "Elves";
	String UNIT_NAME_GHOSTS = "Ghosts";
	String UNIT_NAME_GIANTS = "Giants";
	String UNIT_NAME_GNOMES = "Gnomes";
	String UNIT_NAME_KNIGHTS = "Knights";
	String UNIT_NAME_MILITIA = "Militia";
	String UNIT_NAME_NOMADS = "Nomands";
	String UNIT_NAME_OGRES = "Ogres";
	String UNIT_NAME_ORCS = "Orcs";
	String UNIT_NAME_PEASANTS = "Peasants";
	String UNIT_NAME_PIKEMEN = "Pikemen";
	String UNIT_NAME_SKELETONS = "Skeletons";
	String UNIT_NAME_SPRITES = "Sprites";
	String UNIT_NAME_TROLLS = "Trolls";
	String UNIT_NAME_VAMPIRES = "Vampires";
	String UNIT_NAME_WOLVES = "Wolves";
	String UNIT_NAME_ZOMBIES = "Zombies";
	// residence
	String RESIDENCE_NAME_PLAINS/*-*/= "  Plains  ";
	String RESIDENCE_NAME_DUNGEON/**/= " Dungeon  ";
	String RESIDENCE_NAME_FOREST/*-*/= "  Forest  ";
	String RESIDENCE_NAME_HILLS/*--*/= "  Hills   ";
	String RESIDENCE_NAME_CASTLE/*-*/= "  Castle  ";
	// titles
	String[] TITLES_KNIGHT = { "Knight", "General", "Marshal", "Lord" };
	String[] TITLES_PALADIN = { "Paladin", "Crusader", "Avenger", "Champion" };
	String[] TITLES_BARBARIAN = { "Sorceress", "Magician", "Mage", "Archmage" };
	String[] TITLES_SORCERESS = { "Barbarian", "Chieftain", "Warlord", "Overlord" };
	// morales
	String MORALE_LOW = ("Low");
	String MORALE_NORM = ("Norm");
	String MORALE_HIGH = ("High");
	// continents

	String[] CONTINENTS_NAMES = { "Continentia", "Forestria", "Archipelia", "Saharia" };
	String UNKNOWN_CASTLE = "Unknown";
	// magic travel
	String SPELL_TRAVEL_BRIDGE = "Bridge";
	String SPELL_TRAVEL_TIME_STOP = "Time Stop";
	String SPELL_TRAVEL_FIND_VILLAIN = "Find Villain";
	String SPELL_TRAVEL_CASTLE_GATE = "Castle Gate";
	String SPELL_TRAVEL_TOWN_GATE = "Town Gate";
	String SPELL_TRAVEL_INSTANT_ARMY = "Instant Army";
	String SPELL_TRAVEL_RAISE_CONTROL = "Raise Control";
	// magic battle
	String SPELL_BATTLE_CLONE = "Clone";
	String SPELL_BATTLE_FIREBALL = "Fireball";
	String SPELL_BATTLE_FREEZE = "Freeze";
	String SPELL_BATTLE_LIGHTING_BOLT = "Lightning";
	String SPELL_BATTLE_RESSURECT = "Resurrect";
	String SPELL_BATTLE_TELEPORT = "Teleport";
	String SPELL_BATTLE_TURN_UNDEAD = "Turn Undead";
	// unit counts

	String[] COUNTS_NAMES = { "A few", "Some", "Many", "A lot of", " A horde of", "A multitude of" };

	//
	String UNKNOWN = "-null-";

}
