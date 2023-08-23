package test;

import java.util.Set;
import java.util.TreeSet;

public class Q4 {
	public static void main(String[] args) {
		Set<Integer> ts = new TreeSet<>();
		while(ts.size()<6) {
			ts.add((int)(Math.random()*45)+1);
		}
		System.out.println(ts);
	}
	
}
