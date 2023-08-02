import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
								
class Main {
	public static void main(String[] args) throws IOException{		//기수정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	
		int arr[] = new int[n];
		int output[] = new int[arr.length];		//추가 공간
		for(int i = 0 ; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		br.close();
			
		for (int base = 1; base <= 10000 ; base*=10) {	//자리수 바꾸기
			int[] startIdx = new int[10];		//구간합으로 각 버켓의 끝인덱스(경계) 계산
			for(int i = 0; i < arr.length; i++)
				startIdx[arr[i]/base%10]++;
			for(int i = 1; i < startIdx.length; i++)
				startIdx[i] += startIdx[i - 1];
			for(int i = arr.length - 1; i >= 0 ; i--) {			//뒤에서 부터 접근		
				output[startIdx[arr[i]/base%10] - 1] = arr[i]; 
				startIdx[arr[i]/base%10]--;			//끝에서부터 삽입
			}
			int[] tmp = arr;
			arr = output;
			output = tmp;
		}
		StringBuilder sb = new StringBuilder(10_000_000*5);
		for(int i = 0; i < n; i++)
			sb.append(arr[i] + "\n");
		System.out.print(sb);
	}
}