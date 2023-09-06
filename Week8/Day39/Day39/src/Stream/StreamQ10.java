package Stream;

import java.util.stream.IntStream;

public class StreamQ10 {

	public static void main(String[] args) {
		
		int[] arr = {1, 3, 5, 7, 9};
		int sum = IntStream.of(arr).sum();
		long count = IntStream.of(arr).count();
		double avg = IntStream.of(arr).average().orElse(0);
		int min = IntStream.of(arr).min().orElse(0);
		int max = IntStream.of(arr).max().orElse(0);
		System.out.println(sum + "\n" + count + "\n" + avg + "\n" + min + "\n" + max );
	}

}
