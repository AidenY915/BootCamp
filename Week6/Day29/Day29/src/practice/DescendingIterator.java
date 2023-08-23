package practice;

import java.util.Iterator;
import java.util.TreeSet;

public class DescendingIterator {

	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<>();
		
		ts.add(3);
		ts.add(4);
		ts.add(5);
		ts.add(8);
		ts.add(7);
		ts.add(1);
		
		Iterator<Integer> itr = ts.descendingIterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
	}

}
