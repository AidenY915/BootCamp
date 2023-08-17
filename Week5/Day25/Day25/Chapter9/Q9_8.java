
public class Q9_8 {
	
	private static double round(double d, int digit) {
		int powerOf10 = (int)Math.pow(10, digit);
		return (int)(d*powerOf10 + 0.5) / (double)powerOf10;
		
	}
	
	public static void main(String[] args) {
		System.out.println(round(3.1415,1));
		System.out.println(round(3.1415,2));
		System.out.println(round(3.1415,3));
		System.out.println(round(3.1415,4));
		System.out.println(round(3.1415,5));
	}
}
