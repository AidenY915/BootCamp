package Chapter7;

class SutdaCard {
	final int num;
	final boolean isKwang;
	SutdaCard() {
		this(1, true);
	}
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	public String toString() {
		return num + ( isKwang ? "K":"");
	}
}

public class Q14 {

	public static void main(String[] args) {
		SutdaCard card = new SutdaCard(1, true);
		System.out.println(card);
		
	}

}

//Q15 e 부모 -> 자식 불가 
//Q16 e

//Q17
abstract class Unit {
	int x, y;
	void move(int x, int y) {} 
	void stop() { /* */ } 
}
class Marine extends Unit { // 보병
	void stimPack() { /* .*/} 
}
class Tank extends Unit{ // 탱크
	void changeMode() { /* . */}
}
class Dropship extends Unit{ // 수송선
	void load() { /* .*/ } 
	void unload() { /* .*/ } 
}
