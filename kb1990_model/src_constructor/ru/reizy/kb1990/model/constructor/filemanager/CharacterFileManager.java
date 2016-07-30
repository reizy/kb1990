package ru.reizy.kb1990.model.constructor.filemanager;

import static ru.reizy.kb1990.model.globalmap.FieldType.BONUS;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_B;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_I;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_ILB;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_ILT;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_IRB;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_IRT;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_L;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_O;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_OLB;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_OLT;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_ORB;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_ORT;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_R;
import static ru.reizy.kb1990.model.globalmap.FieldType.BUSH_T;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_B;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_BL;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_BR;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_S;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_T;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_TL;
import static ru.reizy.kb1990.model.globalmap.FieldType.CASTLE_TR;
import static ru.reizy.kb1990.model.globalmap.FieldType.ENEMY;
import static ru.reizy.kb1990.model.globalmap.FieldType.GRASS;
import static ru.reizy.kb1990.model.globalmap.FieldType.HERO;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_B;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_I;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_ILB;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_ILT;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_IRB;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_IRT;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_L;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_O;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_OLB;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_OLT;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_ORB;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_ORT;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_R;
import static ru.reizy.kb1990.model.globalmap.FieldType.HILL_T;
import static ru.reizy.kb1990.model.globalmap.FieldType.MAGE;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_B;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_I;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_ILB;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_ILT;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_IRB;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_IRT;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_L;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_O;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_OLB;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_OLT;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_ORB;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_ORT;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_R;
import static ru.reizy.kb1990.model.globalmap.FieldType.POOL_T;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_B;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_I;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_ILB;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_ILT;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_IRB;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_IRT;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_L;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_O;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_OLB;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_OLT;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_ORB;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_ORT;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_R;
import static ru.reizy.kb1990.model.globalmap.FieldType.SAND_T;
import static ru.reizy.kb1990.model.globalmap.FieldType.SIGNPOST;
import static ru.reizy.kb1990.model.globalmap.FieldType.TOWN;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ru.reizy.kb1990.model.constructor.ConstructorCastles;
import ru.reizy.kb1990.model.constructor.ConstructorModel;
import ru.reizy.kb1990.model.constructor.ConstructorSignPosts;
import ru.reizy.kb1990.model.constructor.ConstructorTowns;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.FieldType;

public class CharacterFileManager implements FileManager {
	private static final String EXT = ".cmap";

	private static final Map<FieldType, Character> d = new HashMap<FieldType, Character>();
	private static final Map<Character, FieldType> d_ = new HashMap<Character, FieldType>();
	private ConstructorModel model;
	static {
		d.put(HILL_ILB, '┌');
		d.put(HILL_IRB, '┐');
		d.put(HILL_ILT, '└');
		d.put(HILL_IRT, '┘');
		d.put(HILL_OLB, '┼');
		d.put(HILL_ORB, '┼');
		d.put(HILL_OLT, '┼');
		d.put(HILL_ORT, '┼');
		d.put(HILL_L, '├');
		d.put(HILL_R, '┤');
		d.put(HILL_T, '┴');
		d.put(HILL_B, '┬');
		d.put(HILL_I, '¤');
		d.put(HILL_O, '┼');

		d.put(SAND_ILB, '░');
		d.put(SAND_IRB, '░');
		d.put(SAND_ILT, '░');
		d.put(SAND_IRT, '░');
		d.put(SAND_OLB, '░');
		d.put(SAND_ORB, '░');
		d.put(SAND_OLT, '░');
		d.put(SAND_ORT, '░');
		d.put(SAND_L, '░');
		d.put(SAND_R, '░');
		d.put(SAND_T, '░');
		d.put(SAND_B, '░');
		d.put(SAND_I, '░');
		d.put(SAND_O, '░');

		d.put(BUSH_ILB, '╔');
		d.put(BUSH_IRB, '╗');
		d.put(BUSH_ILT, '╚');
		d.put(BUSH_IRT, '╝');
		d.put(BUSH_OLB, '╬');
		d.put(BUSH_ORB, '╬');
		d.put(BUSH_OLT, '╬');
		d.put(BUSH_ORT, '╬');
		d.put(BUSH_L, '╠');
		d.put(BUSH_R, '╣');
		d.put(BUSH_T, '╩');
		d.put(BUSH_B, '╦');
		d.put(BUSH_I, '■');
		d.put(BUSH_O, '╬');

		d.put(POOL_ILB, '▓');
		d.put(POOL_IRB, '▓');
		d.put(POOL_ILT, '▓');
		d.put(POOL_IRT, '▓');
		d.put(POOL_OLB, '▓');
		d.put(POOL_ORB, '▓');
		d.put(POOL_OLT, '▓');
		d.put(POOL_ORT, '▓');
		d.put(POOL_L, '▓');
		d.put(POOL_R, '▓');
		d.put(POOL_T, '▓');
		d.put(POOL_B, '▓');
		d.put(POOL_I, '▓');
		d.put(POOL_O, '▓');

		d.put(CASTLE_TL, '╒');
		d.put(CASTLE_T, '╤');
		d.put(CASTLE_TR, '╕');
		d.put(CASTLE_BL, '╘');
		d.put(CASTLE_B, '╪');
		d.put(CASTLE_BR, '╛');
		d.put(CASTLE_S, 'U');

		d.put(GRASS, ' ');
		d.put(TOWN, '◙');
		d.put(SIGNPOST, '¶');
		d.put(BONUS, '♫');
		d.put(ENEMY, '☻');
		d.put(MAGE, '*');
		d.put(HERO, '☺');
	}

