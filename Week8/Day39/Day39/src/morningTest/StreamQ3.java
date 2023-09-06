package morningTest;

import java.util.Arrays;

public class StreamQ3 {

	public static void main(String[] args) {
		double[] ds = {1.1, 2.2, 3.3, 4.4, 5.5};
		Arrays.stream(ds,0,4).forEach(e->System.out.println(e));
	}

}
