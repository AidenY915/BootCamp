package morningTest;

import java.util.Arrays;

public class StreamQ2 {

	public static void main(String[] args) {
		String[] names = {"YOON", "LEE", "PARK"};
		Arrays.stream(names).forEach((v)->System.out.println(v));
	}

}
