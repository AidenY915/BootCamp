package morningTest;

import java.util.Arrays;

public class StreamQ1 {

	public static void main(String[] args) {
		int[] ar = {1,2,3,4,5};
		int sum = Arrays.stream(ar).sum();
		System.out.println(sum);
	}

}
