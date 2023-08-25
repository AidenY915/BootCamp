import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B1456 {
	private static boolean[] sOE;
	final static int SIEVE_SIZE = 10000000;
	
	private static void SieveOfEratosthenes(int n) {
		sOE = new boolean[n+1];
		for(int i = 1; i <= n ;i++)
			sOE[i] = true;	
		for(int i = 2; i <= n ;i++) {
			if(!sOE[i]) continue;
			for(int j = i*2; j <= n; j+=i) {
				sOE[j] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		br.close();
		long a = Long.parseLong(input[0]);
		long b = Long.parseLong(input[1]);
		SieveOfEratosthenes(SIEVE_SIZE);
		List<Integer> primeList = new ArrayList<>(SIEVE_SIZE);
		for(int i = 1 ; i <= SIEVE_SIZE; i++) {
			if(sOE[i]) {
				primeList.add(i);
			}
		}
		int primeListSize = primeList.size();
		List<Long> almostPrimeList = new ArrayList<>(primeListSize);
		for(int i = 0 ; i < primeListSize; i++) {
			almostPrimeList.add((long)Math.pow(primeList.get(i),2));
		}
		int almostPrimeListSize = almostPrimeList.size();
		int start = 0;
		for(;start < almostPrimeListSize; start++) {
			if(almostPrimeList.get(start) >= a) break;
		}
		int end = almostPrimeListSize-1;
		for(;end >= start; end--) {
			if(almostPrimeList.get(end) <= b) break;
		}
		System.out.println(end - start + 1);
	}

}
