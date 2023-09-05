package optional;

import java.util.Optional;

public class OptionalQ14 {

	public static void main(String[] args) {
		Optional<String> opt1 = Optional.of("Optional String");
		opt1 = opt1.map((value) -> value.replaceAll(" ", "_") )
				.map((value) -> value.toUpperCase());
		System.out.println(opt1.orElse("Empty"));
		
		Optional<String> opt2 = Optional.of("Optional String");
		opt2 = opt2.map((value) -> value.replaceAll(" ", "_") )
				.map(String::toUpperCase);
		System.out.println(opt2.orElse("Empty"));
	}

}
