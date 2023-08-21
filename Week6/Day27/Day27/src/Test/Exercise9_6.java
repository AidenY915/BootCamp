package Test;

import java.util.Arrays;

public class Exercise9_6 {

	public static String fillZero(String src, int length) {
		if(length < 0) return "";
		
		int srcLen = src.length();
		char[] srcArr = src.toCharArray();
		char[] rsltArr = new char[length];
		Arrays.fill(rsltArr, '0');
		if(srcLen < length)
			System.arraycopy(srcArr, 0, rsltArr, length - srcLen, srcLen);
		else if(srcLen > length)
			System.arraycopy(srcArr, 0, rsltArr, 0, length);
			
		return String.valueOf(rsltArr);
		
		
	}
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src,10));
		System.out.println(fillZero(src,-1));
		System.out.println(fillZero(src,3));
	}
}
