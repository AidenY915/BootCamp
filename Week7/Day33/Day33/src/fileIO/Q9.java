package fileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q9 {

	public static void main(String[] args) {
		String originFileName = "src\\fileIO\\origin.txt"; 
		String copyFileName = "src\\fileIO\\copy.txt";
		try(FileInputStream is = new FileInputStream(originFileName);
				FileOutputStream os = new FileOutputStream(copyFileName)){
			int data = 0;
			while((data = is.read()) != -1)
			{
				os.write(data);
			}
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage() + "\n");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
