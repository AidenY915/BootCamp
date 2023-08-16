package practice;

public class Align {
	private static char[] dest = new char[10];
	private static char[] src = {'1', '2', '3', '4'};
	public static void main(String[] args) {
		String destStr = String.valueOf(dest);
		String srcStr = String.valueOf(src);
		destStr = destStr.replaceAll((char)0 + "","0");
		StringBuilder sb = new StringBuilder(destStr);
		sb.replace(sb.length() - srcStr.length(), sb.length(), srcStr);
		System.out.println(sb);
		
		sb = new StringBuilder(destStr);
		sb.replace(0, srcStr.length(), srcStr);
		System.out.println(sb);
		
		sb = new StringBuilder(destStr);
		sb.delete(sb.length() - srcStr.length(), sb.length());
		sb.insert(sb.length()/2, srcStr);
		System.out.println(sb);
		
	}
}
