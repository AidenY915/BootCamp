package ObjectIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class randomAcessFilePractice {

	public static void main(String[] args) {
		String fileName = "data.bin";
		try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
			raf.writeInt(200);
			raf.writeInt(500);
			System.out.println(raf.getFilePointer());
			
			raf.writeDouble(48.65);
			raf.writeDouble(52.24);
			System.out.println(raf.getFilePointer());
			
			raf.seek(0);
			System.out.println(raf.getFilePointer());
			
			System.out.println(raf.readInt());
			System.out.println(raf.readInt());
			System.out.println(raf.getFilePointer());
			
			System.out.println(raf.readDouble());
			System.out.println(raf.readDouble());
			System.out.println(raf.getFilePointer());

			raf.seek(raf.length()-8);
			System.out.println(raf.readDouble());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
