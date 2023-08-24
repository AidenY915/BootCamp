package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AsListQ1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Box", "Toy", "Box", "Toy");
		Set<String> set = new HashSet<>(list);
		System.out.println(set);
	}

}
