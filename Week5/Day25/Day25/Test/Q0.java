class IntWrapper {
	private int n;
	public IntWrapper(int n) {
		this.n = n;
	}
	@Override
	public String toString() {
		return String.valueOf(n);
	}
}
class DoubleWrapper {
	double d;
	public DoubleWrapper(double d) {
		this.d = d;
	}
	@Override
	public String toString() {
		return String.valueOf(d);
	}
}


public class Q0 {

	public static void showData(Object obj)
	{
		System.out.println(obj);
	}
	
	public static void main(String[] args) {
		int n = 4;
		double d = 5;
		IntWrapper iw = new IntWrapper(n);
		DoubleWrapper dw = new DoubleWrapper(d);
		
		showData(iw); showData(dw);
		showData(Integer.valueOf(n));	//boxing
		showData(Double.valueOf(d));
		System.out.println(Integer.valueOf(n).intValue());	//unboxing
	}

}
