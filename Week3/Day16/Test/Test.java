import java.util.Scanner;
import java.util.Arrays;

class Methods {
	public static void print2dArray(int[][] arr) {
		StringBuilder sb = new StringBuilder(5*5);
		for(int[] arr1d : arr) {
			for(int n : arr1d)
				sb.append(n+" ");	
			sb.append('\n');	
		}
		System.out.println(sb);	
	}
	public static void print2dArray(char[][] arr) {
		StringBuilder sb = new StringBuilder(5*5);
		for(char[] arr1d : arr) {
			for(char ch : arr1d)
				sb.append(ch);	
			sb.append('\n');	
		}
		System.out.println(sb);	
	}
	public static void shuffle(char[] chars) {
		for(int i = chars.length - 1; i > 0 ; i--) {
			int j = (int)(Math.random() * (i + 1));
			char tmp = chars[i];
			chars[i] = chars[j];
			chars[j] = tmp;
		}
	}
}

class Q1 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int sum = 0;
		for(int e : arr)
			sum+=e;
		System.out.println(sum);
	}
}

class Q2 {
	public static void main(String[] args) {
		int[] coinNum = {5,5,5,5};
		int[] coin = {500,100,50,10};
		int money = Integer.parseInt(args[0]);
		if(3300 < money) {
			System.out.println("거스름 돈이 부족합니다.");
			return;
		}
		System.out.println(Arrays.toString(coin) + "\n"+ Arrays.toString(coinNum));
		for(int i = 0; i < coin.length; i++) {
			int numOfUsedCoin = money / coin[i];
			numOfUsedCoin = numOfUsedCoin > coinNum[i] ? coinNum[i] :  numOfUsedCoin;
			money -= numOfUsedCoin*coin[i];
			coinNum[i] -= numOfUsedCoin;
		}
		System.out.println(Arrays.toString(coinNum));
	}
}

class Q3 {
 
	public static void main(String[] args) {
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
		int[] cnt = new int[4];
		for(int e : answer)
			cnt[e-1]++;
		for(int e : cnt) {
			System.out.print(e);
			for(int i = 0; i < e; i++)
				System.out.print("*");
			System.out.println();
		}
	}
}

class Q4 {
	static char[][] rotateClockWise(char[][] arr) {
		char[][] newArr = new char[arr[0].length][arr.length];

		for(int i =0; i < arr.length; i++){
			for(int j =0; j < arr[0].length; j++){
				newArr[j][newArr[0].length - 1 - i] = arr[i][j];
			}
		}
		return newArr;
	}
	
	public static void main(String[] args) {
		char[][] star = {
				{'*','*',' ',' ',' '},
				{'*','*',' ',' ',' '},
				{'*','*','*','*','*'},
				{'*','*','*','*','*'}
			};

		Methods.print2dArray(star);
		char[][] newStar = rotateClockWise(star);
		Methods.print2dArray(newStar);		
	}
}

class Q5 {
	static String abcToCode = "` ~ ! @ # $ % ^ & * ( ) - _ + = | [ ] { } ; : , . /";
	static String numToCode = "q w e r t y u i o p";

	static String encode(String str) {
		int len = str.length();
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if(ch >= 'a' && ch <= 'z') sb.append(abcToCode.charAt(ch - 'a'));
			else if(ch >= '0' && ch <= '9') sb.append(numToCode.charAt(ch - '0'));
		}

		return sb.toString();
	}
	public static void main(String[] args){
		abcToCode = abcToCode.replaceAll(" ", "");
		numToCode = numToCode.replaceAll(" ", "");
		Scanner sc = new Scanner(System.in);
		System.out.println(encode(sc.nextLine()));		
		sc.close();
	}
}

class Q6 {
	public static void main(String[] args) {
		int[][] score = {
			{100, 100, 100}
			, {20, 20, 20}
			, {30, 30, 30}
			, {40, 40, 40}
			, {50, 50, 50}
		};
		int[][] newScore = new int[score.length + 1][score[0].length + 1];
		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < score[i].length; j++) {
				newScore[i][j] = score[i][j];
				newScore[i][newScore[i].length - 1] += newScore[i][j];
				newScore[newScore.length - 1][j] += newScore[i][j];
				newScore[newScore.length - 1][newScore[i].length - 1] += newScore[i][j];
			}
		}
		Methods.print2dArray(newScore);	
	}

}	


class Q7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in, "euc-kr");
		System.out.print("입력할 단어 개수 : ");
		int n = sc.nextInt();
		String[][] words = new String[n][2];
		for(int i = 0; i < n ; i++)
		{
			System.out.print("영단어 : ");
			words[i][0] = sc.next();
			System.out.print("뜻 : ");
			words[i][1] = sc.next();
		}
		for(int i = 0; i < n ; i++) System.out.println(Arrays.toString(words[i]));
		sc.close();
	}

}


class Q8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단어 입력 : ");
		char[] chars = sc.nextLine().toCharArray();
		Methods.shuffle(chars);
		System.out.println(String.valueOf(chars));
		sc.close();
	}
}

class Q9 {
	static boolean isNumber(String str) {
		int len = str.length();
		if(str == null || len == 0) return false;
		for(int i = 0; i < len ; i++) {
			if(str.charAt(i) < '0' || str.charAt(i) > '9')
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(isNumber(sc.nextLine()));
		sc.close();
	}

}

class Q10{
	public static Integer hexToInt(String str) {
		int len = str.length();
		int n = 0;
		for(int i = 0; i < len; i++) {
			n*=16;
			char ch = str.charAt(i);
			if(ch >= 'A' && ch <= 'F' ) n+=ch-'A'+10;
			else if(ch >= 'a' && ch <= 'f' ) n+=ch-'a'+10;
			else if(ch >= '0' && ch <= '9' ) n+=ch-'0';
			else return null;
		}
		return n;
	}
	public static String intToBin(int n) {
		StringBuilder sb = new StringBuilder();
		if(n == 0) return "0";		//while문을 통과하지 못함.
		while(n>0){			//1의 자리부터 나옴
			sb.append(n%2);
			n/=2;
		}
		sb.reverse();
		return sb.toString();
	}
	public static String hexToBinary(String str) {
		Integer integer = hexToInt(str);
		if(integer == null) return null;
		return intToBin(integer);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String bin = hexToBinary(sc.nextLine());
		sc.close();
		if(bin == null) System.out.println("16진수 아님.");
		else System.out.println(bin);
	}

}

class SutdaCard {	//Q11
	private int num = 1;
	private boolean isKwang= true;
	SutdaCard(){};
	SutdaCard(int _num, boolean _isKwang) {num = _num; isKwang = _isKwang;}
	public String info() {return num+(isKwang ? "K" : "");}
}

class Q12{
	public static void main(String args[]) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		System.out.println(card1.info());
		System.out.println(card2.info());
	}
}

//13 기본값 - > 명시적 초기화 -> 인스턴스 초기화 블럭 -> 생성자

/*
14
class MemberCall {
	int iv = 10;
	static int cv = 20;
	int iv2 = cv;
	static int cv2 = iv; // A 라인	static 변수가 생성되지 않은 인스턴스 변수의 값을 이용해 초기화
	static void staticMethod1() {
		System.out.println(cv);
		System.out.println(iv); // B 라인 static 메소드가 인스턴스 변수에 접근
	}
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv); // C 라인
	}
	static void staticMethod2() {
		staticMethod1();
		instanceMethod1(); // D 라인		static 메소드가 인스턴스 메소드에 접근
	}
	void instanceMethod2() {
		staticMethod1(); // E 라인
		instanceMethod1();
	}
}
*/