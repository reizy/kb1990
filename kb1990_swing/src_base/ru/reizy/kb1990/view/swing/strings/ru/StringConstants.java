package ru.reizy.kb1990.view.swing.strings.ru;

public interface StringConstants {
	String MAIN_TREASURE_NAME = "Скипетр порядка";
	String MAIN_SEARCH_NAME = "Скипетра порядка";

	// castle
	String ATTACK = "Осадить";
	String GARNISON = "Гарнизон";
	String ARMY = "Армия";
	String REMOVE = "Убрать";
	String EXIT = "Выход";
	String CASTLE_NAME = "Замок %1$2s";
	String[] CASTLE_LORD = { "Бандит %1$2s", "захватил этот замок." };
	String[] CASTLE_BAND = { "Разношерстная банда чудовищ",
			"захватили этот замок." };
	String CASTLE_ATTACK_Q = "Осадить?";
	String[] CASTLE_NEED_SEIGE = { "Вы нуждаетесь в таране", "для атаки замка." };
	String GP = "GP=%1$2s";
	String EMPTY = "Пусто";
	String N_A = "n/a";
	String CLICK_TO = "Перейти в";
	// army
	String HIT_PTS = "Здоровье:%1$2s";
	String SL = "SL:%1$2s";
	String MV = "MV:%1$2s";
	String DAMAGE = "Урон:%1$2s-%2$2s";
	String MORALE = "Мораль:%1$2s";
	String OUT_OF_CONTROL = "Взбунтовались";
	String COST = "Цена:%1$5s";
	// villains
	String VILLAIN_NAME /*-------*/= "       Имя: %1$2s";
	String VILLAIN_ALIAS /*------*/= "     Титул: %1$2s";
	String VILLAIN_REWARD /*-----*/= "   Награда: %1$2s gold";
	String VILLAIN_CONTINENT /*--*/= " Континент: %1$2s ";
	String VILLAIN_CASTLE_NAME /**/= "     Замок: %1$2s";
	String VILLAIN_FEATURES = "Особые приметы: %1$2s";
	String VILLAIN_CRIMES = "Преступления: %1$2s";
	String NO_CONTRACT = "У вас нет контракта!";
	// residence
	String RESIDENCE_NO_UNITS = "В поселении недостаточно воинов";
	String RESIDENCE_NO_MONEY = "Не хватает денег";
	String RESIDENCE_NO_LEADERSHIP = "Нужно больше лидерства";
	String RESIDENCE_NO_SLOTS = "В армии нет слотов для войнов: %1$2s";
	String RESIDENCE_BUY = "Вы приобрели войнов: %1$2s + %2$2s";

	String RESIDENCE_NAME = "          %1$10s";
	String RESIDENCE_LINE = "            ------";
	String RESIDENCE_AVAIBLE = "%1$3s %2$2s вам доступно";
	String RESIDENCE_PRICE = "цена= %1$4s каждый. $=%2$4s";
	String RESIDENCE_COUNT = "вы можете нанять до %1$3s ";
	String RESIDENCE_Q = "Сколько вы наймете? ";

	// kings castle
	String KINGS_AUDIENCE = "Аудиенция с королем";

	// town
	String TOWN_NAME = "Город %1$3s";
	String TOWN_GP = "                    GP=%1$3s";

	String TOWN_CONTRACT = "A) Взять новый контракт";
	String TOWN_BOAT_CANCEL = "B) Отменить аренду корабля";
	String TOWN_BOAT_RENT = "B) Арендавать корабль (%1$3s/нед.)";

	String TOWN_CASTLE_INFO = "C) Информация о замке";
	String TOWN_MAGIC = "D) %1$3s (%2$3s)";
	String TOWN_SEIGE = "E) Купить таран (3000)";
	String TOWN_SEIGE_HAD = "E) У вас уже есть таран.";

