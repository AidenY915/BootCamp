package Q2_4;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q2_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = (int)(Math.random()*100) + 1;
		System.out.println(answer);
		int user = -1;
		while(answer != user)
		try {
			user = sc.nextInt();		//Buffer에 있는 것을 비우기 전에 Exception 발생.
										//next는 일단 Buffer 있는 것을 차례로 출력 없을 경우 읽는 것
		} catch (InputMismatchException e) {
			sc.nextLine();  		//Buffer 비우기
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
