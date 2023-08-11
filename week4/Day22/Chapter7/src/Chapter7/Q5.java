package Chapter7;

/*
class Product
{
	int price; // 제품의 가격
	int bonusPoint; // 제품구매 시 제공하는 보너스점수
	Product(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0);
	}
	Product(){
		this(0);
	}
}*/
/*
class Tv extends Product {
	Tv() {}
	public String toString() {
		return "Tv";
	}
}
*/
public class Q5 {

	public static void main(String[] args) {
		Tv t = new Tv();
	}

}

//자식 생성자가 자동으로 호출할 부모 생성자가 정의되어있지 않음.

/*
 * Q6 일반적으로 데이터의 안정성을 위해 멤버를 private으로 설정하는 경우 많고 멤버가 private일 경우 자식 클래스에서 직접
 * 초기화를 하는 것이 불가능하다. 따라서 부모의 필드를 초기화하기 위해선 부모 클래스의 생성자를 호출해야 한다.
 */