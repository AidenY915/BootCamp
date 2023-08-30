package morningTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SutdaCard {
	private int num;
	private boolean isKwang;
	public SutdaCard(int num, boolean isKwang) {
		super();
		this.num = num;
		this.isKwang = isKwang;
	}
	public int getNum() {
		return num;
	}
	public boolean isKwang() {
		return isKwang;
	}
}



class SutdaDeck {
	SutdaCard[] cards = new SutdaCard[20];
	int last;
	static Map<String, Integer> pairToScore;
	static {
		pairToScore = new HashMap<String, Integer>();
		pairToScore.put("KK",4000);
		pairToScore.put("1010",3100);
		pairToScore.put("99",3090);
		pairToScore.put("88",3080);
		pairToScore.put("77",3070);
		pairToScore.put("66",3060);
		pairToScore.put("55",3050);
		pairToScore.put("44",3040);
		pairToScore.put("33",3030);
		pairToScore.put("22",3020);
		pairToScore.put("11",3010);
		pairToScore.put("12",2060);
		pairToScore.put("14",2050);
		pairToScore.put("19",2040);
		pairToScore.put("110",2030);
		pairToScore.put("410",2020);
		pairToScore.put("46",2010);
	}
	public SutdaDeck() {
		for(int i = 0; i < 20; i++) {
			cards[i] = new SutdaCard(i%10+1, i == 0 || i == 2 || i == 7); 
		}
	}
	public SutdaCard pick() {
		return cards[last++];
	}

	public void shuffle() {
		for(int i = cards.length - 1; i >= 1; i--) {
			int j = (int)(Math.random()*(i+1));
			SutdaCard tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	}
	public static int getScore(SutdaCard card1 , SutdaCard card2) {
		String pair = "";
		int min = 0;
		int max = 0;
		if(card1.isKwang() && card2.isKwang())
			pair = "KK";
		else {
			min = Math.min(card1.getNum(),card2.getNum());
			max = Math.max(card1.getNum(),card2.getNum());
			pair = ""+min+max;
		}
		Integer rslt = pairToScore.get(pair);
		if(rslt == null)
			rslt = (min+max)%10+1000;
		return rslt;
	}
}



class Player {
	private String name;
	private SutdaCard card1 , card2;
	private int score;
	public Player(String name, SutdaCard card1, SutdaCard card2) {
		this.name = name;
		this.card1 = card1;
		this.card2 = card2;
		score = SutdaDeck.getScore(card1, card2);
	}
	public int getScore() {
		return score;
	}
	@Override
	public String toString() {
		return String.format("[%s] %d, %d, %d", name, card1.getNum(), card2.getNum(), score);
	}
}


public class Q3 {

	public static void main(String args[]) throws Exception
	{
		SutdaDeck deck = new SutdaDeck();
		deck.shuffle();
		Player[] pArr = {
				new Player("타짜", deck.pick(), deck.pick()), 
				new Player("고수", deck.pick(), deck.pick()), 
				new Player("물주", deck.pick(), deck.pick()), 
				new Player("중수", deck.pick(), deck.pick()), 
				new Player("하수", deck.pick(), deck.pick())
		};
		System.out.println(Arrays.toString(pArr));
		Arrays.sort(pArr, (p1,p2) -> p2.getScore() - p1.getScore());
		System.out.println(Arrays.toString(pArr));
	}
}
