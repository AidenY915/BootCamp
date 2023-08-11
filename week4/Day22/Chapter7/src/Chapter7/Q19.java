package Chapter7;

public class Q19 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.summary();
	}

}

class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
	int i = 0; // Product cart index 배열 에 사용될
	void buy(Product p) {
		int price = p.getPrice();
		if(money < price) {System.out.println("돈 부족"); return;}
		money -= price;
		add(p);
		/*
(1) . 아래의 로직에 맞게 코드를 작성하시오
1.1 . 가진 돈과 물건의 가격을 비교해서 가진 돈이 적으면 메서드를 종료한다
1.2 , 가진 돈이 충분하면 제품의 가격을 가진 돈에서 빼고
1.3 .(add ) 장바구니에 구입한 물건을 담는다 메서드 호출
		 */
	}
	void add(Product p) {
		if(i >= cart.length) {
			Product[] tmp = new Product[cart.length * 2];
			System.arraycopy(cart, 0, tmp, 0, cart.length);
			cart = tmp;
		}
		cart[i++] = p;
	} // add(Product p)
	void summary() {
		int sum = 0;
		for(int j = 0 ; j < i ; j++) {
			System.out.print(cart[j] + " ");
			sum += cart[j].getPrice();
		}
		System.out.println();
		System.out.println(sum);
		System.out.println(money);
	} // summary()
}
class Product {
	private int price; // 제품의 가격
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	Product(int price) {
		this.price = price;
	}
}
class Tv extends Product {
	Tv() { super(100); }
	public String toString() { return "Tv"; }
}
class Computer extends Product {
	Computer() { super(200); }
	public String toString() { return "Computer";}
}
class Audio extends Product {
	Audio() { super(50); }
	public String toString() { return "Audio"; }
}