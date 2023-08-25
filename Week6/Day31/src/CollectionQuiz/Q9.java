package CollectionQuiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

class TmpComparator implements Comparator<String> {
	TreeMap<String, Integer> map;
	
	public TmpComparator(TreeMap<String, Integer> map) {
		this.map = map;
	}
	@Override
	public int compare(String o1, String o2) {
		return map.get(o2) - map.get(o1);
	}
}

class Q9 {
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };

		TreeMap<String, Integer> map = new TreeMap<>();
		
		for(int i = 0; i < data.length; i++) {
			if(!map.containsKey(data[i]))
				map.put(data[i], 1);
			else map.replace(data[i], map.get(data[i]) + 1);
		}
		List<String> keyList = new ArrayList(map.keySet());
		Collections.sort(keyList, new TmpComparator(map) 
//				new Comparator<String>() {
//					@Override
//					public int compare(String o1, String o2) {
//						return map.get(o2) - map.get(o1); //map final로 바뀜
//					}
//		}
		);
		Iterator<String> itr = keyList.iterator();
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
		map = null;	//final이 안되서 변경 가능
	}
}

