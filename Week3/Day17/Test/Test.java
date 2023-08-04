import java.util.Scanner;

class Q1 {
	public static void main(String[] args) {
		String[] morse = {".-", "-...", "-.-.","-..", "."
				,"..-.", "--.", "....","..",".---"
				, "-.-", ".-..", "--", "-.", "---"
				, ".--.", "--.-",".-.","...","-"
				, "..-", "...-", ".--", "-..-","-.--"
				, "--.." };
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		StringBuilder sb =new StringBuilder(str.length());
		int len = str.length();
		for(int i = 0 ; i < len; i++) {
			int ch = str.charAt(i);
			ch = ch > 'Z' ? ch - 'a' : ch - 'A';
			sb.append(morse[ch]);
		}
		System.out.println(sb);
	}

}

class Q2 {
	public static void main(String[] args) {	//아무것도 작성하지 않는 경우 길이가 0인 2배열 할당(즉, 주소만 있음.)
		if(args.length != 3) {
			System.out.println("usage: java Q2 NUM1 OP NUM2");
			return;
		}
		int operand1 = Integer.parseInt(args[0]);
		int operand2 = Integer.parseInt(args[2]);
		String operator = args[1];
		int rslt = 0;
		switch(operator) {
			case "+" :	 rslt = operand1 + operand2; break;
			case "-" :	 rslt = operand1 - operand2; break;
			case "/" :	 rslt = operand1 / operand2; break;
			case "x" :	 rslt = operand1 * operand2; break;
		}
		System.out.println("결과:"+rslt);
	}

}

class Q3 {
	private static void markOnBoard(byte[][] board ,int i ,int j) {
		board[i][j] = board[i][j] == 0 ? (byte)'X' : (board[i][j] == 1 ? (byte)'O' : board[i][j]);
	}
	private static void showBoard(byte[][] board) {
		StringBuilder sb = new StringBuilder(board.length * board[0].length);
		sb.append(" 123456789\n");
		for(int i = 0 ; i < 9; i++) {
			sb.append(i+1);
			for(int j = 0 ; j < 9; j++) {
				char ch = (char)board[i][j];
				if(ch != 0 && ch != 1)
					sb.append(ch);
				else sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void main(String[] args) {
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
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("좌표를 입력하세요.(종료는 00)");
			String input = sc.next();
			if(input.length() != 2) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				continue;
			}
			
			int i = input.charAt(0)-'0'-1;
			int j = input.charAt(1)-'0'-1;
			if(input.equals("00")) break;
			if(i > 9 || i < 0 || j > 9 || j < 0) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				continue;
			}
			markOnBoard(shipBoard, i,j);
			showBoard(shipBoard);
		}
		sc.close();
	}

}

class Q4 {

	private static void shuffle2d(byte[][] arr) {
		for(int i = arr.length - 1 ; i >= 0  ; i--) {
			for(int j = arr[i].length - 1; j >= 0 ; j--) {
				int randomI = (int)(Math.random() * (i+1));
				int randomJ = (int)(Math.random() * (j+1));
				byte tmp = arr[randomI][randomJ];
				arr[randomI][randomJ] = arr[i][j];
				arr[i][j] = tmp; 
			}
		}
	}
	private static void print2d(byte[][] arr) {
		StringBuilder sb = new StringBuilder(arr.length * arr[0].length);
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void main(String[] args) {
		byte[][] arr = new byte[5][5];
		byte cnt = 0;
		for(byte i = 0; i < 5; i++) {
			for(byte j = 0; j < 5; j++) {
				arr[i][j] = cnt++;
			}
		}
		shuffle2d(arr);
		print2d(arr);
	}
}