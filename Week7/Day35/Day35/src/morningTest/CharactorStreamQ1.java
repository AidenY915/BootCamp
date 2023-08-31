package morningTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharactorStreamQ1 {

	public static void main(String[] args) {
		String fileName = "src\\\\morningTest\\\\hyper.txt";
		try(FileWriter fr = new FileWriter(fileName)){
			fr.write('A');
			fr.write('B');
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileReader fr = new FileReader(fileName)){
			System.out.println((char)fr.read());
			System.out.println((char)fr.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
