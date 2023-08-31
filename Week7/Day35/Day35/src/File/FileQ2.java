package File;

import java.io.File;

public class FileQ2 {

	public static void main(String[] args) {
		File f1 = new File("C:" + File.separator + "MyJava" + File.separator + "AAA");
		File f2 = new File(f1, "BBB");
		
		f2.mkdirs();
		System.out.println(f2.getAbsolutePath());
	}
}