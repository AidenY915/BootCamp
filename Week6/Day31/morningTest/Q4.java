import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q4 {

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>(1000000); 
		List<Integer> linkedList = new LinkedList<>();
		long start;
		long end;
		start = System.currentTimeMillis();
		for(int i = 0 ; i < 1000000; i++)
			arrayList.add(i);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		for(int i = 0 ; i < 1000000; i++)
			linkedList.add(i);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		for(int i = 0 ; i < 1000000; i++)
			arrayList.get(i);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		Iterator<Integer> itr = linkedList.iterator(); 
		start = System.currentTimeMillis();
//		for(int i = 0 ; i < 1000000; i++)
//			linkedList.get(i);
		while(itr.hasNext())
			itr.next();
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
	}

}
