package Chapter7;

/*class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	SutdaDeck() {
		for(int i = 0 ; i < CARD_NUM ; i ++) {
			int month = i%10 + 1;
			cards[i] = new SutdaCard(month, (month == 1 || month == 3  || month == 8)  && i < 10 ? true : false);
		}
	}
}*/
/*class SutdaCard {
	int num;
	boolean isKwang;
	SutdaCard() {
		this(1, true);
	}
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	// info() Object toString() . 대신 클래스의 을 오버라이딩했다
	public String toString() {
		return num + ( isKwang ? "K":"");
	}
}*/
class Q1 {
	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();
		for(int i=0; i < deck.cards.length;i++)
			System.out.print(deck.cards[i]+",");
	}
}