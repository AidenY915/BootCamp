import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.*;

public class FileIO{			//파일 복사
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File file = new File(br.readLine());

		if(!file.exists()) {
			System.out.println("파일 없음.");
			file.createNewFile(); //해당 이름의 파일 생성
			System.out.println("파일 생성.");
		}
		Path source = Paths.get(file.getPath());
		String directory  = file.getParent() + "\\" + br.readLine();
		File dir = new File(directory); 
		if(!dir.exists()){
			System.out.println("디렉토리 없음.");
			dir.mkdirs(); //해당 이름의 파일 생성
			System.out.println("디렉토리 생성.");
		}
		Path destination = Paths.get(directory + "\\" + file.getName());
		Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);	//중복 시 덮어쓰기 복사
		System.out.println("복사 완료");
	}
}

/*
경로 표시 방법 : abstract pathname // File을 의미
		아니면 String
*/