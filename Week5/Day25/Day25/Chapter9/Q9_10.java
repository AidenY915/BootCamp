
public class Q9_10 {

	private static String format(String str, int length, int type) {
		char[] strArr = str.toCharArray();
		char[] rslt = new char[length];
		if(type == 0)
			System.arraycopy(strArr, 0, rslt, 0, str.length());
		else if(type == 1)	
			System.arraycopy(strArr, 0, rslt, (length - str.length())/2, str.length());
		else if(type == 2)
			System.arraycopy(strArr, 0, rslt, length - str.length(), str.length());
		return String.valueOf(rslt);
	}
	
	public static void main(String[] args) {
		String str = "가나다"; 
		System.out.println(format(str,7,0)); // 왼쪽 정렬
		System.out.println(format(str,7,1)); // 가운데 정렬
		System.out.println(format(str,7,2)); // 오른쪽 정렬
	}
}
