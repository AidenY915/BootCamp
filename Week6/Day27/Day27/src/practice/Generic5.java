package practice;

class DBox<L, R>{
	private L left;
	private R right;
	public void set(L o, R r) {
		left = o;
		right = r;
	}
	public String toString() { return left + " & " + right; }
}

class DDBox<U, D>{
	private U left;
	private D right;
	public void set(U o, D r) {
		left = o;
		right = r;
	}
	public String toString() { return left + "\n" + right; }
}

public class Generic5 {

	public static void main(String[] args){
		DBox<String, Integer> box1 = new DBox<>();
		box1.set("Apple", 25);
		DBox<String, Integer> box2 = new DBox<>();
		box2.set("Orange", 33);
		DDBox<DBox<String, Integer>, DBox<String, Integer>> ddbox = new DDBox<>();
		ddbox.set(box1, box2);	// 두 개의 상자를 하나의 상자에 담음
		System.out.println(ddbox);	// 상자의 내용물 출력
	}
}
