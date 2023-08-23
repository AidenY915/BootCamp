package practice;

import java.util.HashMap;

public class HashMapPractice {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(3, "Three");
		hm.put(4, "Four");
		hm.put(5, "Five");
		
		System.out.println(hm);
		System.out.println(hm.get(4));
		
		hm.remove(4);
		System.out.println(hm);
		
	}

}
