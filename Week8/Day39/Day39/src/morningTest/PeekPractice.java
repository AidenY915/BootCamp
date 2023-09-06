package morningTest;

import java.util.stream.IntStream;

public class PeekPractice {

	public static void main(String[] args) {
		IntStream stream = IntStream.of(1,2,3,4);
		stream = stream.peek(System.out::print);
		stream.forEach(System.out::println);
	}
	
}
