
class Orange {
	private int sugarContent;

	public Orange(int sugarContent) {
		this.sugarContent = sugarContent;
	}
	
	public void showSugarContent() {
		System.out.println(sugarContent);
	}
	
}

/*
 * class OrangeBox { private Orange org; public void store(Orange org) {
 * this.org = org; } public Orange pullOut() { Orange tmp = org; org = null;
 * return tmp; }
 * 
 * }
 */

class Apple {
	private int weight;

	public Apple(int weight) {
		this.weight = weight;
	}
	public void showAppleWeight() {
		System.out.println(weight);
	}
}
/*
 * class AppleBox { private Apple ap; public void store(Apple ap) { this.ap =
 * ap; } public Apple pullOut() { Apple tmp = ap; ap = null; return tmp; }
 * 
 * }
 */

class FruitBox<T> {
	private T o;
	public void store(T o) {
		this.o = o;
	}
	public T pullOut() {
		T tmp = o;
		o = null;
		return tmp;
	}
	public FruitBox(T o) {
		store(o);
	}
	public FruitBox() {
	}
	
}



public class GenericStep1 {

	public static void main(String[] args) {
		/*
		 * OrangeBox ob = new OrangeBox(); ob.store(new Orange(10));
		 * ob.pullOut().showSugarContent();
		 * 
		 * AppleBox ab = new AppleBox(); ab.store(new Apple(200));
		 * ab.pullOut().showAppleWeight();
		 */
		
		FruitBox<Apple> ab = new FruitBox<Apple>();
		ab.store(new Apple(10));
		ab.pullOut().showAppleWeight();
		FruitBox<Orange> ob = new FruitBox<Orange>();
		ob.store(new Orange(20));
		ob.pullOut().showSugarContent();
		
		
		FruitBox<Orange> orBox=new FruitBox<Orange>(new Orange(10));
		Orange org=orBox.pullOut();
		org.showSugarContent();
		
		FruitBox<Apple> apBox=new FruitBox<Apple>(new Apple(20));
		Apple app=apBox.pullOut();
		app.showAppleWeight();
	}

}
