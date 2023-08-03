import java.util.Scanner;
class P1{
	public static void main(String[] args) {
		if(args == null || args.length == 0) 
		{
			System.out.println("usage: java P1 NUM1 OP NUM2");
			return;
		}
		char operator = args[1].charAt(0);
		int operand1 = Integer.parseInt(args[0]);
		int operand2 = Integer.parseInt(args[2]);
		int rslt = 0;
		switch(operator) {
			case '+' : rslt = operand1 + operand2; break;
			case '-' : rslt = operand1 - operand2; break;
			case 'x' : rslt = operand1 * operand2; break;		//왜 곱하기가 안될까 * 다른 의미로 받아들이는데
			case '/' : rslt = operand1 / operand2; break;
		}
		System.out.println(rslt);
	}

}

class P2{
	private static int getSum(int[] arr) {
		int sum = 0;
		for(int i = 0 ; i < arr.length; i++)
			sum+=arr[i];
		return sum;
	}
	private static double getAverage(int[] arr) {
		
		return (double)getSum(arr)/arr.length;
	}
	public static void main(String[] args) {
		int[][] scores = {
				{100,100,100},
				{20,20,20},
				{30,30,30},
				{40,40,40},
				{50,50,50}
			};
		System.out.println("번호 국어 영어 수학 총점 평균");
		System.out.println("======================");
		for(int i = 0 ; i<scores.length; i++) {
			String str = " 1";
			for(int score : scores[i])
				System.out.printf("%3d ",score);
			System.out.printf("%3d %5.1f\n", getSum(scores[i]), getAverage(scores[i]));
		}
		System.out.println("======================");		
		System.out.print("총점: ");
		for(int i = 0; i<scores[0].length ; i++){
			int sum = 0;
			for(int j = 0 ; j < scores.length; j++)
				sum += scores[j][i];
			System.out.printf("%3d ", sum);
		}
	}


}

class P3 {
	private static void printBoard(byte[][] board) {
		StringBuilder sb = new StringBuilder(20*20);
		sb.append(" ");
		for(int i = 1 ; i <= 9; i++)
			sb.append(i);
		sb.append("\n");
		for(int i = 0 ; i < 9; i++){
			sb.append(i+1);
			for(int j = 0 ; j < 9; j++){
				char ch = board[i][j] == 1 ? 'O' : (board[i][j] == 0 ? 'X' : ' ');
				sb.append(ch);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte[][] shipBoard = {
		  //  1  2  3  4  5  6  7  8  9
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 1
			{ 1, 1, 1, 1, 0, 0, 1, 0, 0 }, // 2
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 3
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 4
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5
			{ 1, 1, 0, 1, 0, 0, 0, 0, 0 }, // 6
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 7
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 8
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0 }, // 9
		};
		byte[][] playerBoard = new byte[9][9];
		for(int i = 0; i < playerBoard.length ; i++)
			for(int j = 0; j < playerBoard[i].length ; j++)
				playerBoard[i][j] = -1;
		while(true) {
			System.out.print("좌표를 입력하세요. (종료는 00)");
			String point = sc.next();
			if(point.equals("00")) return;
			if(point.length() != 2 || point.charAt(0) <= '0' || point.charAt(0) > '9' || point.charAt(1) <= '0' || point.charAt(1) > '9') {
				System.out.println("잘못된 입력. 다시 입력하세요.");
				continue;
			}
			int y = point.charAt(0) - '1';
			int x = point.charAt(1) - '1';
			playerBoard[y][x] = shipBoard[y][x];
			printBoard(playerBoard);
		}
	}

}

class P4 {
	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		for(int i=0; i < 5; i++) {
			for(int j=0; j < 5; j++) {
				arr[i][j] = i*5+j;
			}
		}
		
		for(int i = 4; i >= 0; i--) {
			for(int j =4 ; j >= 0; j--) {
				int y = (int)(Math.random() * (i + 1));
				int x = (int)(Math.random() * (j + 1));
				int tmp = arr[i][j];
				arr[i][j] = arr[y][x];
				arr[y][x] = tmp;
			}
		}
		for(int i=0; i < 5; i++) {
			for(int j=0; j < 5; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}


}