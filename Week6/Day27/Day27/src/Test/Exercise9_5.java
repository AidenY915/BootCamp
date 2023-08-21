package Test;

public class Exercise9_5 {
	
	private static int count(String src, String pattern) {
		int idx = 0;
		int cnt = 0;
		int srcLen = src.length();
		int pLen =pattern.length();
		while(idx <= srcLen - pLen) {
			idx = src.indexOf(pattern,idx);
			if(idx == - 1) return cnt;
			cnt++;
			idx += pLen;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB","AB"));
		System.out.println(count("12345","AB"));
	}
}
