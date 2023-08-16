package practice;

import java.util.regex.*;	// Pattern과 Matcher가 속한 패키지

class RegularEx2 {
	public static void main(String[] args) {
		String[] data = {"bat", "baby", "bonus", "c", "cA",
				        "ca", "co", "c.", "c0", "c#",
					"car","combat","count", "date", "disc"
						};		
		String[] pattern = {".*","c[a-z]*","c[a-z]", "c[a-zA-Z]",
                                          "c[a-zA-Z0-9]","c.","c.*","c\\.","c\\w",
                                          "c\\d","c.*t", "[b|c].*", ".*a.*", ".*a.+",
                                          "[b|c].{2}"
                                         };

		for(int x=0; x < pattern.length; x++) {
			Pattern p = Pattern.compile(pattern[x]);
			System.out.print("Pattern : " + pattern[x] + "  결과: ");
			for(int i=0; i < data.length; i++) {
				Matcher m = p.matcher(data[i]);
				if(m.matches())
					System.out.print(data[i] + ",");
			}
			System.out.println();
		}
	} // public static void main(String[] args) 
}

/*
다
c로시작 + 소문자
c+소문자
c+알파벳
c+알파벳 or 숫자
c+아무거나
c+아무 문자열
c.
c+알파벳 or 숫자 or 언더바
c+숫자
c+아무문자열 + t로 끝
b or c로 시작 하는 아무 문자열
아무문자열 + a +아무문자열 //a가 포함만 되면 다
a가 포함되고 첫 a 이후에 뭐라도 있는 문자열
b나c로 시작하는 세글자
*/