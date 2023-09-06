package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamQ13 {

	public static void main(String[] args) {
		List<String> list1 =
			Stream.of("Hello", "Box", "Robot", "Toy").collect(
				()-> new ArrayList<>(4),
				(li, e)->li.add(e),
				(li1,li2)->li1.addAll(li2));
		System.out.println(list1);
		
		List<String> list2 =
				Stream.of("Hello", "Box", "Robot", "Toy").parallel().collect(
					ArrayList<String>::new,
					List::add,
					List::addAll);
			System.out.println(list2);
			
	}
}