	public CharacterFileManager(ConstructorModel model) {
		super();
		this.model = model;
	}

	public void load() {
		File f = new File(model.getName() + EXT);
		if (f.exists()) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(f));
				// размеры карты
				int x = Integer.parseInt(reader.readLine());
				int y = Integer.parseInt(reader.readLine());
				model.init(x, y);
				// сама карта
				for (int i = 0; i < model.getFieldWidth(); i++) {
					String s = reader.readLine();
					for (int j = 0; j < model.getFieldHeight(); j++) {
						FieldType ft = d_.get(s.charAt(j));
						model.setFieldType(i, j, ft);
					}
				}
				// замки
				loadCastles(reader);
				// города
				loadTowns(reader);
				// города
				loadSignPosts(reader);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			model.init(64, 64);
		}
	}

	public void save() {
		File f = new File(model.getName() + EXT);
		PrintWriter writer = null;
		try {

			f.createNewFile();
			writer = new PrintWriter(f);
//			for (int i = 0; i < 255; i++) {
//				for (int j = 0; j < 255; j++) {
//					char c = (char) (i * 255 + j);
//					writer.append(c);
//				}
//				writer.println();
//			}
			// размеры карты
			writer.println(model.getFieldWidth());
			writer.println(model.getFieldHeight());
			// сама карта
			for (int j = 0; j < model.getFieldHeight(); j++) {
				for (int i = 0; i < model.getFieldWidth(); i++) {
					Character character = d.get(model.getFieldType(i,
							model.getFieldHeight() - j));
					char c = character == null ? '*' : character;
					writer.append(c);
				}
				writer.println();
			}
			// замки
			saveCastles(writer);
			// города
			saveTowns(writer);
			// указатели
			saveSignPosts(writer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	void loadCastles(BufferedReader br) throws IOException {

		final String line = br.readLine() + br.readLine();
		if (line != null) {
			int size = Integer.parseInt(line);
			final ConstructorCastles castles = model.getCastles();
			for (int i = 0; i < size; i++) {
				int x = Integer.parseInt(br.readLine());
				int y = Integer.parseInt(br.readLine());
				String name = br.readLine();
				castles.setCastle(x, y, name);
			}
		}
	}

	private void saveCastles(PrintWriter writer) throws IOException {
		final ConstructorCastles castles = model.getCastles();
		int size = castles.getCastles().size();
		writer.println();
		writer.println(size);
		for (Entry<Cell, String> e : castles.getCastles().entrySet()) {
			int x = e.getKey().getX();
			int y = e.getKey().getY();
			String name = e.getValue();
			writer.println(x);
			writer.println(y);
			writer.println(name);
		}
	}

	void loadTowns(BufferedReader br) throws IOException {
		br.readLine();
		final String line = br.readLine();
		if (line != null) {
			int size = Integer.parseInt(line);
			final ConstructorTowns towns = model.getTowns();
			for (int i = 0; i < size; i++) {
				int x = Integer.parseInt(br.readLine());
				int y = Integer.parseInt(br.readLine());
				String name = br.readLine();
				int cx = Integer.parseInt(br.readLine());
				int cy = Integer.parseInt(br.readLine());
				String castle = model.getCastles().getCastle(cx, cy);
				towns.setTown(x, y, name, castle);
			}
		}
	}

	private void saveTowns(PrintWriter writer) throws IOException {
		final ConstructorTowns towns = model.getTowns();
		int size = towns.getTowns().size();
		System.err.println(size);
		writer.println();
		writer.println(size);
		for (Entry<Cell, String> e : towns.getTowns().entrySet()) {
			int x = e.getKey().getX();
			int y = e.getKey().getY();
			String name = e.getValue();
			String castle = towns.getCastle(e.getKey());
			int cx = 0;
			int cy = 0;
			Cell cell = model.getTowns().getCastleCell(castle);
			if (cell != null) {
				cx = cell.getX();
				cy = cell.getY();
			}
			writer.println(x);
			writer.println(y);
			writer.println(name);
			writer.println(cx);
			writer.println(cy);
		}
	}

	void loadSignPosts(BufferedReader br) throws IOException {

		final String line = br.readLine() + br.readLine();
		if (line != null) {
			int size = Integer.parseInt(line);
			final ConstructorSignPosts signPosts = model.getSignPosts();
			for (int i = 0; i < size; i++) {
				int x = Integer.parseInt(br.readLine());
				int y = Integer.parseInt(br.readLine());
				String text = br.readLine();
				signPosts.setSignPost(x, y, text);
			}
		}
	}

	private void saveSignPosts(PrintWriter writer) throws IOException {
		final ConstructorSignPosts signPosts = model.getSignPosts();
		int size = signPosts.getSignPosts().size();
		writer.println();
		writer.println(size);
		for (Entry<Cell, String> e : signPosts.getSignPosts().entrySet()) {
			int x = e.getKey().getX();
			int y = e.getKey().getY();
			String text = e.getValue();
			writer.println(x);
			writer.println(y);
			writer.println(text);
		}
	}
}
