package morningTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WritePractice {

	public static void main(String[] args) {
		String fileName = "src\\morningTest\\String.txt";
		try(Writer w = new FileWriter(fileName)){
			w.write("박지성 - 메시 멈추게 하는데 집중하겠다.\r\n"
					+ "올 시즌은 나에게 있어 최고의 시즌이다.\r\n"
					+ "팀이 승리하는 것을 돕기 위해 최선을다하겠다.\r\n"
					+ "환상적인 결승전이 될 것이다.\r\n"
					+ "\r\n"
					+ "기사 제보 및 보도자료\r\n"
					+ "press@goodnews.co.kr");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line;
			while((line = br.readLine()) != null)
			System.out.println(line);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
