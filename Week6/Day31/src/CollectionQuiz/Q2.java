package CollectionQuiz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> hs = new LinkedHashSet(25);
		while(hs.size()<25) {
			hs.add((int)(Math.random()*50)+1);
		}
		Integer[][] rslt = new Integer[5][5];
		
		Iterator<Integer> itr = hs.iterator();
		int i = 0;
		while(itr.hasNext()) {
			rslt[i/5][i%5] = itr.next();
			i++;
		}
		for(i = 0; i < 5; i++) {
			System.out.println(Arrays.toString(rslt[i]));
		}
	}

}
