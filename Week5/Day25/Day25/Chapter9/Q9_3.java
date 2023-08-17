import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q9_3 {

	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		int idx = fullPath.lastIndexOf("\\");
		System.out.println(fullPath.substring(0, idx+1));
		System.out.println(fullPath.substring(idx+1, fullPath.length()));
		
		
		
		Pattern p = Pattern.compile("^c(.*\\\\)");
		Matcher m = p.matcher(fullPath);
		if(m.find())
			path = m.group();

		p = Pattern.compile("\\w+\\.[a-z]+ $");
		m = p.matcher(fullPath);
		if(m.find())
			fileName = m.group();
		
		System.out.println("fullPath:"+fullPath);
		System.out.println("path:"+path);
		System.out.println("fileName:"+fileName);
	}
}