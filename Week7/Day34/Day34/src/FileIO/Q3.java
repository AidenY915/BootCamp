package FileIO;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q3 {

	public static void main(String[] args) {
		String fileName = "src\\FileIO\\Q3Output.txt";
		long start = 0, end = 0;
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))){
			start = System.currentTimeMillis();
			for(int i = 0; i < 1000; i++) {
				dos.writeDouble(12.345);
			}
			end = System.currentTimeMillis();;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(end - start);
		
		try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))){
			start = System.currentTimeMillis();
			StringBuilder sb = new StringBuilder(1000*8);
			for(int i = 0; i < 1000; i++) {
				dos.writeDouble(12.345);
			}
			end = System.currentTimeMillis();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(end - start);
		
	}

}
