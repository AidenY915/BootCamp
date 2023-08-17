import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Q9_14 {

	public static void main(String[] args) {
		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};
		ArrayList list = new ArrayList();
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.print(">>");
			String input = s.nextLine().trim();
			if(input.equals("")) {
				continue;
			} else if(input.equalsIgnoreCase("Q")) {
				s.close();
				System.exit(0);
			}

			Pattern p = Pattern.compile(input.replaceAll("- ", ""));
			for(String e : phoneNumArr) {
				if(p.matcher(e).find())
					list.add(e);
			}

			
			if(list.size()>0) {
				System.out.println(list);
				list.clear();
			} else {
				System.out.println("일치하는 번호가 없습니다."); 
			}
		}
		
	} // main
}