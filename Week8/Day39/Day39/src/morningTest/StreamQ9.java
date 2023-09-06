package morningTest;

import java.util.Arrays;
import java.util.List;

public class StreamQ9 {

	public static void main(String[] args) {
		List<Box1<String>> ls = Arrays.asList(new Box1<>("Robot"), new Box1<>("Simple"));
		ls.stream().mapToInt(e->e.get().length()).forEach(e -> System.out.println(e));
	}	//mapToInt는 Stream<Integer>가 아니라 IntStream 리턴
}
