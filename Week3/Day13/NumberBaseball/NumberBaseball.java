import java.util.Scanner;


class NumberBaseballGame {
	private String answer;
	private static NumberBaseballGame nbg = new NumberBaseballGame();
	private int[] hint = new int[2];
	private static int DIGIT = 3;
	private final static int STRIKE = 0, BALL = 1;
	private NumberBaseballGame(){}
	public static NumberBaseballGame getNumberBaseballGame() {	
		return nbg;
	}
	public int setDigit(int n){
		DIGIT = n;
		return DIGIT;
	}	
	public void makeRandomAnswer(){				//컴퓨터 답 설정
		int n = 0;
		boolean[] check = new boolean[10];
		for(int i = 0; i< 10 ; i++)
			check[i] = false;
		for(int i = 0; i < DIGIT; i++) {
			n *= 10;
			int tmp = (int)(Math.random()*10);
			if(i == 0 && tmp == 0 || check[tmp]) {	
				i--;
				continue;
			}
			check[tmp] = true;
			n+=tmp;
		}
		answer = String.valueOf(n);
		System.out.println(answer);
	}

	public int[] compareNum(String submit) {			//사용자가 제출한 답과 컴퓨터 답 비교해서 힌트 반환
		hint[STRIKE] = 0;
		hint[BALL] = 0;
		for(int i = 0; i < DIGIT ;i++) {
			for(int j = 0; j < DIGIT ;j++) {
				if(answer.charAt(i) == submit.charAt(j)) {
					if(i == j) {		
						hint[STRIKE]++;
					}
					else hint[BALL]++;
				}
			}
		}		
		return hint;
	}

	public static boolean isRepeated(String submit) {		//들어온 수가 중복이 있는지
		boolean[] check = new boolean[10];
		for(int i = 0; i < 10; i++)
			check[i] = false;
		for(int i = 0; i < DIGIT; i++) {
			int tmp = submit.charAt(i) - '0';
			if(check[tmp])
				return true;
			check[tmp] = true;
		}
		return false;
	}

}

class NumberBaseballGameUi {
	
	private static Scanner sc = new Scanner(System.in);
	private final static int STRIKE = 0, BALL = 1;
	private static int DIGIT;
	public static void execute() {							//게임 시작
		int[] hint = null;
		NumberBaseballGame nbg = NumberBaseballGame.getNumberBaseballGame();
		System.out.println("자릿수를 입력하세요.");
		DIGIT  = nbg.setDigit(sc.nextInt());
		nbg.makeRandomAnswer();
		int limit = (int)Math.pow(10,DIGIT) - 1;
		int base = (int)Math.pow(10,DIGIT) / 10;
		while(true) {
			System.out.println("자 공격하세요.");
			int n = sc.nextInt();	
			String submit = String.valueOf(n);
			if(n < base || n > limit || NumberBaseballGame.isRepeated(submit)) {
				System.out.printf("숫자는 %d이상 %d이하의 겹치지 않는 숫자여야 합니다.\n",base, limit );
				continue;
			} 
			hint = nbg.compareNum(submit);
			if(hint[STRIKE] == DIGIT) {
				System.out.println("홈런\n게임을 종료합니다.");
				return;
			}
			System.out.printf("%d 스트라이크 %d 볼\n", hint[STRIKE], hint[BALL]);
		}

	}

}

public class NumberBaseball {
	public static void main(String[] args){
		NumberBaseballGameUi.execute();
	}

}