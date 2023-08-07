import java.util.Scanner;
import java.util.Arrays;

class PrintDigit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();		
		int digit = 0;
		int tmp = n;
		while(tmp > 0) {
			digit++;
			tmp /= 10;
		}
		System.out.println(n+"는 " + digit + "자리 숫자 입니다.");
		System.out.println(String.valueOf(n).length()+"자리 by String");
		int[] arr = new int[digit];
		tmp = n;
		for(int i = arr.length - 1 ; i >= 0; i-- , tmp/=10) {
			arr[i] = tmp%10;
		}
	
		System.out.println(Arrays.toString(arr));	

	
	}

}