package morningTest;

import java.util.Arrays;
import java.util.List;

public class StreamQ4 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Toy", "Robot", "Box");
		list.stream().forEach(System.out::println);
	}

}
