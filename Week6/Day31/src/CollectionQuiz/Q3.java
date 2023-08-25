package CollectionQuiz;

import java.util.HashSet;

public class Q3 {
	public static void main(String[] args) {
		HashSet<Integer> hs1 = new HashSet<Integer>();
		for(int i = 1; i <= 5; i++)
			hs1.add(i);
		HashSet<Integer> hs2 = new HashSet<Integer>();
		for(int i = 4; i <= 8; i++)
			hs2.add(i);
		HashSet<Integer> hs3 = new HashSet<Integer>(hs1);
		
		hs3.addAll(hs2);
		System.out.println(hs3);
		
		hs3.removeAll(hs3);
		hs3.addAll(hs1);
		hs3.retainAll(hs2);
		System.out.println(hs3);
		
		hs3.removeAll(hs3);
		hs3.addAll(hs1);
		hs3.removeAll(hs2);
		System.out.println(hs3);
		
		
	}
}
