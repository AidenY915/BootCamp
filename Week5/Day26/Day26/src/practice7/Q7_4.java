package practice7;

import java.math.BigDecimal;

public class Q7_4 {

	public static void main(String[] args) {
		BigDecimal bd1 = new  BigDecimal("1.6");
		BigDecimal bd2 = new  BigDecimal("0.1");
		System.out.println(bd1.add(bd2));
		System.out.println(bd1.multiply(bd2));
	}
}