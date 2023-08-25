import java.util.LinkedList;
import java.util.List;

public class Q3 {

	public static void main(String[] args) {
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		List<String> stringList = new LinkedList<>();
		int tokenLen = 10;
		int srcLen = source.length();
		for(int i = 0; i < srcLen; i+=tokenLen) {
			int end = i + tokenLen;
			stringList.add(source.substring(i,end <= srcLen ? end : srcLen));
		}
		System.out.println(stringList);
	}

}
