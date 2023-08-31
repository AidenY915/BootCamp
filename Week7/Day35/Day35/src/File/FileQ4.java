package File;

import java.io.File;

public class FileQ4 {

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);
		System.out.println("시작");
		File now = new File(workingDir);
		while(now!=null) {
			System.out.println("<"+now.getName()+">");
			for(File e : now.listFiles())
				System.out.println(e.getName() + "\t\t" + (e.isDirectory() ? "DIR" : "FILE"));
			System.out.println();
			now = now.getParentFile();
		}
	}
}
