package morningTest;

import java.util.*;

class HashMapEx4 {
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };

		HashMap<String, Integer> map = new HashMap<>();
		
		for(String e : data) {
			map.put(e, map.get(e) == null ? 1 : map.get(e)+1);
		}
		Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
		StringBuilder sb = new StringBuilder(100);
		while(itr.hasNext()) {
			Map.Entry<String, Integer> entry = itr.next();
			int cnt = entry.getValue();
			sb.append(entry.getKey() + " : ");
			for(int i = 0 ; i < cnt; i++) {
				sb.append("#");
			}
			sb.append(" " + cnt + "\n");
		}
		System.out.println(sb);
	}
}