package ru.reizy.kb1990.view.strings.ru;

public interface StringConstants {
	String MAIN_TREASURE_NAME = "Скипетр порядка";
	String MAIN_SEARCH_NAME = "Скипетра порядка";
	String ARE_YOU_SURE = "Вы уверены?";
	String SEARCH = "Искать";
	String CANCEL = "Отмена";
	String SEARCH_QUESTION = "Поиски " + MAIN_SEARCH_NAME + " займут в лучшем случае 10 дней...";
	String SEARCH_FAIL = "Ваши раскопки на этой земле ничего не дали. На поиски вы потратили две недели.";
	String YOU_WIN = "Вы победили!";
	String YOU_FAIL = "Вы проиграли...";
	String START_NEW_GAME_QUESTION = "Ваш счет составил %1$2s \n Начать новую игру?";
	String YES = "Да";
	String NO = "Нет";
	String NEXT = "Далее";
	String NEW_GAME = "Новая игра";
	String NEW_GAME_TITLE = "Создание новой игры";
	String NEW_GAME_NAME_REQUEST = "Введите имя";
	String OK = "Ok";
	String ERROR = "Ошибка!";
	String ERROR_REGEXP = "Недопустимые символы.";
	String HOW_MANY_UNITS = "Как много воинов вы хотите нанять?";
	String ABOUT_TEXT = "Ремейк к 25-летию игры) \n Версия  %1$5s_ %2$3s \nОтзывы можете отправлять на \nkb1990-android@mail.ru";
	String ABOUT_TITLE = "О программе";
	String DROP = "Удалить";
	String LOAD = "Загрузить";
	String SAVE = "Сохранить";
	String SAVE_AS = "Сохранить как";
	String DROP_TITLE = "Удаление сохранения";
	String LOAD_TITLE = "Загрузка игры";
	String DIFFICULTY_EASY = "Легко";
	String DIFFICULTY_NORMAL = "Нормально";
	String DIFFICULTY_HARD = "Сложно";
	String DIFFICULTY_IMPOSIBLE = "Невозможно";
	String RESUME = "Продолжить";
	String OPTIONS = "Настройки";
	// castle
	String ATTACK = "Осадить";
	String GARNISON = "Гарнизон";
	String ARMY = "Армия";
	String REMOVE = "Убрать";
	String EXIT = "Выход";
	String CASTLE_NAME = "Замок %1$2s";
	String[] CASTLE_LORD = { "Бандит %1$2s", "захватил этот замок." };
	String[] CASTLE_BAND = { "Разношерстная банда чудовищ", "захватила этот замок." };
	String CASTLE_ATTACK_Q = "Осадить?";
	String[] CASTLE_NEED_SEIGE = { "Вы нуждаетесь в катапульте ", "для атаки замка." };
	String GP = "GP=%1$2s";
	String EMPTY = "Пусто";
	String N_A = "n/a";
	String CLICK_TO = "Перейти в";

	String CASTLE_PLAYER_INFO = ""//
			+ "Замок %1$-10s           GP=%2$2s"//
			+ "\nA) %3$-10s %8$4s         Ваша армия"//
			+ "\nB) %4$-10s %9$4s         (%13$3s)"//
			+ "\nC) %5$-10s %10$4s                  "//
			+ "\nD) %6$-10s %11$4s         Перейти в"//
			+ "\nE) %7$-10s %12$4s         гарнизон?"//
			+ "";
	String CASTLE_GARNISON_INFO = ""//
			+ "Замок %1$-10s            GP=%2$2s"//
			+ "\nA) %3$-10s %8$4s         Гарнизон   "//
			+ "\nB) %4$-10s %9$4s         (%13$3s)"//
			+ "\nC) %5$-10s %10$4s                    "//
			+ "\nD) %6$-10s %11$4s         Перейти к  "//
			+ "\nE) %7$-10s %12$4s         вашей армии?"//
			+ "";

