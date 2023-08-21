package Test;

public class SeparateRoute {

	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		int idx = fullPath.lastIndexOf('\\');
		String fileName = fullPath.substring(idx+1);
		String path = fullPath.substring(0,idx);
		
		System.out.println(path);
		System.out.println(fileName);
		
	}

}
