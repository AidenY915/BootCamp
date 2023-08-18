package Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2343 {

	private static int checkBucket(int[] timeArr, int m, int BucketSize) {
		int cnt = 1;
		int len = timeArr.length;
		int sum = 0;
		for(int i = 0; i < len; i++) {
			sum += timeArr[i];
			if(sum > BucketSize) {
				cnt++;					//넘치면 하나 더 준비
				sum = timeArr[i];
			}
		}
		return m - cnt;
		
	}
	
	private static int findLeastBucket(int[] timeArr, int m) {
		int len = timeArr.length;
		int max = timeArr[0];
		int sum = 0;
		for(int i = 0; i < len; i++) {
			max = Math.max(max, timeArr[i]);
			sum += timeArr[i];
		}
		int min = Math.max(max, sum / m + (sum%m==0 ? 0 : 1));
		int start = min;
		int end = sum;
		int mid = start;
		while(start <= end) {
			mid = (start+end)/2;
			if(checkBucket(timeArr, m, mid) == 0) break;
			else if(checkBucket(timeArr, m, mid) < 0) start = mid + 1;
			else end = mid - 1;
			
			if(mid < min) {
				return min;
			}
			if(mid > sum) {
				return sum;
			}
		}
		int rslt = mid;
		while(rslt >= start) {
			if(checkBucket(timeArr, m, rslt) < 0) {
				rslt++;
				break;
			}
			rslt--;
			if(rslt < min) {
				return min;
			}
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
		br.close();
		int[] timeArr = new int[n];
		for(int i = 0; i < n; i++) 
			timeArr[i] = Integer.parseInt(input[i]);
		System.out.println(findLeastBucket(timeArr, m));
	}
}
