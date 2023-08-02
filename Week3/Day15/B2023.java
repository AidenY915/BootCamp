import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Main {
	static boolean[] sieveOfEratosthenes(int n) {		//소수면 false 아니면 true
		boolean[] sieve = new boolean[n+1];
		sieve[0] = true;
		sieve[1] = true;
		for(int i = 2; i <= n/2 ; i++) {
			if(sieve[i])
				continue;
			for(int j = i*i; j <= n; j += i)
				sieve[j] = true;			
		}
		return sieve;
		
	}
	static boolean isPrime(int n) {
		for(int i = 2 ; i <= n/2; i++)
		{
			if(n % i ==0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		final int SIEVE_LIMIT = 10000;
		StringBuilder sb = new StringBuilder(500000);
		boolean[] sieve = sieveOfEratosthenes(SIEVE_LIMIT);
		int limit = (int)Math.pow(10,n);
		int base = limit / 10;
		for(int i = base ; i< limit; i++) {
			boolean isP = true;
			for(int cut = base; cut >= 1 && isP ; cut/=10) {
				int tmp = i/cut;
				if(tmp % 2 == 0) {isP = false; break;}
				isP = tmp > SIEVE_LIMIT ? isPrime(tmp) : !sieve[tmp];
			}
			if(isP)
			sb.append(i+"\n");
		}	
		System.out.print(sb);
	}
}