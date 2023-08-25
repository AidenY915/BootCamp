package CollectionQuiz;

import java.util.TreeSet;

public class Q4 {
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		while(ts.size() < 6)
			ts.add((int)(Math.random()*45)+1);
		System.out.println(ts);
	}
}
