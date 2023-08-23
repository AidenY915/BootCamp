package test;

import java.util.ArrayList;

public class Q1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(100);
		list.ensureCapacity(500);
		for(int i = 0; i < 500; i++) {
			list.add(i);
		}
		list.ensureCapacity(list.size()*2);
		System.out.println(list);
	}

}
