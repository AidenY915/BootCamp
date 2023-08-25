package CollectionQuiz;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Q1 {

	public static void main(String[] args) {
		HashSet<Integer> lotto1 = new HashSet<Integer>();
		while(lotto1.size() < 6)
			lotto1.add((int)(Math.random()*45)+1);
		System.out.println(lotto1);
		
		LinkedList<Integer> lotto2 = new LinkedList<Integer>(lotto1);
		Collections.sort(lotto2);
		System.out.println(lotto2);
		
	}

}
