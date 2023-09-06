package Stream;

import java.util.stream.Stream;

public class StreamQ1 {

	public static void main(String[] args) {
		Stream.of(11,22,33,44).forEach(e->System.out.print(e + " "));
		Stream.of("Toy", "Robot", "Box").forEach(e->System.out.print(e + " "));
		Stream.of("So Simple").forEach(e->System.out.print(e + " "));
	}

}
