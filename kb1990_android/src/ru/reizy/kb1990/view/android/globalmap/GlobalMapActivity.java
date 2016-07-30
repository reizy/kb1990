package ru.reizy.kb1990.view.android.globalmap;

import static ru.reizy.kb1990.view.strings.ru.StringConstants.ARE_YOU_SURE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.BUY_MAGIC_REQUEST;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.BUY_MAGIC_TITLE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CANCEL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.NO;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.SEARCH;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.SEARCH_FAIL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.SEARCH_QUESTION;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.START_NEW_GAME_QUESTION;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.YES;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.YOU_FAIL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.YOU_WIN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintStream;

import org.apache.log4j.Level;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import de.mindpipe.android.logging.log4j.LogConfigurator;
import ru.reizy.kb1990.R;
import ru.reizy.kb1990.model.battle.unit.types.UnitTypes;
import ru.reizy.kb1990.model.events.BattleStartEvent;
import ru.reizy.kb1990.model.events.KBEvent;
import ru.reizy.kb1990.model.globalmap.Difficulty;
import ru.reizy.kb1990.model.globalmap.GlobalPlayer;
import ru.reizy.kb1990.model.globalmap.PlayerType;
import ru.reizy.kb1990.model.globalmap.events.BuyMagicEvent;
import ru.reizy.kb1990.model.globalmap.events.CastleInEvent;
import ru.reizy.kb1990.model.globalmap.events.CastleTeleportEvent;
import ru.reizy.kb1990.model.globalmap.events.GameOverEvent;
import ru.reizy.kb1990.model.globalmap.events.KingCastleInEvent;
import ru.reizy.kb1990.model.globalmap.events.ResidenceInEvent;
import ru.reizy.kb1990.model.globalmap.events.SignPostActivateEvent;
import ru.reizy.kb1990.model.globalmap.events.TownInEvent;
import ru.reizy.kb1990.model.globalmap.events.TownTeleportEvent;
import ru.reizy.kb1990.model.globalmap.events.TreasureActivateEvent;
import ru.reizy.kb1990.model.globalmap.events.WeekEndEvent;
import ru.reizy.kb1990.model.globalmap.residence.Castle;
import ru.reizy.kb1990.model.globalmap.residence.SimpleUnitResidence;
import ru.reizy.kb1990.saveload.KBSaver;
import ru.reizy.kb1990.view.android.KbAndroidActivity;
import ru.reizy.kb1990.view.android.MainMenyActivity;
import ru.reizy.kb1990.view.android.ModelSingletonFactory;
import ru.reizy.kb1990.view.android.army.ArmyActivity;
import ru.reizy.kb1990.view.android.battle.BattleActivity;
import ru.reizy.kb1990.view.android.battle.BattleView;
import ru.reizy.kb1990.view.android.character.CharacterActivity;
import ru.reizy.kb1990.view.android.globalmap.castle.CastleActivity;
import ru.reizy.kb1990.view.android.globalmap.kingcastle.KingCastleActivity;
import ru.reizy.kb1990.view.android.globalmap.residence.ResidenceActivity;
import ru.reizy.kb1990.view.android.globalmap.town.TownActivity;
import ru.reizy.kb1990.view.android.pasle.PasleActivity;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.resource.Util;
import ru.reizy.kb1990.view.android.villain.VillainActivity;
import ru.reizy.kb1990.view.strings.StringConstants;

public class GlobalMapActivity extends KbAndroidActivity {

	public static final int ACTION_CANCEL = 0;
	public static final int ACTION_NEW = 1;
	public static final int ACTION_SAVE = 2;
	public static final int ACTION_LOAD = 3;
	public static final int ACTION_DELETE = 4;
	public static final int ACTION_EXIT = 5;

	private static final int MENU_ACTIVITY_ID = 1;
	private static final int CASTLE_ACTIVITY_ID = 2;
	private static final int BATTLE_ACTIVITY_ID = 3;

	private GlobalFieldPanel panel;
	private TextView userLog;
	private ScrollView userLogScroll;
	private boolean castleActive = false;
	private TravelMagicPanel magicPanel;

