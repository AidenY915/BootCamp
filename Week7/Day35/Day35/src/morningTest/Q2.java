package morningTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q2 {

	public static void main(String[] args) {
		String fileOrigin = "src\\morningTest\\Q2Origin.txt";
		String fileCopy = "src\\morningTest\\Q2Copy.txt";

		try(BufferedInputStream	 bid = new BufferedInputStream(new FileInputStream(fileOrigin),10000);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileCopy),10000)) {
			int byteData;
			while((byteData = bid.read()) != -1) {
				bos.write(byteData);
			}
			bos.flush();	//try with resource가 호출한 close가 자동 flush
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		try(BufferedInputStream bid = new BufferedInputStream(new FileInputStream(fileOrigin))){
			int byteData;
			while((byteData = bid.read()) != -1) {
				System.out.print((char)byteData);	//1byte문자들만 안깨짐
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
