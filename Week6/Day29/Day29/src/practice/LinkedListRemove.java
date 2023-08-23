package practice;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListRemove {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("first");
		list.add("two");
		list.add("three");
		list.add("four");
		Iterator<String> itr = list.iterator();
		itr.next();
		itr.next();
		itr.remove();
		var tmp = itr.next();
		itr.remove();
		
		System.out.println(tmp);
		System.out.println(list);

	}

}
