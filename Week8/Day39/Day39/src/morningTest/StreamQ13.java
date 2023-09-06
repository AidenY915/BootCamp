package morningTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamQ13 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Box", "Simple", "Complex", "Robot");
		String rslt = list.parallelStream().reduce("aaaaaaaaa", (s1,s2) -> {
			int gap = s1.length() - s2.length();
			if(gap >= 0) return s1;
			return s2;
			});
		System.out.println(rslt);
		
		Stream.empty().forEach(System.out::print);
	}

}
