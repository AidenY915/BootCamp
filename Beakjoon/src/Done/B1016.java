package Done;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class B1016 {

	private static boolean[] sOE;
	final static int SIEVE_SIZE = 1_000_000;

	private static void sieveOfEratosthenes(int n) {
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
	
	private static boolean[] isNSquare;
	private static void fillIsNSquare(long start, long end, List<Integer> primeList) {
		int size = (int)(end-start)+1;
		isNSquare = new boolean[size];
		Iterator<Integer> itr = primeList.iterator();
		while(itr.hasNext()) {
			long next = itr.next();
			next*=next;
			long iStart = start + (next-(start%next))%next;
			for(long i = iStart ; i <= end ; i+=next) {
				isNSquare[(int)(i-start)] = true;
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		sieveOfEratosthenes(SIEVE_SIZE);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		br.close();
		long min = Long.parseLong(input[0]);
		long max = Long.parseLong(input[1]);
		int limit = (int)Math.sqrt(max);

		List<Integer> primeList = new LinkedList<Integer>();
		for(int i = 2; i <= limit; i++) {
			if(sOE[i]) {
				primeList.add(i);
			}
		}
		fillIsNSquare(min,max,primeList);
		int cnt=0;
		int size = (int)(max - min + 1);
		for(int i = 0; i < size; i++) {
			if(!isNSquare[i])
			{
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
