package Test;

import java.math.BigDecimal;

public class BigNumber {

	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("-99999999999999999999999999999999");
		BigDecimal b = new BigDecimal("1");
		System.out.println(a.subtract(b).abs());
	}

}
