package Q13;

class Outer {
	class Inner {
		int x = 3;
		
	}
	static class staticInner {
		int x = 10;
	}
}

public class Q13 {

	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();
		System.out.println(in.x);
		Outer.staticInner staticIn = new Outer.staticInner();
		System.out.println(staticIn.x);
	}

}
