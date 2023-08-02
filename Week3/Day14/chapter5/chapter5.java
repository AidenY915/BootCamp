/*
5-1
d 명시적 초기화 시 크기 설정 불가능

5-2 2

5-3
*/

import java.util.Scanner;


class Q3
{
	public static void main(String[] args)
	{
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		for(int e : arr) sum += e;
		System.out.println("sum="+sum);
	}
}

class Q4
{
	public static void main(String[] args)
	{
		int[][] arr = {
			{ 5, 5, 5, 5, 5},
			{10,10,10,10,10},
			{20,20,20,20,20},
			{30,30,30,30,30}
		};
		int total = 0;
		float average = 0;
		int n = 0;
		for(int[] arr1D : arr)  {
			for(int e : arr1D)
				total += e;
			n+=arr1D.length;
		}
		average = total / (float)n; 
		System.out.println("total="+total);
		System.out.println("average="+average);
	} // end of main
} // end of class

class Q5 {
	public static void main(String[] args) {
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		// ballArr . 배열 의 임의의 요소를 골라서 위치를 바꾼다
		for(int i=0; i< ballArr.length;i++) {
			int j = (int)(Math.random() * ballArr.length);
			int tmp = 0;
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;
		}
		// ballArr 3 ball3 . 배열 의 앞에서 개의 수를 배열 로 복사한다
		System.arraycopy(ballArr, 0, ball3, 0, 3);
		for(int i=0;i<ball3.length;i++) {
			System.out.print(ball3[i]);
		}
	} // end of main
} // end of class

class Q6 {
	public static void main(String args[]) {
		// . 큰 금액의 동전을 우선적으로 거슬러 줘야한다
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		System.out.println("money="+money);
		for(int i=0;i<coinUnit.length;i++) {
			int cnt = money / coinUnit[i];
			money %= coinUnit[i];
			System.out.println(coinUnit[i] + "원: " + cnt);
		}
	} // main
}

class Q7
{
	public static void main(String args[]) {
		if(args.length!=1) {
			System.out.println("USAGE: java Exercise5_7 3120");
			System.exit(0);
		}
		// . . 문자열을 숫자로 변환한다 입력한 값이 숫자가 아닐 경우 예외가 발생한다
		int money = Integer.parseInt(args[0]);
		System.out.println("money="+money);
		int[] coinUnit = {500, 100, 50, 10 }; // 동전의 단위
		int[] coin = {5, 5, 5, 5}; // 단위별 동전의 개수
		for(int i=0;i<coinUnit.length;i++) {
			int coinNum = 0;
			coinNum = money / coinUnit[i];
			if(coinNum > coin[i])
				coinNum = coin[i];
			money -= coinUnit[i] * coinNum;
			coin[i] -= coinNum;
			/* (1) . 아래의 로직에 맞게 코드를 작성하시오
			1. (money) (coinNum) . 금액 을 동전단위로 나눠서 필요한 동전의 개수 를 구한다
			2. coin coinNum . 배열 에서 만큼의 동전을 뺀다
			( coin .) 만일 충분한 동전이 없다면 배열 에 있는 만큼만 뺀다
			3. (coinNum) . 금액에서 동전의 개수 와 동전단위를 곱한 값을 뺀다
			*/
			System.out.println(coinUnit[i]+"원 : "+coinNum);
		}
		if(money > 0) {
			System.out.println("거스름돈이 부족합니다."); 
			System.exit(0); // . 프로그램을 종료한다
		}
		System.out.println("=남은 동전의 개수="); 
		for(int i=0;i<coinUnit.length;i++) {
			System.out.println(coinUnit[i]+"원 :"+coin[i]); 
		}
	} // main
}

class Q8 {
	public static void main(String[] args){ 
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
		int[] counter = new int[4];
		for(int i=0; i < answer.length;i++) {
			counter[answer[i] -1]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < counter.length;i++) {
			sb.delete(0, sb.length());
			sb.append(counter[i]);
			for(int j = 0 ; j < counter[i] ; j++)
				sb.append("*");
			System.out.println(sb);
		}
	} // end of main

}

class Q9 {					//시계방향 회전 고려
	public static void main(String[] args) {
		char[][] star = {
			{'*','*',' ',' ',' '},
			{'*','*',' ',' ',' '},
			{'*','*','*','*','*'},
			{'*','*','*','*','*'}
		};
		char[][] result = new char[star[0].length][star.length];
		for(int i=0; i < star.length;i++) {
			for(int j=0; j < star[i].length;j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0; i < star.length;i++) {
			for(int j=0; j < star[i].length;j++) {
						//대각선 스왑 + 좌우 -> 시계방향
				result[j][result[i].length- 1  - i] = star[i][j];
			}
			
			
		}
		for(int i=0; i < result.length;i++) {
			for(int j=0; j < result[i].length;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	} // end of main
} // end of class

class Q10 {
	public static void main(String[] args) {
		char[] abcCode =
			{ '`','~','!','@','#','$','%','^','&','*',
			'(',')','-','_','+','=','|','[',']','{',
			'}',';',':',',','.','/'};

			// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		String src = "abc123";
		String result = "";
		StringBuilder sb = new StringBuilder();
		// src charAt() result 문자열 의 문자를 으로 하나씩 읽어서 변환 후 에 저장
		for(int i=0; i < src.length();i++) {
			char ch = src.charAt(i);
			sb.append(ch >= 'a' && ch <='z' ? abcCode[ch - 'a'] : numCode[ch - '0']);
		}
		result = sb.toString();
		System.out.println("src:"+src);
		System.out.println("result:"+result);
	} // end of main
}

class Q11 {
	public static void main(String[] args)
	{
		int[][] score = {
			{100, 100, 100}
			, {20, 20, 20}
			, {30, 30, 30}
			, {40, 40, 40}
			, {50, 50, 50}
		};
		int[][] result = new int[score.length+1][score[0].length+1];
		for(int i=0; i < score.length;i++) {
			int rowSum = 0;
			for(int j=0; j < score[i].length;j++) {
				result[i][j]=score[i][j];
				result[i][result[i].length-1] += result[i][j];
				result[result.length - 1][j] += result[i][j];
				result[result.length - 1][result[i].length-1] += result[i][j];
			}
			
		}
		
		
		for(int i=0; i < result.length;i++) {
			for(int j=0; j < result[i].length;j++) {
				System.out.printf("%4d",result[i][j]);
			}
			System.out.println();
		}
	} // main
}

class Q13 {
	static void swap(char[] arr , int i , int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	static void shuffle(char[] question) {
		for(int i = 0 ; i < question.length; i++) {
			int j = (int)(Math.random() * (question.length - i));
			swap(question, i, j);
		}
	}
	public static void main(String args[]) {
		String[] words = { "television", "computer", "mouse", "phone" };
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<words.length;i++) {
			char[] question = words[i].toCharArray(); // String char[] 을 로 변환
			
			shuffle(question);

			System.out.printf("Q%d. %s 의 정답을 입력하세요.>", i+1, new String(question));
				
			String answer = scanner.nextLine();	
			// trim() answer , equals word[i] 으로 의 좌우 공백을 제거한 후 로 와 비교
			if(words[i].equals(answer.trim()))
				System.out.printf("맞았습니다.%n%n"); 
			else
				System.out.printf("틀렸습니다.%n%n"); 
			}
	} // main의
}