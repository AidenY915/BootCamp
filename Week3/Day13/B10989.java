import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
								
class Main {
	static void swapInt(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String[] args) throws IOException{		//기수정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	
		int arr[] = new int[n];
		for(int i = 0 ; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		br.close();
			
		for (int numOfDigits = 1; numOfDigits <= 10000 ; numOfDigits*=10) {
			int last = 0;
			for(int i = 0; i<= 8; i++) {
			 	for(int j = last; j < arr.length; j++) {
					if(arr[j] %(numOfDigits * 10) / numOfDigits == i)
						swapInt(arr, last++, j);				
				}
			}
		}
		StringBuilder sb = new StringBuilder(10_000_000*5);
		for(int i = 0; i < n; i++)
			sb.append(arr[i] + "\n");
		System.out.print(sb);

	}
}