package practice;

class A {
	private int n ;
	@Override
	public String toString() {
		return n+"";
	}	
	public A(int n) {
		super();
		this.n = n;
	}
	public int getN() {
		return n;
	}
}

public class Wrraper {

	public static void showData(Object obj)
	{
		System.out.println(obj);
	}
	
	
	public static void main(String[] args) {
		int n = 3;
		double d = 7.15;
		Integer k = 3;
		
		A a = new A(4);
		showData(a);
		
		
		
		showData(k);
		
		showData(n);
		showData(d);
	}

}
