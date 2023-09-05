package morningTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Q2_5 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Box","Robot");
		Consumer<List<String>> cons1 = (li) -> System.out.println(li);
		cons1.accept(list);
		
		Consumer<List<String>> cons2 = System.out::println;
		cons2.accept(list);
		
	}

}
