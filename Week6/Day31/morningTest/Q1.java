import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Q1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Box", "Toy", "Box", "Toy");
		list = new ArrayList<>(list);
		System.out.println(list);
		HashSet<String> hm = new HashSet<>(list);
		System.out.println(hm);
	}

}
