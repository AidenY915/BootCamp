package Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2343 {
	private static byte checkBuket(int[] partSum, int buketSize, int m) {
		int prev = 0;
		int cnt = 0;
		for(int i = 0 ; i < partSum.length - 1; i++) {
			if(partSum[i+1]-prev > buketSize) {
				cnt++;
				prev = partSum[i];
			}
		}
		
		if(cnt > m - 1) return -1; //Bucket 작음.
		if(cnt < m - 1) return 1;	//Bucket 너무 큼
		return 0;
	}
	
	private static int findLeast(int[] partSum, int m) {
		int start = partSum[partSum.length - 1] / m;
		int end = partSum[partSum.length - 1];
		int mid = start;
		byte checkRslt = 0;
		while(start <= end) {
			mid = (start+end)/2;
			checkRslt = checkBuket(partSum, mid, m);
			if(checkRslt == 0)  break;
			else if(checkRslt == 1) end = mid - 1;
			else if(checkRslt == -1) start = mid + 1;
		}
		while(checkRslt == 0) {
			checkRslt = checkBuket(partSum, --mid, m);
			if(mid == 0 ) return 1;
		}
		return mid + 1; 
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		br.close();
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
