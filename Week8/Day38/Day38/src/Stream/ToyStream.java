package Stream;

import java.util.List;
import java.util.ArrayList;

class ToyPriceInfo {
	private String model;
	private int price;

	public ToyPriceInfo(String m, int p) {
		model = m;
		price = p;
	}

	public int getPrice() {
		return price;
	}

	public String getModel() { return model; }
}

class ToyStream {
	public static void main(String[] args) {
		List<ToyPriceInfo> ls = new ArrayList<>();
		ls.add(new ToyPriceInfo("GUN_LR_45", 200));
		ls.add(new ToyPriceInfo("TEDDY_BEAR_S_014", 350));
		ls.add(new ToyPriceInfo("CAR_TRANSFORM_VER_7719", 550));

		ls.stream()
		.filter(p -> p.getPrice() < 500)
		.filter(p -> p.getModel().length() > 10)
		.map(t -> t.getModel())
		.forEach(System.out::println);

	}
}