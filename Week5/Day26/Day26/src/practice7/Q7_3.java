package practice7;

import java.math.BigInteger;

public class Q7_3 {

	public static void main(String[] args) {
		BigInteger bi1 = new BigInteger("100000000000000000000");
		BigInteger bi2 = new BigInteger("-99999999999999999999");
		System.out.println(bi1.add(bi2));
		System.out.println(bi1.multiply(bi2));
	}

}
