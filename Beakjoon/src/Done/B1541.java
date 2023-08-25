package Done;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {

	public static boolean isNum(char ch) {
		return ch>='0' && ch<='9'; 
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
		int len = input.length();
		int rslt = 0;
		int num = 0;
		int minus = 1;
		for(int i = 0; i < len; i++) {
			char ch = input.charAt(i);
			if(isNum(ch)) {
				num = num*10+Integer.valueOf(ch+"");
			}
			else {
				rslt += num*minus;
				num = 0;
				if(ch == '-')
					minus = -1;
			}
		}
		rslt += num*minus;
		System.out.println(rslt);
	}

}
