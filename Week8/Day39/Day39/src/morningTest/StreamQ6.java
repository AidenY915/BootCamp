package morningTest;

import java.util.Arrays;

public class StreamQ6 {
	public static void main(String[] args) {
		String[] strArr = {"Toy", "Robot", "Box"};
		Arrays.stream(strArr).forEach(e -> System.out.println(e.length()));
	}
}
