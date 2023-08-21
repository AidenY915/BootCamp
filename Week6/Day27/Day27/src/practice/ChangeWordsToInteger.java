package practice;

public class ChangeWordsToInteger {

	private static int convert(String word) {
		String rslt = word;
		rslt=rslt.replaceAll("one", "1");
		rslt=rslt.replaceAll("two", "2");
		rslt=rslt.replaceAll("three", "3");
		return Integer.parseInt(rslt);
	}
	public static void main(String[] args) {
		String word = "onetwothree";
		System.out.println(convert(word));
	}

}
