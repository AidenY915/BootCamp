package File;

import java.io.File;

public class FileQ3 {

	public static void main(String[] args) {
		File myDir = new File("C:" + File.separator + "MyJava" + File.separator + "MyDir");
		myDir.mkdir();
		File[] list = myDir.listFiles();
		for(File e : list) {
			System.out.println(e);
			if(e.isDirectory())
				System.out.println("디렉토리");
			if(e.isFile())
				System.out.println("파일");
		}
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("java.version"));
	}

}
