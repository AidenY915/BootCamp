import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
								//연결리스트로 구현된 힙을 반복해서 사용하면, 가비지컬렉션이 과도하게 일어나거나, 큐에 원소를 추가할 때마다, 메모리를 할당하여, 메모리 초과가 발생
class Main {
	public static void main(String[] args) throws IOException{		//기수정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	
		int arr[] = new int[n];
		for(int i = 0 ; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		br.close();
		ArrayList<Queue<Integer>> que = new ArrayList<>(10);
		for(int i = 0; i < 10 ; i++)
			que.add(new LinkedList<>());
		int numOfDigits = 1;
		while(true) {
			for(int i = 0; i < n; i++)
				que.get(arr[i] / numOfDigits % 10).add(arr[i]);

			if(que.get(0).size() == n) break;
			int cnt = 0;
			for(int i = 0; i < 10; i++) {
				while(!que.get(i).isEmpty()) {
					arr[cnt++] = que.get(i).poll();
				}
			}	
			numOfDigits *= 10;
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder(10_000_000);
		while(!que.get(0).isEmpty())
			sb.append(que.get(0).poll() + "\n");
		System.out.print(sb);

	}
}