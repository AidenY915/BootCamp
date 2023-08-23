package Done;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class B1715 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			que.add(Integer.parseInt(br.readLine()));
		}
		while(que.size() != 1) {
			Integer min1 = que.poll();
			Integer min2 = que.poll();
			int tmpSum = min1+min2; 
			que.add(tmpSum);
			sum += tmpSum;
		}
		System.out.println(sum);
	}
}
