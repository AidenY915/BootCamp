package CollectionQuiz;

import java.util.*;

class Q8 {
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };

		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < data.length; i++) {
			if(!map.containsKey(data[i]))
				map.put(data[i], 1);
			else map.replace(data[i], map.get(data[i]) + 1);
		}
		Set<String> mapKeySet =  map.keySet();
		Iterator<String> itr = mapKeySet.iterator();
		StringBuilder sb = new StringBuilder(100);
		while(itr.hasNext()) {
			String key = itr.next();
			sb.append(key+" : ");
			int cnt = map.get(key);
			for(int i = 0; i < cnt ; i++)
				sb.append('#');
			sb.append(" " + cnt + "\n");
		}
		System.out.println(sb);
	}
}
