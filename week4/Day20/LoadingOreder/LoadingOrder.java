class A {
	public static int a1 = B.b1;
	public static int a2 = 2;
}

class B {
	public static int b2 = A.a2;
	public static int b1 = 1;

}

public class LoadingOrder {
	public static void main(String[] args) {
		System.out.println(B.b1 + " " + A.a1);
		System.out.println(A.a2 + " " + B.b2);
	}
}