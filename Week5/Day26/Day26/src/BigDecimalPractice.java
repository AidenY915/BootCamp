import java.math.BigDecimal;

public class BigDecimalPractice {

	public static void main(String[] args) {
		BigDecimal bd1 = new BigDecimal("1.6");	//스트링으로 줬기 때문에 오차가 없는 값을 초기화 됨. 1.6f를 넣으면 오차 발생
		BigDecimal bd2 = new BigDecimal("0.1");
		BigDecimal rsltAdd = bd1.add(bd2);
		BigDecimal rsltProduct = bd1.multiply(bd2);
		System.out.println(rsltAdd);
		System.out.println(rsltProduct);
	}

}
