package morningTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class Q3 {
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };

		TreeMap<String, Integer> OriginMap = new TreeMap<>();
		for(String e : data)
			OriginMap.put(e, OriginMap.get(e) == null ? 1 : OriginMap.get(e)+1);
		
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(OriginMap.entrySet());
		Collections.sort(entryList, 
				new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
						return (o1.getValue() - o2.getValue())*-1;
					}
		});
		//결국 정렬 기준을 Value로 바꾸려면 list로 바꿔야 함. 그게 제일 편함.
		
		
		
		
		Iterator<Map.Entry<String, Integer>> itr = entryList.iterator();
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
