package ru.reizy.kb1990.view.android;

import static ru.reizy.kb1990.view.strings.ru.StringConstants.ABOUT_TEXT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.ABOUT_TITLE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.CANCEL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.DIFFICULTY_EASY;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.DIFFICULTY_HARD;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.DIFFICULTY_IMPOSIBLE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.DIFFICULTY_NORMAL;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.DROP;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.DROP_TITLE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.ERROR;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.ERROR_REGEXP;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.EXIT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.LOAD;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.LOAD_TITLE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.NEW_GAME;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.NEW_GAME_NAME_REQUEST;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.NEW_GAME_TITLE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.NEXT;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.OK;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.OPTIONS;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.RESUME;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.SAVE;
import static ru.reizy.kb1990.view.strings.ru.StringConstants.SAVE_AS;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.reizy.kb1990.model.globalmap.Difficulty;
import ru.reizy.kb1990.model.globalmap.PlayerType;
import ru.reizy.kb1990.saveload.KBSaver;
import ru.reizy.kb1990.view.android.globalmap.GlobalMapActivity;
import ru.reizy.kb1990.view.android.resource.NameResolver;
import ru.reizy.kb1990.view.android.resource.Util;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

public class MainMenyActivity extends ListActivity {

	public static final String DIFFICULTY_FIELD = "difficulty";
	public static final String TYPE_FIELD = "type";
	public static final String NAME_FIELD = "name";
	private static final String NAME_PATTERN = "^[а-яА-Я\\w-]{1,15}$";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final List<Wrapper> wrappers = new ArrayList<Wrapper>();
		wrappers.add(new Wrapper(RESUME) {
			@Override
			public void execute() {
				setResult(GlobalMapActivity.ACTION_CANCEL);
				finish();
			}

		});
		wrappers.add(new Wrapper(NEW_GAME) {
			@Override
			public void execute() {
				newGame();
			}

		});
		wrappers.add(new Wrapper(SAVE) {
			@Override
			public void execute() {
				setResult(GlobalMapActivity.ACTION_SAVE);
				finish();
			}

		});
		wrappers.add(new Wrapper(SAVE_AS) {
			@Override
			public void execute() {
				saveGame();
			}

		});
		wrappers.add(new Wrapper(LOAD) {
			@Override
			public void execute() {
				if (getSaveList().size() > 0) {
					loadGame();
				}
			}
		});
		wrappers.add(new Wrapper(DROP) {
			@Override
			public void execute() {
				if (getSaveList().size() > 0) {
					deleteSavedGame();
				}
			}
		});
		wrappers.add(new Wrapper(EXIT) {
			@Override
			public void execute() {
				setResult(GlobalMapActivity.ACTION_EXIT);
				finish();
			}
		});
		wrappers.add(new Wrapper(ABOUT_TITLE) {
			@Override
			public void execute() {
				getAboutDialog().show();
			}
		});
		wrappers.add(new Wrapper(OPTIONS) {
			@Override
			public void execute() {
				showOptions();
			}
		});
		ArrayAdapter<Wrapper> adapter = new ArrayAdapter<Wrapper>(this, android.R.layout.simple_list_item_1, wrappers);
		setListAdapter(adapter);
		OnItemClickListener itemListener = new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Wrapper item = (Wrapper) parent.getItemAtPosition(position);
				item.execute();
			}
		};
		getListView().setOnItemClickListener(itemListener);
	}

	private void saveGame() {
		getSaveAsDialog().show();
	}

	private void loadGame() {
		getLoadDialog().show();
	}

	private void deleteSavedGame() {
		getDeleteSavedDialog().show();
	}

	private void newGame() {
		getPlayerNameDialog().show();
	}

	private void showOptions() {
		Intent intent = new Intent(this, KbOptionsActivity.class);
		startActivity(intent);
	}

	private Builder getSaveAsDialog() {
		final EditText inputName = new EditText(this);
		inputName.setLines(1);

		return new AlertDialog.Builder(this).setTitle(NEW_GAME_TITLE).setMessage(NEW_GAME_NAME_REQUEST)//
				.setView(inputName)//
				.setPositiveButton(NEXT, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						Editable value = inputName.getText();
						final String name = value.toString();
						Pattern p = Pattern.compile(NAME_PATTERN);
						Matcher m = p.matcher(name);
						if (m.matches()) {
							Intent data = getIntent();
							data.putExtra(NAME_FIELD, name);
							setResult(GlobalMapActivity.ACTION_SAVE, data);
							finish();
						} else {
							getErrorRegexpDialog().show();
						}
					}
				}).setNegativeButton(CANCEL, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// nothing to do
					}
				});
	}

	private Builder getErrorRegexpDialog() {
		return new AlertDialog.Builder(MainMenyActivity.this).setTitle(ERROR).setMessage(ERROR_REGEXP)
				.setPositiveButton(OK, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// nothing to do
					}
				});
	}

	private Builder getPlayerNameDialog() {
		final EditText inputName = new EditText(this);
		inputName.setLines(1);
		final RadioGroup inputType = new RadioGroup(this);
		for (PlayerType type : PlayerType.values()) {
			RadioButton rb = new RadioButton(this);
			rb.setText(type.toString());
			inputType.addView(rb);
		}
		return new AlertDialog.Builder(this).setTitle(NEW_GAME_TITLE).setMessage(NEW_GAME_NAME_REQUEST)//
				.setView(inputName)//
				.setPositiveButton(NEXT, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						Editable value = inputName.getText();
						final String name = value.toString();
						Pattern p = Pattern.compile(NAME_PATTERN);
						Matcher m = p.matcher(name);
						if (m.matches()) {
							getPlayerTypeDialog(name).show();
						} else {
							getErrorRegexpDialog().show();
						}
					}
				}).setNegativeButton(CANCEL, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Do nothing.
					}
				});
	}

	private Builder getPlayerTypeDialog(final String name) {
		final ScrollView scroll = new ScrollView(this);
		final RadioGroup inputType = new RadioGroup(this);
		for (int i = 0; i < PlayerType.values().length; i++) {
			PlayerType type = PlayerType.values()[i];
			RadioButton rb = new RadioButton(this);
			rb.setChecked(i == 0);
			final String profession = NameResolver.getProfession(type, 0);
			rb.setText(profession);
			rb.setId(i);
			inputType.addView(rb);
		}
		scroll.addView(inputType);
		return new AlertDialog.Builder(this).setTitle(NEW_GAME_TITLE)// .setMessage("Выберите класс")//
				.setView(scroll)//
				.setPositiveButton(NEXT, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						int id = inputType.getCheckedRadioButtonId();
						final String type = PlayerType.values()[id].toString();
						getPlayerDaysDialog(name, type).show();
					}
				}).setNegativeButton(CANCEL, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Do nothing.
					}
				});
	}

	private Builder getPlayerDaysDialog(final String name, final String type) {
		final ScrollView scroll = new ScrollView(this);
		final RadioGroup inputType = new RadioGroup(this);
		final String[] ds = { DIFFICULTY_EASY, DIFFICULTY_NORMAL, DIFFICULTY_HARD, DIFFICULTY_IMPOSIBLE };
		for (int i = 0; i < Difficulty.values().length; i++) {
			RadioButton rb = new RadioButton(this);
			rb.setText(ds[i] + "(" + Difficulty.values()[i].getDays() + " дней) x" + Difficulty.values()[i].getScoreMultiplier());
			rb.setChecked(i == 1);
			rb.setId(i);
			inputType.addView(rb);
		}
		scroll.addView(inputType);
		return new AlertDialog.Builder(this).setTitle(NEW_GAME_TITLE)// .setMessage("Выберите сложность")//
				.setView(scroll)//
				.setPositiveButton(NEXT, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// todo validate
						int id = inputType.getCheckedRadioButtonId();
						Intent data = getIntent();
						data.putExtra(NAME_FIELD, name);
						data.putExtra(TYPE_FIELD, type);
						data.putExtra(DIFFICULTY_FIELD, Difficulty.values()[id].toString());
						setResult(GlobalMapActivity.ACTION_NEW, data);
						finish();
					}
				}).setNegativeButton(CANCEL, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Do nothing.
					}
				});
	}

	private Builder getLoadDialog() {
		final ScrollView scroll = new ScrollView(this);
		final RadioGroup inputType = new RadioGroup(this);
		final List<String> strings = getSaveList();
		for (int i = 0; i < strings.size(); i++) {
			RadioButton rb = new RadioButton(this);
			rb.setText(strings.get(i).toString());
			rb.setChecked(i == 0);
			rb.setId(i);
			inputType.addView(rb);
		}
		scroll.addView(inputType);
		return new AlertDialog.Builder(this).setTitle(LOAD_TITLE)//
				.setView(scroll)//
				.setPositiveButton(LOAD, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						int id = inputType.getCheckedRadioButtonId();
						Intent data = getIntent();
						data.putExtra(NAME_FIELD, strings.get(id).toString());
						setResult(GlobalMapActivity.ACTION_LOAD, data);
						finish();
					}
				}).setNegativeButton(CANCEL, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Do nothing.
					}
				});
	}

	private Builder getDeleteSavedDialog() {
		final ScrollView scroll = new ScrollView(this);
		final RadioGroup inputType = new RadioGroup(this);
		final List<String> strings = getSaveList();
		for (int i = 0; i < strings.size(); i++) {
			RadioButton rb = new RadioButton(this);
			rb.setText(strings.get(i).toString());
			rb.setChecked(i == 0);
			rb.setId(i);
			inputType.addView(rb);
		}
		scroll.addView(inputType);
		return new AlertDialog.Builder(this).setTitle(DROP_TITLE)//
				.setView(scroll)//
				.setPositiveButton(DROP, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						int id = inputType.getCheckedRadioButtonId();
						Intent data = getIntent();
						data.putExtra(NAME_FIELD, strings.get(id).toString());
						setResult(GlobalMapActivity.ACTION_DELETE, data);
						finish();
					}
				}).setNegativeButton(CANCEL, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Do nothing.
					}
				});
	}

	private Builder getAboutDialog() {
		PackageManager m = getPackageManager();
		String app_ver = "";
		try {
			app_ver = m.getPackageInfo(this.getPackageName(), 0).versionName;
		} catch (NameNotFoundException e) {
			// Exception won't be thrown as the current package name is
			// safe to exist on the system.
			throw new AssertionError();
		}
		String app_type = "";
		Context context = getApplicationContext();

		if (Util.isLocalStorage(context)) {
			app_type = "loc";
		} else {
			app_type = "ext";
		}
		return new AlertDialog.Builder(this).setTitle(ABOUT_TITLE)//
				.setMessage(String.format(ABOUT_TEXT, app_ver, app_type))//
				.setPositiveButton(OK, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

					}

				});
	}

	private List<String> getSaveList() {
		Context context = getApplicationContext();
		File dir = Util.getDir(context);
		ArrayList<String> files = new ArrayList<String>();
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(KBSaver.EXT);
			}
		};
		for (File file : dir.listFiles(filter)) {
			String name = file.getName();
			name = name.substring(0, name.length() - KBSaver.EXT.length());
			files.add(name);
		}
		return files;

	}

	/**
	 * @return
	 */

	private abstract class Wrapper {

		private String name;

		public Wrapper(String name) {
			this.name = name;
		}

		public abstract void execute();

		@Override
		public String toString() {
			return name;
		}
	}
}
