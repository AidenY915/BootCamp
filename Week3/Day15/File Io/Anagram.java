import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;

class Methods {
	public static void swap(char arr[], int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void fisherYatesShuffle(char[] arr) {
		for(int i = arr.length - 1 ; i > 0 ; i--) {
			int j = (int)(Math.random() * (i + 1));
			swap(arr, i, j);
		}
	}
}

class Anagram {
	public static void main(String[] args) throws Exception {
		File f = new File("./aiden.txt");
		ArrayList<String> strList = null;
		strList = (ArrayList<String>)Files.readAllLines(f.toPath());
		
		String str = strList.get(0);
		System.out.println(str);
		char[] charArray = str.toCharArray();
		Methods.fisherYatesShuffle(charArray);
		str = new String(charArray);
		System.out.println(str);
		strList.remove(0);
		strList.add(str);
		Files.write(f.toPath(), strList, StandardCharsets.UTF_8,StandardOpenOption.WRITE);	//CharSet은 인코딩 방식 OpenOption은 읽기 쓰기 수정 추가
	}
}