	// army
	String ARMY_INFO = "%1$-4s%2$-10s Здоровье:%3$3s"//
			+ "\n" + "SL: %4$-2s MV: %5$-3s Урон:%6$3s-%7$3s"//
			+ "\n" + "%8$-14s Цена:%9$7s"//
			+ "";

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
	String VILLAIN_REWARD /*-----*/= "   Награда: %1$2s золотых";
	String VILLAIN_CONTINENT /*--*/= " Континент: %1$2s ";
	String VILLAIN_CASTLE_NAME /**/= "     Замок: %1$2s";
	String VILLAIN_FEATURES = "Особые приметы: %1$2s";
	String VILLAIN_CRIMES = "Преступления: %1$2s";
	String NO_CONTRACT = "У вас нет контракта!";
	// residence
	String RESIDENCE_NO_UNITS = "В поселении недостаточно воинов";
	String RESIDENCE_NO_MONEY = "Не хватает денег";
	String RESIDENCE_NO_LEADERSHIP = "Нужно больше лидерства";
	String RESIDENCE_NO_SLOTS = "В армии нет слотов для воинов: %1$2s";
	String RESIDENCE_BUY = "Вы приобрели воинов: %1$2s + %2$2s";

	String RESIDENCE_NAME = "          %1$10s";
	String RESIDENCE_LINE = "            ------";
	String RESIDENCE_AVAIBLE = "%1$3s %2$2s вам доступно";
	String RESIDENCE_PRICE = "цена= %1$4s каждый. $=%2$4s";
	String RESIDENCE_COUNT = "вы можете нанять до %1$3s ";
	String RESIDENCE_Q = "Сколько вы наймете? ";
	// buy magic request
	String BUY_MAGIC_TITLE = "Жилище Авранжа";
	String BUY_MAGIC_REQUEST = "Славный архимаг Авранж может обучить вас секретам волшебства за %1$1s золотых... Вы согласны?";
	// kings castle
	String KINGCASTLE_NO_SLOTS = "Армия полна!";
	String KINGCASTLE_SLOTS_COUNT = "Мест в армии:%1$1s";
	String KINGCASTLE_UNIT_INFO = ""//
			+ "Замок %1$-10s           GP=%2$2s"//
			+ "\nA) %3$-10s %8$4s      Кого нанять?"//
			+ "\nB) %4$-10s %9$4s      (%13$3s)"//
			+ "\nC) %5$-10s %10$4s      %14$3s"//
			+ "\nD) %6$-10s %11$4s         "//
			+ "\nE) %7$-10s %12$4s         "//
			+ "";
	String KINGCASTLE_UNIT_COUNT_INFO = ""//
			+ "Замок %1$-10s           GP=%2$2s"//
			+ "\nA) %3$-10s %8$4s      Вы нанимаете"//
			+ "\nB) %4$-10s %9$4s      >%13$1s"//
			+ "\nC) %5$-10s %10$4s      Доступно"//
			+ "\nD) %6$-10s %11$4s      >%14$1s"//
			+ "\nE) %7$-10s %12$4s      Сколько нанять?"//
			+ "";

	String KINGCASTLE_INIT_INFO = ""//
			+ "Замок %1$-10s"//
			+ "\n"//
			+ "\nA) Нанять солдат."//
			+ "\nB) Аудиенция с королем."//
			+ "";

	// king dialog
	String KING_DIALOG_WELCOME = "Вы вошли в королевские покои под звуки фанфар." + "\n\n Король Максимус поднимается со своего трона, "
			+ "чтобы поприветствовать Вас и объявляет:";
	String KING_DIALOG_DEAR = "Уважаемый %1$1s, ";
	String KING_DIALOG_NEED_MORE = "Я смогу оказать тебе большую поддержку, когда ты свергнешь еще %1$1s из злодеев";
	String KING_DIALOG_PROMOTON = "Поздравляю! Я награждаю тебя званием %1$1s";
	String KING_DIALOG_MAX = "Поспеши вернуть мне " + MAIN_TREASURE_NAME + ", иначе все пропало!";

	// town
	String TOWN_NAME = "Город %1$-25s";
	String TOWN_GP = "GP=%1$3s";

	String TOWN_CONTRACT = "A) Взять новый контракт";
	String TOWN_BOAT_CANCEL = "B) Отменить аренду корабля";
	String TOWN_BOAT_RENT = "B) Арендовать корабль (%1$3s/нед.)";

