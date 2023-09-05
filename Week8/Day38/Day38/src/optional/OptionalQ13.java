package optional;

import java.util.Optional;

class OptionalQ13 {
	public static void main(String[] args) {
		Optional<String> o1 = Optional.of("Toy1");
		Optional<String> o2 = Optional.of("Toy2");
		
		o1.ifPresent((v) -> System.out.println(v));
		o2.ifPresent((v) -> System.out.println(v));
		
		o1.ifPresent(System.out::println);
		o2.ifPresent(System.out::println);
	}
}
