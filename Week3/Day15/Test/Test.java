import java.util.Arrays;
import java.util.Scanner;
class Methods {
	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void fisherYatesShuffle(int[] arr) {
		for(int i = arr.length - 1 ; i > 0 ; i--) {
			int j = (int)(Math.random() * (i + 1));
			swap(arr, i, j);
		}
	}
}

public class Test {
	public static void main(String[] args) {
		//1
		int num = 10;
		String str = String.valueOf(num);
		System.out.println(str);
		//2
		String numStr = "20";
		System.out.println(Integer.parseInt(numStr));
		//3
		str = "0123456789";
		str = str.substring(3);
		System.out.println(str);
		//4
		str = "0123456789";
		str = str.substring(4,7);		
		System.out.println(str);
		//5
		double numD = 3.5;
		System.out.println(Math.round(numD));
		System.out.println(Math.floor(numD));
		System.out.println(Math.ceil(numD));
		//8
		int[] nums = {5,4,1,3,2};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		//9
		int[] src = Arrays.copyOf(nums,nums.length);
		int[] dest = new int[10];
		System.arraycopy(src, 0, dest, 3, src.length);
		System.out.println(Arrays.toString(dest));
		//10
		System.out.println(Arrays.toString(args));
		//11
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++) arr[i] = i;
		Methods.fisherYatesShuffle(arr);
		System.out.println(Arrays.toString(arr));
	}

}

class BaseballGame {
	final static int STRIKE = 0, BALL = 1;
	private static BaseballGame bg;
	private String answer; 
	private int level;
	private BaseballGame(int _level) {
		level = _level;
		int[] arr = null;
		while(arr == null || arr[0] == 0) {
			arr = new int[]{0,1,2,3,4,5,6,7,8,9};
			Methods.fisherYatesShuffle(arr);
		}
		StringBuilder sb = new StringBuilder(level);
		for(int i = 0 ; i < level ; i++)
			sb.append(arr[i]);
		answer = sb.toString();
	}
	public static BaseballGame getBaseballGame(int level) {
		bg = bg == null ?  (new BaseballGame(level)) : bg;
		return bg;
	}

	public void submitUserAnswer(String submit, int[] hint) {
		hint[STRIKE] = 0;
		hint[BALL] = 0;
		for(int i = 0; i < answer.length(); i++) {
			for(int j = 0; j < answer.length(); j++) {
				if(answer.charAt(i) == submit.charAt(j)) {
					if(i == j) hint[STRIKE]++;
					else hint[BALL]++;
				}
			}
		}
	}
	public boolean checkSubmit(String submit) {
		if(submit.length() != level || submit.charAt(0)==0)
			return false;
		boolean[] checkRepeated = new boolean[10];
		for(int i = 0 ; i < submit.length(); i++) {
			int tmp = submit.charAt(i) - '0';
			if(checkRepeated[tmp]) return false;
			checkRepeated[tmp] = true;
		}
		return true;
	}

}

class BaseballUi {
	final static int STRIKE = 0, BALL = 1;
	private static BaseballGame bg;
	private static Scanner sc = new Scanner(System.in);
	public static void start() {
		String submit = null;
		int[] hint = new int[2];
		System.out.print("레벨 입력 : ");
		int level = sc.nextInt();
		sc.nextLine();
		int limit = (int)Math.pow(10,level) - 1;
		int base = (int)Math.pow(10,level - 1);
		String rangeErrorMessage = base + "이상 " + limit + "이하의 자리수 간 중복이 없는 값을 입력하시오.";
		bg = BaseballGame.getBaseballGame(level);
		while(true) {
			System.out.print("답 입력 : ");
			submit = sc.nextLine();
			if(!bg.checkSubmit(submit)) {
				System.out.println(rangeErrorMessage);	 
				continue;
			}
			bg.submitUserAnswer(submit, hint);
			if(hint[STRIKE] == level) {
				System.out.println("홈런\n프로그램 종료.");
				return;
			}
			System.out.printf("스트라이크 : %d, 볼 : %d\n", hint[STRIKE], hint[BALL]);
			



		}

	}
}

class BaseballMain {
	public static void main(String[] args) {
		BaseballUi.start();
	}
}