	String TOWN_CASTLE_INFO = "C) Информация о замке";
	String TOWN_MAGIC = "D) %1$3s (%2$3s)";
	String TOWN_SEIGE = "E) Купить катапульту (3000)";
	String TOWN_SEIGE_HAD = "E) У вас уже есть катапульта.";

	String BAND = "отряд монстров";
	String TOWN_CASTLE_INFO_FULL = "Замок %1$3s занял %2$3s:\n" //
			+ "%3$-20s %4$-15s\n" //
			+ "%5$-20s %6$-15s\n"//
			+ "%7$-20s %8$-15s\n"//
			+ "%9$-20s %10$-15s\n"//
	;

	// character
	String CHARACTER_NAME = "%2$3s %1$3s";
	String CHARACTER_LEAD /*------------*/= "Лидерство         %1$9s ";
	String CHARACTER_COMMISSION /*------*/= "Жалование в неделю%1$9s ";
	String CHARACTER_GOLD /*------------*/= "Золото            %1$9s ";
	String CHARACTER_SPELLS_POWER /*----*/= "Сила магии        %1$9s ";
	String CHARACTER_SPELLS_COUNT /*----*/= "Число заклинаний  %1$9s ";
	String CHARACTER_VILLIANS_COUNT /*--*/= "Поймано бандитов  %1$9s ";
	String CHARACTER_ARTIFACT_COUNT /*--*/= "Найдено артефактов%1$9s ";
	String CHARACTER_CASTLES_COUNT /*---*/= "Захвачено замков  %1$9s ";
	String CHARACTER_FOLLOWERS_KILLED /**/= "Потеряно солдат   %1$9s ";
	String CHARACTER_SCORE /*-----------*/= "Текущий счет      %1$9s ";

	// battle result
	String BATTLE_RESULT_FAIL = "После вашего бесславного поражения в битве, Король Максимус призвал вас в замок."
			+ " После урока тактики он вдохновил вас на подвиги ценным подарком и снова послал вас в бой.";

	String BATTLE_RESULT_TITLE = "               Победа!";
	String[] BATTLE_RESULT_GLORY = { "Прекрасно, %1$3s - %2$3s ,", "Вы превосходно справились с этой", "бандой. " };
	String BATTLE_RESULT_BOUNTY = "Военная добыча: %1$5s золотых.";

	String[] BATTLE_RESULT_VILLIAN = { ".. и", "вами захвачен  %1$5s" };

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
			+ "%9$1s %10$1s"//
			+ "(Повторный клик на врага для атаки.)";
	// artifacts
	String[] ARTIFACT_FOUND_INFO = { "Облетая пределы страны на летучем чудовище, Магистр вручил вам %1$1s...",//
			"За освобождение благородной дамы из лап презренного злодея вы получили %1$1s...",//
			"Вы нашли древние свитки, в которых описаны закономерности морских течений. Моряки, в знак благодарности, вручили вам %1$1s...",//
			"Победив в поединке с безжалостным Темным Рыцарем, вы добыли бесценный трофей - %1$1s...",//
			"Изучая заброшенную магическую башню, вы обнаружили %1$1s...", //
			"На престоле в фантомном замке хранилась " + "%1$1s...",//
			"Следуя сказаниям в великом и могучем мече, вы победили ужасного стража и захватили %1$1s...",//
			"Скрытый в заколдованный роще, вами был обнаружен %1$1s..." };
	String ARTIFACT_FOUND_INFO_PASLE = "\n... и часть карты для поиска " + MAIN_SEARCH_NAME + ".";

	String[] ARTIFACT_NAME = { "Кольцо Героизма", "Грамота Дворянства", "Якорь Адмиралтейства", "Гвардейский Щит", "Книга мертвых", "Корона Управления",
			"Меч Истины", "Амулет убеждения" };

