package practice7;

import java.util.StringTokenizer;

public class Q7_10 {

	public static void main(String[] args) {
		String time = "11:22:33:44:55" ;
		StringTokenizer st = new StringTokenizer(time, ":");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
	}
}
