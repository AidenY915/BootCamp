import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;

class Vertex{
	int idx;
	boolean visit = false;
	LinkedList<Edge> incidence = new LinkedList<Edge>();
	Vertex(int _idx) {idx= _idx;}
}

class Edge implements Comparable<Edge>{	//Collections.sort()를 위함
	Vertex start, end;
	Edge(Vertex _start, Vertex _end) {
		start = _start;
		end = _end;
		start.incidence.add(this);
	}
	@Override
	public int compareTo(Edge other) {		//인터페이스 public
		return this.end.idx - other.end.idx;
	}
}

class Main {
	static StringBuilder sb = new StringBuilder(2000);
	public static void DFS(Vertex start) {
		if(start.visit) return;
		start.visit = true;
		sb.append(start.idx + " ");
		Iterator<Edge> iterator = start.incidence.iterator();
		while(iterator.hasNext()) {		
			DFS(iterator.next().end);
		}
		return;
	}

	public static void BFS(Vertex start) {
		Queue<Vertex> que = new LinkedList<Vertex>();
		que.offer(start);
		while(!que.isEmpty()) {
			Vertex now = que.poll();
			if(now.visit) continue;
			now.visit = true;
			sb.append(now.idx + " ");
			Iterator<Edge> iterator = now.incidence.iterator();
			while(iterator.hasNext()) {
				que.offer(iterator.next().end);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int vNum = Integer.parseInt(input[0]);
		int eNum = Integer.parseInt(input[1]);
		int startIdx = Integer.parseInt(input[2]);
		
		Vertex[] vArr = new Vertex[vNum + 1];
		for(int i = 1; i <= vNum; i++)
			vArr[i] = new Vertex(i);
		for(int i = 0; i < eNum; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			new Edge(vArr[start], vArr[end]);
			new Edge(vArr[end], vArr[start]);
		}
		br.close();
		for(int i = 1; i <= vNum; i++)
			Collections.sort(vArr[i].incidence);
		DFS(vArr[startIdx]);
		System.out.println(sb);
		for(int i = 1; i <= vNum; i++)
			vArr[i].visit = false;	
		sb.delete(0,sb.length());
		BFS(vArr[startIdx]);
		System.out.println(sb);
	}
}