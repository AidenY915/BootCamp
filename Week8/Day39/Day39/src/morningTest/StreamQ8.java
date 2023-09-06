package morningTest;

import java.util.Arrays;
import java.util.List;

public class StreamQ8 {

	public static void main(String[] args) {
		List<Box1<String>> ls = Arrays.asList(new Box1<>("Robot"), new Box1<>("Simple"));
		ls.stream().map(e->e.get().length()).forEach(e -> System.out.println(e));
	}

}
