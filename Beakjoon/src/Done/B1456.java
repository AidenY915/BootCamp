package Done;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1456 {
	private static boolean[] sOE;
	final static int SIEVE_SIZE = 10000000;
	
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		br.close();
		long a = Long.parseLong(input[0]);
		long b = Long.parseLong(input[1]);
		SieveOfEratosthenes(SIEVE_SIZE);
		List<Integer> primeList = new ArrayList<>(SIEVE_SIZE);
		for(int i = 2 ; i <= SIEVE_SIZE; i++) {
			if(sOE[i]) {
				primeList.add(i);
			}
		}
		int primeListSize = primeList.size();
		int sum = 0;
		for(int i = 0 ; i < primeListSize; i++) {
			long tmp = primeList.get(i);
			if(tmp > b) break;
			int count = 0;
			long almostPrime = (long)tmp*tmp;
			while(almostPrime <= b) {
				if(almostPrime >= a)
					count++;
				if(almostPrime>9_223_372_036_854_775_807L/tmp)		//항상 overflow를 고려할 것
					break;
				almostPrime*=tmp;
			}
			sum += count;
		}
		System.out.println(sum);
	}

}
