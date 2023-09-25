package Done;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1748_1 {
	private static boolean isPrime(int n){
		for(int i = 2; i <= n/2; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	private static int nextPalindrome(int n){
		String str = String.valueOf(n);
		char[] chars = str.toCharArray();
		int len = chars.length;
		int digit1,digit2;
		if(len%2 == 0) {
			digit2=len/2;
			digit1=len/2-1;
		}
		else {
			digit2=len/2;
			digit1=len/2;
		}
		while(digit1 >=0 && chars[digit1]=='9') {
			chars[digit1] = '0';
			chars[digit2] = '0';
			digit1--;
			digit2++;
		}
		if(digit1==-1)
		{
			return (int)Math.pow(10, len)+1;
		}
		chars[digit1]++;
		if(digit1!=digit2)
			chars[digit2]++;
		return Integer.parseInt(String.valueOf(chars));
	}
	
	private static int findFirstPalindrome(int n) {
		String str = String.valueOf(n);
		char[] chars = str.toCharArray();
		int len = chars.length;
		int digit1,digit2;
		if(len%2 == 0) {
			digit2=len/2;
			digit1=len/2-1;
		}
		else {
			digit2=len/2;
			digit1=len/2;
		}
		while(digit1>=0){
			chars[digit2] = chars[digit1];
			digit1--;
			digit2++;
		}
		int rslt = Integer.parseInt(String.valueOf(chars));
		while(rslt < n) {
			rslt = nextPalindrome(rslt);
		}
		return rslt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		br.close();
		int i=findFirstPalindrome(n);		
		while(true) {
			if(isPrime(i)) {
				System.out.println(i);
				break;
			}
			i=nextPalindrome(i);
		}
	}
}
