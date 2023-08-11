package Chapter7;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	SutdaDeck() {
		for(int i = 0 ; i < CARD_NUM ; i ++) {
			int month = i%10 + 1;
			cards[i] = new SutdaCard(month, (month == 1 || month == 3  || month == 8)  && i < 10 ? true : false);
		}
	}
	public String pick(int idx) {
		return cards[idx].toString();
	}
	public String pick() {
		return cards[(int)(Math.random()*CARD_NUM)].toString();
	}
	public void shuffle() {
		for(int i = CARD_NUM -1; i > 0 ; i--) {
			int j = (int)(Math.random() * (i+1));
			SutdaCard tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	}
	// SutdaDeck
	/*
	 * class SutdaCard { int num; boolean isKwang; SutdaCard() { this(1, true); }
	 * SutdaCard(int num, boolean isKwang) { this.num = num; this.isKwang = isKwang;
	 * } public String toString() { return num + ( isKwang ? "K":""); } }
	 */
	class Q2 {
		public static void main(String args[]) {
			SutdaDeck deck = new SutdaDeck();
			System.out.println(deck.pick(0));
			System.out.println(deck.pick());
			deck.shuffle();
			for(int i=0; i < deck.cards.length;i++)
				System.out.print(deck.cards[i]+",");
			System.out.println();
			System.out.println(deck.pick(0));
		}
	}
}
/*
 * Q3 오버라이딩은 상속을 받은 부모의 메소드를 자식의 클래스에서 재정의하는 것이다. 오버라이딩을 하기 위해서는 반환형과 메소드 시그니처가
 * 같아야 한다. 오버라이딩을 통해 다형성이 구현되며, 이 다형성을 통해 여러 클래스의 객체들을 일괄적으로 관리할 수 있게 되어 유지보수에
 * 용이하며, 코드의 간결성을 확보할 수 있다.
 * 
 */

//Q4 c, d
