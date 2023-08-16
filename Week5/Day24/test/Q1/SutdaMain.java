package Q1;

class SutdaCard {
	private int num;
	private boolean isKwang;
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	SutdaCard(int num) {
		this.num = num;
	}
	public void showCard() {
		System.out.println(num + " " + (isKwang ? "K" : ""));
	}
}

class SutdaDeck {
	private SutdaCard[] cardArr = new SutdaCard[20];

	SutdaDeck() {
		for(int i = 0 ; i < cardArr.length; i++) {
			cardArr[i] = new SutdaCard(i%10+1, i == 0|| i == 2 || i == 7);
		}
	}
	public void shuffle() {
		for(int i = cardArr.length - 1 ; i >= 0; i--) {
			int j = (int)(Math.random() * (i + 1));
			SutdaCard tmp = cardArr[i];
			cardArr[i] = cardArr[j];
			cardArr[j] = tmp;
		}
	}
	public SutdaCard pick(int i) {
		return cardArr[i];
	}
	public SutdaCard pick() {
		return cardArr[(int)(Math.random()*cardArr.length)];
	}
}

public class SutdaMain {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		deck.pick(0).showCard();
		deck.shuffle();
		deck.pick(0).showCard();
		deck.pick().showCard();
	}

}
