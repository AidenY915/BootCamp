package Done;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11047 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int cnt = 0;
		int coin[] = new int[n];
		for(int i = 0; i < n; i++)
			coin[i] = Integer.parseInt(br.readLine());
		int i = n - 1;
		while(k>0) {
			cnt += k / coin[i];
			k %= coin[i];
			i--;
		}
		System.out.println(cnt);
	}
}
