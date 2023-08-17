import java.util.Arrays;

public class Q9_6 {
	public static String fillZero(String src, int length) {
		if(src == null || src.length() == length) return src;
		if(length <= 0) return "";
		char[] srcArr = src.toCharArray();
		char[] rslt = new char[length];
		Arrays.fill(rslt, '0');
		int copylen = src.length() < length ? src.length() : length;
		System.arraycopy(srcArr, 0, rslt, length - copylen, copylen);
		return String.valueOf(rslt);
	}
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src,10));
		System.out.println(fillZero(src,-1));
		System.out.println(fillZero(src,3));
	}
}