	// treasures
	String TREASURE_FOUND_INFO_GOLD = "Обследуя местность, вы обнаружили древнюю сокровищницу. По традиции вы поделили клад пополам:  \n"//
			+ " А)Забрали %1$1s монет себе\n"//
			+ " В)Остальное разделили между крестьянами, подняв свой авторитет на %2$1s";
	String TREASURE_FOUND_INFO_FULL_MAP = "\nС помощью волшебного шара вы можете " + "просмотреть весь континент."
			+ " Теперь у вас есть полная карта этого района.";
	String TREASURE_FOUND_INFO_NEXT_MAP = "\nВ Древнем сундуке, вы отыскали " + "карты и заметки, которые описывают путь до континента %1$5s.";
	String TREASURE_FOUND_INFO_RANDOM_SPELL = "Вы захватили озорного чертенка," + " хулиганившего в окрестностях. "
			+ "В обмен на его освобождение вы получили выкуп:\n %1$1s";
	String TREASURE_FOUND_INFO_RICH_MINERAL = "После исследования земли вы " + "обнаружили, что она богата минералами. " + "Король наградил вас за находку "
			+ "повышением еженедельной зарплаты на %1$1s";
	String TREASURE_FOUND_INFO_SPELL_CAPACITY = "Племя кочевников тепло " + "встретило вас и вашу армию. "
			+ "Их шаман, предвидя ваш дальнейший путь обучил вас " + "секретам своего мастерства. " + "Ваша способность к заклинаниям увеличилась на %1$1s";
	String TREASURE_FOUND_INFO_SPELL_POWER = "Путешествуя по земле, вы споткнулись о древний сосуд. Заинтересовавшись, вы распечатали сосуд,"
			+ " освободив могучего джина, который увеличил вашу " + "волшебную силу на %1$1s";
	String TREASURE_FOUND_INFO_UNIT1 = "%1$1s  %2$1s ,\n" + "возжелав великой славы, присоединяются к вашей армии... \n\n";// +
	// "  принять? (y/n)";//
	String TREASURE_FOUND_INFO_UNIT2 = "%1$1s  %2$1s ,\n" + "возжелав великой славы, присоединяются к вашей армии... \n" + "Похоже они неуправляемы! \n";//
	// + "  принять? (y/n)";//
	String TREASURE_FOUND_INFO_UNIT3 = "%1$1s  %2$1s  \n" + "убежали в ужасе при виде вашей армии.\n";//

	// weekend
	String WEEKEND_INFO = "Неделя %1$-14s " + "\n" //
			+ "Астрологи объявили:\n" //
			+ "   знак этой недели - %2$5s\n" //
			+ "\n" //
			+ "%2$5s снова заселили поселки.\n";

	String WEEKEND_BALANCE = " \tНеделя №%1$-11s\t        Бюджет\n" //
			+ " \tНаличн. %2$6s  \t %7$-9s %12$7s\n" //
			+ " \tДоходы  %3$6s  \t %8$-9s %13$7s\n" //
			+ " \tКорабль %4$6s  \t %9$-9s %14$7s\n" //
			+ " \tАрмия   %5$6s  \t %10$-9s %15$7s\n" //
			+ " \tБаланс  %6$6s  \t %11$-9s %16$7s\n";

	String WEEKEND_LEAVE = "Уволены";

	// units
	String UNIT_NAME_ARCHERS/*---*/= "Лучники";
	String UNIT_NAME_ARCHMAGES/*-*/= "Маги";
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
	String UNIT_NAME_SPRITES/*---*/= "Феи";
	String UNIT_NAME_TROLLS/*----*/= "Тролли";
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
	String[] CONTINENTS_NAMES = { "Континентия", "Форестия", "Арчепелия", "Сахария" };
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
	String SPELL_BATTLE_FIREBALL = "Огненный шар";
	String SPELL_BATTLE_FREEZE = "Заморозка";
	String SPELL_BATTLE_LIGHTING_BOLT = "Молния";
	String SPELL_BATTLE_RESSURECT = "Воскрешение";
	String SPELL_BATTLE_TELEPORT = "Телепорт";
	String SPELL_BATTLE_TURN_UNDEAD = "Святая вода";
	// unit counts
	String[] COUNTS_NAMES = { "Пара -", "Немного -", "Несколько -", "Много -", "Очень много -", "Орда -" };

	//
	String UNKNOWN = "неопределенно";

}
