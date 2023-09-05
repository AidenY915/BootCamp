package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamPractice2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Optional<Integer> c = list.stream().reduce((a,b)-> a);
		System.out.println(c.orElse(5));
	}

}
