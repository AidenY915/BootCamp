package FileIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q1 {
	public static void main(String[] args) {
		String fileName = "src\\FileIO\\Q1.txt";
		StringBuilder sb = new StringBuilder(20);
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
				DataOutputStream dos = new DataOutputStream(bos)){
			dos.writeInt(275);
			dos.writeDouble(45.79);
			
			dos.writeChars("Aiden");
		}catch (IOException e) {
			e.printStackTrace();
		}

		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
				DataInputStream dis = new DataInputStream(bis)){
			sb.append(dis.readInt());	
			sb.append("\n");
			sb.append(dis.readDouble());
		}catch(FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sb);


	}
}
