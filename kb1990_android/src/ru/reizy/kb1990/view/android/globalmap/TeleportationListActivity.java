package ru.reizy.kb1990.view.android.globalmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import ru.reizy.kb1990.KBModel;
import ru.reizy.kb1990.model.globalmap.Cell;
import ru.reizy.kb1990.model.globalmap.GlobalMap;
import ru.reizy.kb1990.model.globalmap.residence.Residence;
import ru.reizy.kb1990.view.android.ModelSingletonFactory;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public abstract class TeleportationListActivity<T extends Residence> extends ListActivity {
	private ArrayAdapter<Wrapper> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Set<T> tSet = getTSet();
		final List<Wrapper> wrappers = new ArrayList<Wrapper>();
		wrappers.add(new Wrapper(null));
		for (T t : tSet) {
			Wrapper wrapper = new Wrapper(t);
			wrappers.add(wrapper);
		}
		adapter = new ArrayAdapter<Wrapper>(this, android.R.layout.simple_list_item_1, wrappers);
		adapter.sort(new WrapperComparator());
		setListAdapter(adapter);
		OnItemClickListener itemListener = new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				@SuppressWarnings("unchecked")
				Wrapper item = (Wrapper) parent.getItemAtPosition(position);
				T t = item.get();
				if (t != null) {
					Cell cell = t.getOutCell();
					final GlobalMap map = cell.getMap();
					final int x = cell.getX();
					final int y = cell.getY();
					map.goTo(x, y);
				}
				finish();
			}
		};
		getListView().setOnItemClickListener(itemListener);
	}

	protected KBModel getModel() {
		return ModelSingletonFactory.getInstance();
	}

	/**
	 * @return
	 */
	protected abstract Set<T> getTSet();

	protected abstract String objectToString(T t);

	private final class WrapperComparator implements Comparator<Wrapper> {
		@Override
		public int compare(TeleportationListActivity<T>.Wrapper lhs, TeleportationListActivity<T>.Wrapper rhs) {
			int compare = lhs.get() == null ? -1 : rhs.get() == null ? 1 : 0;
			if (compare == 0) {
				compare = lhs.toString().compareTo(rhs.toString());
			}
			return compare;
		}
	}

	private class Wrapper {

		private T t;

		public Wrapper(T t) {
			this.t = t;
		}

		public T get() {
			return t;
		}

		@Override
		public String toString() {
			final String name = (t == null) ? "Назад" : objectToString(t);
			return name;
		}
	}
}
