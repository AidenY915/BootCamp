package Stream;

import java.util.stream.Stream;

public class StreamQ7 {

	public static void main(String[] args) {
		Stream.of("Box", "Apple", "Robot").sorted().forEach(System.out::println);
		Stream.of("Box", "Apple", "Robot").sorted((s1,s2)->s1.length()-s2.length()).forEach(System.out::println);

	}

}
