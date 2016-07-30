package kb.constructor;

import kb.constructor.view.ConstructorView;
import ru.reizy.kb1990.model.constructor.ConstructorModel;

public class StartConstructor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConstructorModel model = new ConstructorModel();
		model.load("1");
		new ConstructorView(model);
	}
}
