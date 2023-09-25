package Done;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1748_2 {
	private static boolean[] sOE;
	final static int SIEVE_SIZE = 1003001;
	
	private static void SieveOfEratosthenes(int n) {
		sOE = new boolean[n+1];
		for(int i = 2; i <= n ;i++)
			sOE[i] = true;	
		for(int i = 2; i <= n ;i++) {
			if(!sOE[i]) continue;
			for(int j = i*2; j <= n; j+=i) {
				sOE[j] = false;
			}
		}
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
			chars[digit1]='0';
			chars[digit2]='0';
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
		SieveOfEratosthenes(SIEVE_SIZE);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		br.close();
		int i=findFirstPalindrome(n);		
		while(true) {
			if(sOE[i]) {
				System.out.println(i);
				break;
			}
			i=nextPalindrome(i);
		}
	}
}
