package Test;

public class Exercise9_9 {

	private static String delChar(String src, String trash) {
		return src.replaceAll("["+trash+"]", "");
	}
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)"+" -> "
				+ delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)"+" -> "
				+ delChar("(1 2 3 4\t5)"," \t"));
	}

}
