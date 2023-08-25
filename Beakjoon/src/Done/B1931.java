package Done;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Meeting implements Comparable<Meeting> {
	int start;
	int end;
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Meeting o) {
		int rslt = end - o.end;
		return rslt == 0 ? start - o.start : rslt;
	}
}

public class B1931 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Meeting> pQue = new PriorityQueue<>(n);
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			pQue.add(new Meeting(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		br.close();
		int cnt = 0;
		int last = 0;
		while(!pQue.isEmpty()) {
			Meeting tmp = pQue.poll();
			if(tmp.start < last) continue;
			last = tmp.end;
			cnt++;	
		}
		System.out.println(cnt);
	}

}
