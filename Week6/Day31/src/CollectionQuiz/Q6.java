
package CollectionQuiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Q6 {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("김자바", 90);
		hm.put("김자바", 100);
		hm.put("이자바", 100);
		hm.put("강자바", 80);
		hm.put("안자바", 90);
		
		Set hmSet = hm.keySet();
		Iterator<String> itr = hmSet.iterator();
		int sum = 0;
		int max = -1;
		int min = 101;
		while(itr.hasNext()) {
			String key = itr.next();
			int value = hm.get(key);
			System.out.println(key + " " + value);
			max = Math.max(max,value);
			min = Math.min(min,value);
			sum+=value;
		}
		System.out.printf("총점: %d 평균: %.1f 최고점: %d 최저점: %d",sum, sum/(double)hm.size(), max, min);
	}

}
