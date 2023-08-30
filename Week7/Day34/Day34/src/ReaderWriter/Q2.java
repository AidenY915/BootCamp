package ReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q2 {

	public static void main(String[] args) {
		String fileName = "src\\ReaderWriter\\String.txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
			bw.write("박지성 - 메시 멈추게 하는데 집중하겠다.\r\n"
					+ "올 시즌은 나에게 있어 최고의 시즌이다.\r\n"
					+ "팀이 승리하는 것을 돕기 위해 최선을다하겠다.\r\n"
					+ "환상적인 결승전이 될 것이다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
