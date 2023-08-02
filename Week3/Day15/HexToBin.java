import java.util.Scanner;

public class HexToBin {
	static int hexToInt(char hex) {
		if(hex >= '0' && hex <= '9' ) return hex-'0';
		if(hex >= 'A' && hex <= 'F') return hex-'A'+10;
		if(hex >= 'a' && hex <= 'f') return hex-'a'+10;
		return -1;
	}
	static String intToBin(int digit) {
		StringBuilder sb = new StringBuilder();
		while(digit > 0){
			sb.append(digit%2);
			digit/=2;
		}
		while(sb.length() < 4)
			sb.append("0");
		sb.reverse();
		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hex =sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < hex.length(); i++) {
			char ch = hex.charAt(i);
			if(ch == -1) {
				System.out.println("16진수 아님.");
				return;
			}
			int digit = hexToInt(ch);
			sb.append(intToBin(digit));
		}
		System.out.println(sb);

	}	

}

class HexToBinByMethod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hex =sc.nextLine();

		int n = Integer.parseInt(hex, 16);
		System.out.println(Integer.toBinaryString(n));
	}
}