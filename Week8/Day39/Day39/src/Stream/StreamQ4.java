package Stream;

import java.util.stream.Stream;

public class StreamQ4 {

	public static void main(String[] args) {
		Stream.concat(Stream.of("Cake", "Milk"), Stream.of("Lemon", "Jelly")).forEach(System.out::println);
	}
}
