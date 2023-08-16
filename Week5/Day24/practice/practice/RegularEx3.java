package practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx3 {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("(abc)\\w*");
		Matcher m = p.matcher("(abc)sdfsdf(abc)gsdgsdgsdg");
		while(m.find()) {
			System.out.println(m.group() + m.group(1));
		}
		
	}

}
