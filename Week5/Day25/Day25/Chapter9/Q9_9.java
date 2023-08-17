import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q9_9 {

	private static String delChar(String src, String delCh) {
		StringBuilder sb = new StringBuilder(src);
		Pattern p = Pattern.compile("["+delCh+"]");
		Matcher m = p.matcher(src);
		while(m.find())
			sb.deleteCharAt(sb.indexOf(m.group()));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)"+" -> "+ delChar("(1!2@3^4~5)","~!@#$%^&*()"));

		System.out.println("(1 2 3 4\t5)"+" -> "+ delChar("(1 2 3 4\t5)"," \t"));

	}
}