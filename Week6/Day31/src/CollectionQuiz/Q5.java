package CollectionQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q5 {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("myId", "1234");
		hm.put("asdf", "1111");
		hm.put("asdf", "1234");
		String id = null;
		String password = null;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			id = br.readLine();
			password = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String rslt = hm.get(id);
		if(rslt == null) {
			System.out.println("id 없음");
			return;
		}
		if(!rslt.equals(password)) {
			System.out.println("불일치");
			return;
		}
		System.out.println("일치");
		
	}

}
