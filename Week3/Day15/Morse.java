import java.util.Scanner;

public class Morse {
	final static String[] morse = {".-", "-...", "-.-.","-..", "."
						,"..-.", "--.", "....","..",".---"
						, "-.-", ".-..", "--", "-.", "---"
						, ".--.", "--.-",".-.","...","-"
						, "..-", "...-", ".--", "-..-","-.--"
						, "--.." };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder(str.length()*4);	
		for(int i = 0; i < str.length(); i++) {
			int pivot = str.charAt(i) < 'a' ? 'A' : 'a';
			sb.append(morse[str.charAt(i) - pivot]);
		}
		System.out.println(sb);

	}


}