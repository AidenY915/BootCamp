/*
Q1
 static { }
 BlockTest bt = new BlockTest();
 { }
 생성자
 BlockTest bt2 = new BlockTest();
 { }
 생성자
*/


/*
Q2
로딩 시
cv = 1; 선언 시 명시적 초기화
cv = 2; 스태틱 초기화 블럭

객체 생성 시
iv = 1;	명시적 초기화
iv = 2;	초기화 블럭
iv =3;	생성자
*/

import java.util.Scanner;
import java.util.Arrays;

class Q3 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int min = sc.nextInt();
		sc.close(); 		//입출력 시 꼭 close();
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++)
			arr[i] = (int)(Math.random()*(max-min + 1)) + min;
		System.out.println(Arrays.toString(arr));
	}
}

class Q4 { 
	public static void main(String[] args) {
		int max = 45;
		int min = 1;
		int[] arr = new int[5];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*(max-min + 1)) + min;
			for(int j = 0 ; j < i ; j++) {
				if(arr[i] == arr[j]) {i--; break;}
			}
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

class Q5 {
	private static void swapInt(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;	
	}
		
	private static void shuffle(int[] deck) {
		for(int i = 0; i < deck.length - 1; i++) {
			 int picked = (int)(Math.random() * (deck.length - i)) + i;
			swapInt(deck, i, picked);
		}
	}
	
	private static int[] getNums(int[] deck, int n) {
		int[] arr = new int[n];
		System.arraycopy(deck, 0, arr, 0, n);
		return arr;
	}
	
	 public static void main(String[] args) {
		int[] deck = new int[45];
		for(int i = 0 ; i < deck.length; i++)
			deck[i] = i + 1;
		final int nOfNums = 6;
		int[][] lottos = new int[5][];
		for(int i = 0; i < lottos.length; i++) {
			shuffle(deck);
			lottos[i] = getNums(deck, nOfNums);
			Arrays.sort(lottos[i]);
		}
		for(int i = 0; i < lottos.length; i++) 
			System.out.println(Arrays.toString(lottos[i]));
	}
}
