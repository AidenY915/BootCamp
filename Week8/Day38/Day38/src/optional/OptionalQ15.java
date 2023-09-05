package optional;

import java.util.Optional;

public class OptionalQ15 {

	public static void main(String[] args) {
		Optional<String> opt1 = Optional.empty();
		Optional<String> opt2 = Optional.ofNullable("So Basic");

		String s1 = opt1.orElse("Empty");
		String s2 = opt2.orElse("Empty");
		
		System.out.println(s1 + "\n" +s2);
	}

}
