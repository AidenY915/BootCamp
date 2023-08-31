package morningTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q1 {

	public static void main(String[] args) {
		String fileName = "src\\morningTest\\Q1.txt";
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))){
			dos.writeInt(275);
			dos.writeDouble(45.79);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName))){
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
