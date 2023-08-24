package Done;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1744 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n<=0) return;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		br.close();
		Arrays.sort(arr);
		int sum = 0;
		int i;
		for(i = 0; i < n-1 && arr[i] <= 0; i++) {
			if(arr[i+1] <= 0) {
				sum += arr[i] * arr[i+1];
				i++;
			}
			else sum+=arr[i];
		}
		while(i<n && arr[i] == 1)
			sum+=arr[i++];
		int j;
		for(j = n-1; j >= i+1; j-=2) {
			sum += arr[j] * arr[j-1];
		}
		if(j == i)
			sum+=arr[i];
		System.out.println(sum);
	}
}
