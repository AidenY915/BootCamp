import java.util.regex.Pattern;

public class Q9_7 {
	private static boolean contains(String src, String pattern) {
		return Pattern.compile(pattern).matcher(src).find();
	}
	
	public static void main(String[] args) {
		System.out.println(contains("12345","23"));
		System.out.println(contains("12345","67"));
	}
}
