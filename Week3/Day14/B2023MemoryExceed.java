import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Main {
	static boolean[] sieveOfEratosthenes(int n) {
		boolean[] sieve = new boolean[n+1];
		for(int i = 2; i <= n/2 ; i++) {
			if(sieve[i])
				continue;
			for(int j = i * 2; j <= n; j += i)
				sieve[j] = true;			
		}
		return sieve;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		int limit = (int)Math.pow(10,n);
		int base = limit / 10;
		StringBuilder sb = new StringBuilder(n*limit);
		
		boolean[] sieve = sieveOfEratosthenes(limit - 1);
		for(int i = base; i < limit ; i++) {
			boolean isNotPrime = false;
			for(int cut = base; cut >= 1 ; cut /= 10) {
				int tmp = i/cut;
				if(sieve[tmp]) {
					isNotPrime=true;
					break;
				}
			}
			if(isNotPrime) continue;
			sb.append(i+"\n");
		}
		System.out.print(sb);
		
	}
}