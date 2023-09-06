package Stream;

import java.util.stream.Stream;

public class StreamQ3 {

	public static void main(String[] args) {
		String str = Stream.of("Box", "Simple", "Complex", "Robot").reduce("", 
				(s1, s2) -> {
			int gap = s1.length() - s2.length();
			if(gap >= 0) return s1;
			return s2;
		});
		System.out.println(str);
	}

}
