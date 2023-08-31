package morningTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

class MyInfo
{
	String info;
	public MyInfo(String info) { this.info = info; }
	public String toString() { return info; }
}

class PrintlnPrintf
{
	public static void main(String[] args)
	{
		MyInfo mInfo = new MyInfo("저는 자바 프로그래머입니다.");
		try {
			PrintStream out = new PrintStream(new FileOutputStream("src\\morningTest\\PrintlnPrintf.txt"));
			out.println("제 소개를 하겠습니다.");
			out.println(mInfo);
			out.printf("나이 %d, 몸무게 %dkg입니다.", 24, 72);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}