	// character
	String CHARACTER_NAME = "%2$3s %1$3s";
	String CHARACTER_LEAD /*------------*/= "Лидерство         %1$9s ";
	String CHARACTER_COMMISSION /*------*/= "Жалование в неделю%1$9s ";
	String CHARACTER_GOLD /*------------*/= "Золото            %1$9s ";
	String CHARACTER_SPELLS_POWER /*----*/= "Сила магии        %1$9s ";
	String CHARACTER_SPELLS_COUNT /*----*/= "Макс # заклинаний %1$9s ";
	String CHARACTER_VILLIANS_COUNT /*--*/= "Поймано бандитов  %1$9s ";
	String CHARACTER_ARTIFACT_COUNT /*--*/= "Найдено артифактов%1$9s ";
	String CHARACTER_CASTLES_COUNT /*---*/= "Захвачено замков  %1$9s ";
	String CHARACTER_FOLLOWERS_KILLED /**/= "Потеряно солдат   %1$9s ";
	String CHARACTER_SCORE /*-----------*/= "Текущий счет      %1$9s ";

	// battle result

	String BATTLE_RESULT_TITLE = "               Победа!";
	String[] BATTLE_RESULT_GLORY = { "Прекрасно, %1$3s - %2$3s ,",
			"Вы превосходно справились с этой", "бандой. " };
	String BATTLE_RESULT_BOUNTY = "Военная добыча: %1$5s золотых.";

	String[] BATTLE_RESULT_VILLIAN = { ".. и", "захватили  %1$5s" };

	String[] BATTLE_RESULT_VILLIAN_WIN = { //
	/*----*/"За выполнение контракта вы до-",//
			"полнительно получили  %1$5s золт",//
			"как награду...и кусок карты для ", //
			"поиска " + MAIN_SEARCH_NAME };
	String[] BATTLE_RESULT_VILLIAN_FAIL = {//
	/*----*/"Так как вы не заключали соответст-",//
			"ствующего контракта, Лорд сбе-", "жал." };
	String ENEMY_ARMY_INFO = "Ваши разведчики сообщают:\n"//
			+ "%7$1s %8$1s\n"//
			+ "%3$1s %4$1s\n"//
			+ "%1$1s %2$1s\n"//
			+ "%5$1s %6$1s\n"//
			+ "%9$1s %10$1s\n"//
			+ "                      Напасть?";
	// artifacts
	String[] ARTIFACT_FOUND_INFO = {
			"Облетая пределы страны на летучем чудовище, Магистр вручил вам %1$1s...",
			"Freeing a virtuous maiden from the clutches of a despicable "
					+ "criminal, you have been granted: %1$1s...",
			"You discover ancient scrolls that describe the patterns of"
					+ " the oceans. Mariners, in gratitude, bestow upon you: "
					+ "%1$1s...",
			"Победив в поединке с безжалостным Темным Рыцарем, вы добыли "
					+ "бесценный трофей - %1$1s...",
			"Im the study of a deserted wizard's tower, you have found: "
					+ "%1$1s...",
			"Resting on a throne in a phantom castle you have found: " + "%1$1s...",
			"Following rumors of a great and powerful sword, you defeat "
					+ "its fearsome guardian and gain possession of: " + "%1$1s...",
			"Hidden within an enchanted grove, you find: %1$1s..." };
	String ARTIFACT_FOUND_INFO_PASLE = "\n... и часть карты для поиска "
			+ MAIN_SEARCH_NAME + ".";

	String[] ARTIFACT_NAME = { "Кольцо Героизма", "Грамота Дворянства",
			"Якорь Адмиралтейства", "Гвардейский Щит", "Книга мертвых",
			"Корона Управления", "Меч Истины", "Амулет убеждения" };

