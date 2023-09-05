package morningTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Q2_1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,3,5,7,9);
		System.out.println(list);
		Consumer<List<Integer>> consumer = 
				(li) -> Collections.reverse(li);;
		consumer.accept(list);
		System.out.println(list);
	}

}
