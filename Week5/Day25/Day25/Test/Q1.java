import java.util.ArrayList;
import java.util.Scanner;


public class Q1 {
	private static String[] phoneNumArr = {
			"012-3456-7890",
			"099-2456-7980",
			"088-2346-9870",
			"013-3456-7890"
	};
	
	private static ArrayList<String> comparePhoneNum(String word) {
		ArrayList<String> rslt = new ArrayList<String>(4);
		word = word.replaceAll(" |-", "");
		for(String e : phoneNumArr) {
			String tmp = e.replaceAll(" |-", "");
			if(tmp.contains(word))
				rslt.add(e);
		}
		return rslt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(comparePhoneNum(sc.nextLine()));
		sc.close();
	}

}
