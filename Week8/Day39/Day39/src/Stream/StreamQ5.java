package Stream;

import java.util.stream.Stream;

public class StreamQ5 {

	public static void main(String[] args) {
		String str = "aaaaa_bbbb_ccc_ddd";
		Stream.of(str.split("_")).forEach(System.out::println);
	}

}
