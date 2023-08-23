package practice;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapPractice {

	public static void main(String[] args) {
		TreeMap<Integer, String> tm = new TreeMap<>();
		
		tm.put(3, "Three");
		tm.put(4, "Four");
		tm.put(5, "Five");
		
		NavigableSet<Integer> ns = tm.navigableKeySet();
		Iterator<Integer> itr = ns.iterator();
		while(itr.hasNext()) {
			System.out.print(tm.get(itr.next())+" "); 
		}
		System.out.println();
		
		itr = ns.descendingIterator();
		while(itr.hasNext()) {
			System.out.print(tm.get(itr.next())+" "); 
		}
	}

}
