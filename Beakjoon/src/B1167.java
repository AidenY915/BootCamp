import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

class Vertex {
	int idx;
	LinkedList<Edge> incidence = new LinkedList<Edge>();
	public Vertex(int idx) {
		super();
		this.idx = idx;
	}
	public void addInc(Vertex v, int weigth) {
		Edge edge = new Edge(this, v, weigth);
		incidence.add(edge);
	}
	int distance;
	
	static public int findLongestFrom(Vertex v) {
		Iterator<Edge> iterator = v.incidence.iterator();
		Edge farthest = null;		
		int rslt = v.distance; 
		while(iterator.hasNext()) {
			Edge next = iterator.next();
			if(next.end.distance != -1)
				continue;
			if(farthest == null) {
				farthest = next;
			}
			farthest = farthest.weight >= next.weight ? farthest : next;
		}
		if(farthest == null) {
			v.distance = -1;
			return rslt;
		}
		farthest.end.distance = v.distance + farthest.weight;
		rslt = findLongestFrom(farthest.end);
		v.distance = -1;
		return rslt;
		
	}	
	static public int findDiameter(Vertex[] vArr){
		int max = 0;
		for(int i = 1; i < vArr.length - 1; i++) { //마지막 원소는 순회 안함.
			for(int j = 1; j < vArr.length; j++)
				vArr[j].distance = -1;
			vArr[i].distance = 0;
			int tmp = findLongestFrom(vArr[i]);
			max = max >= tmp ? max : tmp;
		}
		return max;
	}
}

class Edge {
	Vertex start, end;
	int weight;
	
	
public Edge(Vertex start, Vertex end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

}


public class B1167 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Vertex[] vArr = new Vertex[n+1];
		for(int i = 1; i <= n; i++) 
			vArr[i] = new Vertex(i);
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			Vertex start = vArr[Integer.parseInt(input[0])];
			for(int j = 1 ; j < input.length - 1; j+=2) {
				Vertex end = vArr[Integer.parseInt(input[j])];
				int weight = Integer.parseInt(input[j+1]);
				start.addInc(end, weight);
			}
		}
		br.close();
		System.out.println(Vertex.findDiameter(vArr));
		
	}

}