	// treasures
	String TREASURE_FOUND_INFO_GOLD = "После исследования зоны, вы обнаружили "
			+ "древнюю сокровищницу. Можете:  \n"//
			+ " А)Забрать %1$1s монет \n"//
			+ " В)Разделить золото между крестьянами, подняв свой "
			+ "авторитет вождя на %2$1s";
	String TREASURE_FOUND_INFO_FULL_MAP = "\nС помощью волшебного шара вы можете "
			+ "просмотреть весь континент."
			+ " Теперь у вас есть полная карта этого района.";
	String TREASURE_FOUND_INFO_NEXT_MAP = "\nВ Древнем сундуке, вы отыскали "
			+ "карты и заметки, которые описывают путь до континета %1$5s.";
	String TREASURE_FOUND_INFO_RANDOM_SPELL = "Вы захватили озорного чертенка,"
			+ " хулиганившего в окрестностях.\n"
			+ "В обмен на его освобождение вы получили выкуп:\n %1$1s";
	String TREASURE_FOUND_INFO_RICH_MINERAL = "После исследования земли вы "
			+ "обнаружили, что она богата минералами. \n"
			+ "Король наградил вас за находку "
			+ "повышением еженедельной зарплаты на %1$1s";
	String TREASURE_FOUND_INFO_SPELL_CAPACITY = "Племя кочевников тепло "
			+ "встретило вас и вашу армию. \n"
			+ "Их шаман, предвидя ваш дальнейший путь обучил вас "
			+ "секретам своего мастерства. "
			+ "Ваша способность к заклинаниям увеличилась на %1$1s";
	String TREASURE_FOUND_INFO_SPELL_POWER = "Путешествуя по земле, вы "
			+ "споткнулись о древний сосуд. Заинтересовавшись, вы распеча- "
			+ "тали сосуд, освободив могучего джина, который увеличил вашу "
			+ "волшебную силу на %1$1s";
	String TREASURE_FOUND_INFO_UNIT1 = "%1$1s  %2$1s ,\n"
			+ "возжелав великой славы, хотят присоединиться... \n\n"
			+ "  принять? (y/n)";//
	String TREASURE_FOUND_INFO_UNIT2 = "%1$1s  %2$1s ,\n"
			+ "возжелав великой славы, хотят присоединиться... \n"
			+ "Они станут неуправляемыми! \n"//
			+ "  принять? (y/n)";//
	String TREASURE_FOUND_INFO_UNIT3 = "%1$1s  %2$1s  \n"
			+ "убежали в ужасе при виде вашей армии.\n";//

	// weekend
	String WEEKEND_INFO = "Неделя %1$-14s " + "\n" //
			+ "Астрологи объявили:\n" //
			+ "   знак этой недели - %2$5s\n" //
			+ "\n" //
			+ "%2$5s снова заселили поселки.\n";

	String WEEKEND_BALANCE = "Неделя %1$-14s Бюджет\n" + "\n" //
			+ "Наличн. %2$6s %7$-9s %12$7s\n" //
			+ "Доходы  %3$6s %8$-9s %13$7s\n" //
			+ "Корабль %4$6s %9$-9s %14$7s\n" //
			+ "Армия   %5$6s %10$-9s %15$7s\n" //
			+ "Баланс  %6$6s %11$-9s %16$7s\n";
	
	String WEEKEND_LEAVE = "Уволены";

