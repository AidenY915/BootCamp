package ReaderWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q1 {

	public static void main(String[] args) {
		String fileName = "src\\ReaderWriter\\hyper.txt";
		try (FileWriter fw = new FileWriter(fileName)){
			fw.write('A');
			fw.write('B');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (FileReader fr = new FileReader(fileName)){
			System.out.println(fr.read());
			System.out.println(fr.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
