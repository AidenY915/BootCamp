package morningTest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterPractice {
	public static void main(String[] args) {
		String fileName = "src\\morningTest\\printf.txt";
		try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
			pw.printf("제 나이는 %d살 입니다.\r\n"
					+ "저는 자바가 좋습니다.\r\n"
					+ "특히 I/O 부분에서 많은 매력을 느낍니다.", 24);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
