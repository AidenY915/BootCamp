import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2343 {

	public static int binarySearchIdx(int[] partSum,int start, int end,int least) {
		while(start <= end) {
			int mid = (start+end)/2;
			if(partSum[mid] == least) return mid;
			else if(partSum[mid] < least) start = mid + 1;
			else if(partSum[mid] > least) end = mid - 1;
		}
		return start;
	}
	
	public static int findLeast(int[] partSum, int m) {
		int least = partSum[partSum.length-1]/m + (partSum[partSum.length-1]%m==0 ? 0 : 1);
		int[] bulkhead = new int[m - 1];
		bulkhead[0] = binarySearchIdx(partSum, 0, partSum.length-1, least);
		for(int i = 1; i < m - 1; i++) {
			bulkhead[i] = binarySearchIdx(partSum, bulkhead[i-1]+1, partSum.length-1, least+partSum[bulkhead[i-1]]);
		}
		int[] buketSize = new int[m];
		buketSize[0] = partSum[bulkhead[0]];
		for(int i = 1; i < m - 1 ;i++) {
			buketSize[i] = partSum[bulkhead[i]] - partSum[bulkhead[i-1]];
		}
		buketSize[m - 1] = partSum[m-1] - partSum[bulkhead[m-2]];
		int rslt = 0;
		for(int i = 0; i < m; i++) {
			rslt = rslt >= buketSize[i] ? rslt : buketSize[i];
		}
		return rslt;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int[] timeArr = new int[n];
		int[] partSum = new int[n];
		for(int i = 0; i < n; i++) 
			timeArr[i] = Integer.parseInt(input[i]);
		partSum[0] = timeArr[0];
		for(int i = 1; i < n; i++) 
			partSum[i] = partSum[i - 1] + timeArr[i];
		System.out.println(findLeast(partSum, m));
		
	}
}
