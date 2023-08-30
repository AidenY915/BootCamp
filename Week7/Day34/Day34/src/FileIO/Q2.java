package FileIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q2 {

	public static void main(String[] args) {
		String originFileName = "src\\FileIO\\Q2Origin.txt";
		String copyFileName = "src\\FileIO\\Q2Copy.txt";
		
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(originFileName),10000);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyFileName),10000)){
			int len = 0;
			while((len = bis.read())!=-1) {					//bis와 bos는 각각 버퍼를 가지고 있음. 어떻게 복사를 하는거지?
				bos.write(len);								//전달인자로 byte배열을 보내주지 않음.
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
