package Done;

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
		while(start <= end) {
			int mid = (start+end)/2;
			if(checkBucket(timeArr, m, mid) < 0) start = mid + 1;
			else end = mid - 1;					//end만 내려가고 start를 리턴하므로 절대로 최소 이하의 값이 결과로 나올 일이 없음. start는 위로만 감 
			}										//값이 같을 경우 end가 아래로 내려가기 때문에 start가 최대를 넘을 일도 없음.!!!!!
		return start;
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