	// king dialog
	String[] KING_DIALOG = {
			"Вы вошли в королевские покои под звуки фанфар."
					+ "\n\n Король Максимусs поднимается со своего трона, "
					+ "чтобы поприветствовать Вас и объявил:",
			"Уважаемый %1$1s, \n\n ",
			"Я смогу оказать тебе большую поддержку, когда ты свергнешь еще "
					+ "%1$1s злодеев%2$1s",//
			"Поздравляю! Я награждаю тебя званием %1$1s",
			"Поспеши вернуть мне " + MAIN_TREASURE_NAME + ", иначе все пропало!" };
	// units
	String UNIT_NAME_ARCHERS/*---*/= "Лучники";
	String UNIT_NAME_ARCHMAGES/*-*/= "Супермаги";
	String UNIT_NAME_BARBARIANS/**/= "Варвары";
	String UNIT_NAME_CAVALRY/*---*/= "Кавалерия";
	String UNIT_NAME_DEMONS/*----*/= "Демоны";
	String UNIT_NAME_DRAGONS/*---*/= "Драконы";
	String UNIT_NAME_DRUIDS/*----*/= "Друиды";
	String UNIT_NAME_DWARVES/*---*/= "Викинги";
	String UNIT_NAME_ELVES/*-----*/= "Эльфы";
	String UNIT_NAME_GHOSTS/*----*/= "Призраки";
	String UNIT_NAME_GIANTS/*----*/= "Титаны";
	String UNIT_NAME_GNOMES/*----*/= "Гномы";
	String UNIT_NAME_KNIGHTS/*---*/= "Рыцари";
	String UNIT_NAME_MILITIA/*---*/= "Милиция";
	String UNIT_NAME_NOMADS/*----*/= "Кочевники";
	String UNIT_NAME_OGRES/*-----*/= "Огры";
	String UNIT_NAME_ORCS/*------*/= "Орки";
	String UNIT_NAME_PEASANTS/*--*/= "Крестьяне";
	String UNIT_NAME_PIKEMEN/*---*/= "Солдаты";
	String UNIT_NAME_SKELETONS/*-*/= "Скелеты";
	String UNIT_NAME_SPRITES/*---*/= "Духи";
	String UNIT_NAME_TROLLS/*----*/= "Троли";
	String UNIT_NAME_VAMPIRES/*--*/= "Вампиры";
	String UNIT_NAME_WOLVES/*----*/= "Волки";
	String UNIT_NAME_ZOMBIES/*---*/= "Зомби";
	// residence
	String RESIDENCE_NAME_PLAINS/*-*/= "   Поля   ";
	String RESIDENCE_NAME_DUNGEON/**/= "Подземелья";
	String RESIDENCE_NAME_FOREST/*-*/= "   Леса   ";
	String RESIDENCE_NAME_HILLS/*--*/= "  Холмы   ";
	String RESIDENCE_NAME_CASTLE/*-*/= "  Замок   ";
	// titles
	String[] TITLES_KNIGHT = { "Рыцарь", "Генерал", "Маршал", "Лорд" };
	String[] TITLES_PALADIN = { "Паладин", "Крестоносец", "Инквизитор", "Чемпион" };
	String[] TITLES_BARBARIAN = { "Варвар", "Вождь", "Военачальник", "Повелитель" };
	String[] TITLES_SORCERESS = { "Ворожея", "Чародейка", "Волшебница", "Архимаг" };
	// morales
	String MORALE_LOW = ("Низкая");
	String MORALE_NORM = ("Нормал");
	String MORALE_HIGH = ("Высокая");
	// continents
	String[] CONTINENTS_NAMES = { "Континентия", "Форестия", "Арчепелия",
			"Сахария" };
	String UNKNOWN_CASTLE = "Неизвестен";
	// magic travel
	String SPELL_TRAVEL_BRIDGE = "Мост";
	String SPELL_TRAVEL_TIME_STOP = "Остановка Времени";
	String SPELL_TRAVEL_FIND_VILLAIN = "Найти врага";
	String SPELL_TRAVEL_CASTLE_GATE = "Портал к замку";
	String SPELL_TRAVEL_TOWN_GATE = "Портал к городу";
	String SPELL_TRAVEL_INSTANT_ARMY = "Добровольцы";
	String SPELL_TRAVEL_RAISE_CONTROL = "Суперконтроль";
	// magic battle
	String SPELL_BATTLE_CLONE = "Клонирование";
	String SPELL_BATTLE_FIREBALL = "Огненый шар";
	String SPELL_BATTLE_FREEZE = "Заморозка";
	String SPELL_BATTLE_LIGHTING_BOLT = "Молния";
	String SPELL_BATTLE_RESSURECT = "Воскрешение";
	String SPELL_BATTLE_TELEPORT = "Телепорт";
	String SPELL_BATTLE_TURN_UNDEAD = "Святая вода";
	// unit counts
	String[] COUNTS_NAMES = { "Пара", "Немного", "Несколько", "Много",
			"Очень много", "Орда" };

	//
	String UNKNOWN = "неопределено";

}
