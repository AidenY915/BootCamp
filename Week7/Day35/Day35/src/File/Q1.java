package File;

import java.io.File;

public class Q1 {

	public static void main(String[] args) {
		File file = new File("C:"+File.separator+"MyJava"+File.separator+"my.bin");
		System.out.println(file.exists());
	}
}
