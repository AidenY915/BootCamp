package Stream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamQ12 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Box", "Simple", "Complex", "Robot");
		Optional<String> optStr = list.stream().reduce((s1,s2) -> {
			int gap = s1.length() - s2.length();
			if(gap >= 0) return s1;
			return s2;
		});
		System.out.println(optStr.orElse("없음"));
	}

}