	private void initLogger(Context context, boolean useExtLog) {
		LogConfigurator logConfigurator = new LogConfigurator();

		final File dir = new File(Util.getDir(context) + File.separator + "kb1990" + File.separator + "logs");
		if (!dir.exists()) {
			dir.mkdir();
		}
		logConfigurator.setFileName(dir + File.separator + "log4j.txt");

		logConfigurator.setMaxFileSize(1024 * 1024 * 5);

		logConfigurator.setUseFileAppender(useExtLog);
		logConfigurator.setUseLogCatAppender(true);
		logConfigurator.setImmediateFlush(true);
		logConfigurator.setRootLevel(Level.INFO);
		logConfigurator.setLevel("ru.reizy.kb1990", Level.INFO);
		logConfigurator.setFilePattern("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
		logConfigurator.configure();
	}

	protected void writeLastError(Throwable throwable) {
		try {
			final File dir = new File(Util.getExternalDir() + File.separator + "kb1990" + File.separator + "logs");
			if (!dir.exists()) {
				dir.mkdir();
			}
			final File f = new File(dir, "error.txt");
			PrintStream err;

			err = new PrintStream(f);
			throwable.printStackTrace(err);
			err.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void setUncaughtExceptionHandler() {
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			// сохраним ранее установленный обработчик
			Thread.UncaughtExceptionHandler oldHandler = Thread.getDefaultUncaughtExceptionHandler();

			@Override
			public void uncaughtException(Thread thread, Throwable throwable) {
				writeLastError(throwable);
				Log.w("ru.reizy.kb1990", "Приложение остановлено", throwable);
				if (oldHandler != null) // если есть ранее установленный...
					// ...вызовем его
					oldHandler.uncaughtException(thread, throwable);
			}
		});
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.global_map);

		Context context = getApplicationContext();
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean useExtLog = prefs.getBoolean("useExtLog", false);
		initLogger(context,useExtLog);

		if (useExtLog) {
			if (!Util.isLocalStorage(context)) {
				setUncaughtExceptionHandler();
			}
		}

		panel = new GlobalFieldPanel(getWindow(), getResources());

		magicPanel = new TravelMagicPanel(getWindow(), getResources());

		ImageButton btnSearch = (ImageButton) findViewById(R.id.btn_search);
		btnSearch.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				getSearchDialog().show();
			}
		});
		ImageButton btnW = (ImageButton) findViewById(R.id.btn_weakend);
		btnW.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				getGlobalPlayer().finishWeek();
			}
		});
		ImageButton btnMenu = (ImageButton) findViewById(R.id.btn_menu);
		btnMenu.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showMainMenu();
			}
		});
		ImageView btnVillain = (ImageView) findViewById(R.id.field_5_0);
		btnVillain.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showVillainInfo();
			}
		});
		ImageView btnArmy = (ImageView) findViewById(R.id.field_5_1);
		btnArmy.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showArmy();
			}
		});
		ImageView btnMagic = (ImageView) findViewById(R.id.field_5_2);
		btnMagic.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showMagic();
			}
		});
		ImageView btnPalse = (ImageView) findViewById(R.id.field_5_3);
		btnPalse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showPalse();
			}
		});
		ImageView btnCharacter = (ImageView) findViewById(R.id.field_5_4);
		btnCharacter.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showCharacter();
			}
		});

		userLog = (TextView) findViewById(R.id.log);
		userLogScroll = (ScrollView) findViewById(R.id.log_scroll);

	}

	@Override
	protected void onResume() {
		super.onResume();
		if (panel != null) {
			updateOptions(panel.getOptions());
			panel.fullUpdate();
		}
	}

	@Override
	protected void reloadModel(String name, PlayerType type, Difficulty difficulty) {
		super.reloadModel(name, type, difficulty);
		if (panel != null) {
			updateOptions(panel.getOptions());
			panel.fullUpdate();
		}
	}

	@Override
	public void onEvent(final KBEvent event) {
		if (event instanceof TownInEvent) {
			onTownInEvent();
			showMessage("Bы вошли в город " + ((TownInEvent) event).getResidence().getName());
		} else if (event instanceof KingCastleInEvent) {
			onKingCastleInEvent();
			showMessage("Вы вошли в королевский замок");
		} else if (event instanceof CastleInEvent) {
			onCastleInEvent();
			final CastleInEvent cEvent = (CastleInEvent) event;
			final Castle castle = cEvent.getCastle();
			final String castleName = NameResolver.getCastleName(castle);
			showMessage("Вы вошли в замок " + castleName);
		} else if (event instanceof ResidenceInEvent) {
			onResidenceInEvent();
			final ResidenceInEvent rEvent = (ResidenceInEvent) event;
			final SimpleUnitResidence residence = (SimpleUnitResidence) rEvent.getResidence();
			final UnitTypes unit = residence.getUnit();
			final String unitName = NameResolver.getUnitName(unit);
			showMessage("Вы вошли в лагерь, который населяют " + unitName);
		} else if (event instanceof BattleStartEvent) {
			onBattleStartEvent();
			showMessage("Вы вступили в битву");
		} else if (event instanceof CastleTeleportEvent) {
			showCastleList();
		} else if (event instanceof TownTeleportEvent) {
			showTownList();
		} else if (event instanceof GameOverEvent) {
			getGameOverDialog().show();
		} else if (event instanceof TreasureActivateEvent) {
			showMessage("Вы нашли сокровище");
		} else if (event instanceof WeekEndEvent) {
			WeekEndEvent weekEndEvent = (WeekEndEvent) event;
			final UnitTypes unit = weekEndEvent.getUnit();
			final String unitName = NameResolver.getUnitName(unit);
			showMessage("Неделя закончилась. Знак новой недели - " + unitName);
		} else if (event instanceof SignPostActivateEvent) {
			showMessage("Указатель гласит '" + ((SignPostActivateEvent) event).getResidence().getText() + "'");
		} else if (event instanceof BuyMagicEvent) {
			BuyMagicEvent buyMagicEvent = (BuyMagicEvent) event;
			if (buyMagicEvent.getCell() != null) {
				showMessage("Вы вошли в жилище великого мага. ");
				getBuyMagicDialog(buyMagicEvent).show();
			}
		}
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (panel != null)
					panel.onEvent(event);
			}
		});

	}

	private Builder getBuyMagicDialog(final BuyMagicEvent buyMagicEvent) {
		getGlobalPlayer();
		return new AlertDialog.Builder(this).setCancelable(false).setTitle(BUY_MAGIC_TITLE)
				.setMessage(String.format(BUY_MAGIC_REQUEST, GlobalPlayer.PRICE_MAGIC))//
				.setPositiveButton(YES, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						buyMagicEvent.onActivate();
						if (getGlobalPlayer().getHero().isMagicActive()) {
							showMessage("Вы обучились волшебству... ");
						} else {
							showMessage("У вас недостаточно золота для обучения... ");
						}
						panel.update();
					}
				}).setNegativeButton(NO, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// nothing to do
					}
				});
	}

	private Builder getGameOverDialog() {
		return new AlertDialog.Builder(this).setCancelable(false).setTitle(YOU_FAIL)
				.setMessage(String.format(START_NEW_GAME_QUESTION, getGlobalPlayer().getHero().getScore()))//
				.setPositiveButton(YES, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						String name = getGlobalPlayer().getHero().getName();
						PlayerType type = getGlobalPlayer().getHero().getType();
						Difficulty difficulty = getGlobalPlayer().getHero().getDifficulty();
						reloadModel(name, type, difficulty);
					}
				}).setNegativeButton(NO, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						finish();
						ModelSingletonFactory.clearInstance();
						GlobalMapActivity.this.finish();
					}
				});
	}

	private Builder getSearchDialog() {
		return new AlertDialog.Builder(this).setCancelable(false).setTitle(ARE_YOU_SURE).setMessage(SEARCH_QUESTION)//
				.setPositiveButton(SEARCH, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						if (getGlobalPlayer().getCell() == getGlobalPlayer().getPasleAimCell()) {
							getWinDialog().show();
						} else {
							String[][] ss = { { "" }, { "" }, { SEARCH_FAIL } };
							panel.showMessage(ss);
							getGlobalPlayer().finishWeek();
							getGlobalPlayer().finishWeek();

						}
					}
				}).setNegativeButton(CANCEL, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Do nothing.
					}
				});
	}

	private void onResidenceInEvent() {
		Intent intent = new Intent(this, ResidenceActivity.class);
		startActivity(intent);
	}

	private void onCastleInEvent() {
		if (!castleActive) {
			Intent intent = new Intent(this, CastleActivity.class);
			startActivityForResult(intent, CASTLE_ACTIVITY_ID);
			castleActive = true;
		}
	}

	private void onTownInEvent() {
		Intent intent = new Intent(this, TownActivity.class);
		startActivity(intent);
	}

	private void onKingCastleInEvent() {
		Intent intent = new Intent(this, KingCastleActivity.class);
		startActivity(intent);
	}

	private void onBattleStartEvent() {
		Intent intent = new Intent(this, BattleActivity.class);
		startActivityForResult(intent, BATTLE_ACTIVITY_ID);
	}

	private void showArmy() {
		Intent intent = new Intent(this, ArmyActivity.class);
		startActivity(intent);
	}

	private void showVillainInfo() {
		Intent intent = new Intent(this, VillainActivity.class);
		startActivity(intent);
	}

	private void showPalse() {
		Intent intent = new Intent(this, PasleActivity.class);
		startActivity(intent);
	}

	private void showCharacter() {
		Intent intent = new Intent(this, CharacterActivity.class);
		startActivity(intent);
	}

	private void showMagic() {
		magicPanel.show();
	}

	private void showCastleList() {
		Intent intent = new Intent(this, CastleListActivity.class);
		startActivity(intent);
	}

	private void showTownList() {
		Intent intent = new Intent(this, TownListActivity.class);
		startActivity(intent);
	}

	private void showMainMenu() {
		Intent intent = new Intent(this, MainMenyActivity.class);
		startActivityForResult(intent, MENU_ACTIVITY_ID);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CASTLE_ACTIVITY_ID) {
			castleActive = false;
			if (resultCode == BattleView.BATTLE_FAIL_RESULT) {
				final String s = StringConstants.BATTLE_RESULT_FAIL;
				panel.showMessage(s);
			}
		}
		if (requestCode == BATTLE_ACTIVITY_ID) {
			if (resultCode == BattleView.BATTLE_FAIL_RESULT) {
				final String s = StringConstants.BATTLE_RESULT_FAIL;
				panel.showMessage(s);
			}
			panel.updateSiege();
			panel.updateContract();
		}
		if (requestCode == MENU_ACTIVITY_ID) {
			Context context = getApplicationContext();
			switch (resultCode) {
			case ACTION_NEW: {
				String name = data.getStringExtra(MainMenyActivity.NAME_FIELD);
				String sType = data.getStringExtra(MainMenyActivity.TYPE_FIELD);
				String sDifficulty = data.getStringExtra(MainMenyActivity.DIFFICULTY_FIELD);
				PlayerType type = PlayerType.valueOf(sType);
				Difficulty difficulty = Difficulty.valueOf(sDifficulty);
				reloadModel(name, type, difficulty);
				break;
			}
			case ACTION_SAVE: {
				final File directory = Util.getDir(context);
				if (getModel() != null) {

					String name = data == null ? null : data.getStringExtra(MainMenyActivity.NAME_FIELD);
					if (name == null) {
						new KBSaver(getModel(), directory).save();
					} else {
						new KBSaver(getModel(), directory).save(name);
					}
				}
				break;
			}
			case ACTION_LOAD: {
				final File directory = Util.getDir(context);
				String name = data.getStringExtra(MainMenyActivity.NAME_FIELD);
				if (getModel() != null) {
					new KBSaver(getModel(), directory).load(name);
				}
				panel.fullUpdate();
				break;
			}
			case ACTION_DELETE: {
				final File directory = Util.getDir(context);
				final String fName = data.getStringExtra(MainMenyActivity.NAME_FIELD);
				FilenameFilter filter = new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.equals(fName + KBSaver.EXT);
					}
				};
				for (File file : directory.listFiles(filter)) {
					file.delete();
				}
				panel.fullUpdate();
				break;
			}
			case ACTION_EXIT: {
				ModelSingletonFactory.clearInstance();
				finish();
				break;
			}
			default:
				break;
			}
		}
	}

	public void showMessage(String s) {
		userLog.append("\n" + s);
		userLogScroll.post(new Runnable() {
			@Override
			public void run() {
				userLogScroll.fullScroll(ScrollView.FOCUS_DOWN);
			}
		});
	}

	private Builder getWinDialog() {
		return new AlertDialog.Builder(this).setTitle(YOU_WIN).setMessage(String.format(START_NEW_GAME_QUESTION, getGlobalPlayer().getHero().getScore()))//
				.setPositiveButton(YES, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						String name = getGlobalPlayer().getHero().getName();
						PlayerType type = getGlobalPlayer().getHero().getType();
						Difficulty difficulty = getGlobalPlayer().getHero().getDifficulty();
						reloadModel(name, type, difficulty);
					}
				}).setNegativeButton(NO, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						finish();
						ModelSingletonFactory.clearInstance();
						GlobalMapActivity.this.finish();
					}
				});
	}
}
