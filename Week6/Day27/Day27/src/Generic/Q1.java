package Generic;

public class Q1 {
	private static <T> void print(T[] arr) {
		for(T e : arr) {
			System.out.print(e);
		}
	}
	
	public static void main(String[] args) {
		String[] arr = {"abc"," ", "def"};
		print(arr);
	}

}
