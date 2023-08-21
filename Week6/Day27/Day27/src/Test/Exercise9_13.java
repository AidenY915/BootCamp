package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise9_13 {

	public static void main(String[] args) {
		String src = "aabbccAABBCCaa";
		System.out.println(src);
		System.out.println("aa를" + stringCount(src, "aa") +"개 찾았습니다."); 
	}
	static int stringCount(String src, String key) {
		return stringCount(src, key, 0);
	}

	static int stringCount(String src, String key, int pos) {
		Pattern p = Pattern.compile(key);
		Matcher m = p.matcher(src.substring(pos));
		int cnt = 0;
		while(m.find()) {
			cnt++;
		}
		return cnt;
	}
}
