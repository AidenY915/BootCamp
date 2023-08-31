package morningTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q4 {

	public static void main(String[] args) {
		String fileName = "src\\morningTest\\Q4.txt";
		try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))){
			long start = System.currentTimeMillis();
			for(int i = 0; i < 10000; i++)
				dos.writeDouble(12.345);
			long end = System.currentTimeMillis();
			System.out.println(end- start);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))){
			long start = System.currentTimeMillis();
			for(int i = 0; i < 10000; i++)
				dos.writeDouble(12.345);
			long end = System.currentTimeMillis();
			System.out.println(end- start);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
