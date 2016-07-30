package ru.reizy.kb1990.model.constructor.filemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map.Entry;

import ru.reizy.kb1990.model.constructor.ConstructorCastles;
import ru.reizy.kb1990.model.constructor.ConstructorModel;
import ru.reizy.kb1990.model.constructor.ConstructorSignPosts;
import ru.reizy.kb1990.model.constructor.ConstructorTowns;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.FieldType;

public class BinaryFileManager implements FileManager {
	private static final String EXT = ".bmap";
	private ConstructorModel model;

	public BinaryFileManager(ConstructorModel model) {
		super();
		this.model = model;
	}

	public void load() {
		File f = new File(model.getName()+EXT);
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
					for (int j = 0; j < model.getFieldHeight(); j++) {
						int id = reader.read();
						model.setFieldType(i, j, FieldType.values()[id]);
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
			// размеры карты
			writer.println(model.getFieldWidth());
			writer.println(model.getFieldHeight());
			// сама карта
			for (int i = 0; i < model.getFieldWidth(); i++) {
				for (int j = 0; j < model.getFieldHeight(); j++) {
					int id = Arrays.binarySearch(FieldType.values(),
							model.getFieldType(i, j));
					char c = (char) id;
					writer.append(c);
				}
			}
			// замки
			saveCastles(writer);
			// города
			saveTowns(writer);
			// указатели
			saveSignPosts(writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
