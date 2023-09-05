package optional;

import java.util.Optional;

public class OptionalQ18 {

	public static void main(String[] args) {
		Optional<String> optStr = Optional.of("Optional String");
		System.out.println(optStr.map(String::toLowerCase).orElse("")); 
		System.out.println(optStr.flatMap(v -> Optional.ofNullable(v.toLowerCase())).orElse("")); 
	}

}
