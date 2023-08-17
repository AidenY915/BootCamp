package Done;

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
	
	static public void findLongestFrom(Vertex v) {
		Iterator<Edge> iterator = v.incidence.iterator();
		while(iterator.hasNext()) {
			Edge next = iterator.next();
			int tmpNextDistance = v.distance + next.weight;
			if(next.end.distance == -1 || next.end.distance > tmpNextDistance) {
				next.end.distance = tmpNextDistance;
				findLongestFrom(next.end);
			}
		}
	}	
	
	static public int findDiameter(Vertex[] vArr){
		int rslt = 0;
		int startPoint = 1;
		for(int i = 1; i < vArr.length; i++) {
			vArr[i].distance = -1;
		}
		vArr[startPoint].distance = 0;
		findLongestFrom(vArr[startPoint]);
		for(int i = 1; i < vArr.length; i++) {
			startPoint = vArr[startPoint].distance > vArr[i].distance ? startPoint : i;
		}
		for(int i = 1; i < vArr.length; i++) {
			vArr[i].distance = -1;
		}
		vArr[startPoint].distance = 0;
		findLongestFrom(vArr[startPoint]);
		for(int i = 1; i < vArr.length; i++) {
			rslt = rslt > vArr[i].distance ? rslt : vArr[i].distance;
		}
		return rslt;
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
