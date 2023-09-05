package Stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class streamPractice {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		IntStream is = Arrays.stream(arr);
		System.out.println(is);
		System.out.println(is.filter((v)->true));
	}

}
