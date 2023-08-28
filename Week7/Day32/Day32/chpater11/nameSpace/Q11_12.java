package nameSpace;
import java.util.*;
class Exercise11_12 {
	public static void main(String args[]) throws Exception {
		SutdaDeck deck = new SutdaDeck();
		deck.shuffle();
		Player p1 = new Player("타짜", deck.pick(), deck.pick()); 
		Player p2 = new Player("고수", deck.pick(), deck.pick()); 
		System.out.println(p1+" "+deck.getPoint(p1));
		System.out.println(p2+" "+deck.getPoint(p2));
	}
}
class SutdaDeck
{
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	int pos = 0; // 다음에 가져올 카드의 위치
	HashMap jokbo = new HashMap(); // HashMap 족보를 저장할
	SutdaDeck() {
		for(int i=0;i < cards.length;i++) {
			int num = i%10+1;
			boolean isKwang = i < 10 && (num==1 || num==3 || num==8);
			cards[i] = new SutdaCard(num,isKwang);
		}
		registerJokbo(); 
	}
	void registerJokbo() {
		jokbo.put("KK", 4000);
		jokbo.put("1010", 3100);
		jokbo.put("0909", 3090);
		jokbo.put("0808", 3080);
		jokbo.put("0707", 3070);
		jokbo.put("0606", 3060);
		jokbo.put("0505", 3050);
		jokbo.put("0404", 3040);
		jokbo.put("0303", 3030);
		jokbo.put("0202", 3020);
		jokbo.put("0101", 3010);
		
		
		jokbo.put("0102", 2060);
		jokbo.put("0104", 2050);
		jokbo.put("0109", 2040);
		jokbo.put("0110", 2030);
		jokbo.put("0410", 2020);
		jokbo.put("0406", 2010);
	}
	int getPoint(Player p) {
		if(p==null) return 0;
		SutdaCard c1 = p.c1;
		SutdaCard c2 = p.c2;
		Integer result = 0;
		
		int c1Num=Math.min(c1.num, c2.num);
		int c2Num=Math.max(c1.num, c2.num);
		
		String cards = (c1Num < 10 ? "0" : "")+c1Num + (c2Num < 10 ? "0" : "")+c2Num;
		cards = c1.isKwang && c2.isKwang ? "KK" : cards;
		
		result = (Integer)jokbo.get(cards);
		result = result == null ? (c1.num + c2.num) % 10 + 1000 : result;
		
		return result.intValue();
	}
	SutdaCard pick() throws Exception {
		SutdaCard c = null;
		if(0 <= pos && pos < CARD_NUM) {
			c = cards[pos];
			cards[pos++] = null;
		} else {
			throw new Exception("남아있는 카드가 없습니다."); 
		}
		return c;
	}
	void shuffle() {
		for(int x=0; x < CARD_NUM * 2; x++) {
			int i = (int)(Math.random() * CARD_NUM);
			int j = (int)(Math.random() * CARD_NUM);
			SutdaCard tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	}
} // SutdaDeck
class Player {
	String name;
	SutdaCard c1;
	SutdaCard c2;
	int point; // - 카드의 등급에 따른 점수 새로 추가
	Player(String name, SutdaCard c1, SutdaCard c2) {
		this.name = name ;
		this.c1 = c1 ;
		this.c2 = c2 ;
	}
	public String toString() {
		return "["+name+"]"+ c1.toString() +","+ c2.toString();
	}
} // class Player
class SutdaCard {
	int num;
	boolean isKwang;
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