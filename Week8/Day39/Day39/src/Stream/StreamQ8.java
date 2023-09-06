package Stream;

import java.util.stream.IntStream;

public class StreamQ8 {

	public static void main(String[] args) {
		IntStream.of(3, 9, 4, 2).sorted().forEach(e->System.out.print(e+" "));
	}

}
