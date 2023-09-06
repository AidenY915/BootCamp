package morningTest;

import java.util.Arrays;

public class StreamQ5 {

	public static void main(String[] args) {
		int[] ar = {1, 2, 3, 4, 5};
		Arrays.stream(ar).filter(n -> n%2!=0).forEach(System.out::println);
		String[] strArr = {"Toy", "Robot", "Box"};
		Arrays.stream(strArr).filter(str -> str.length()==3).forEach(System.out::println);
	}

}
