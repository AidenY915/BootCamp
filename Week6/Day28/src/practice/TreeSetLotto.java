package practice;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetLotto {

	private static <T> void swap(T[] arr, int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	private static void shuffle(Integer[] arr) {
		for(int i = arr.length - 1 ; i >= 0 ; i--) {
			int j = (int)(Math.random()*(arr.length));
			swap(arr, i ,j);
		}
	}
	
	public static void main(String[] args) {
		Integer[] Lotto = new Integer[45];
		Integer[] rslt = new Integer[6];
 		for(int i = 0 ; i < Lotto.length ; i++) 
			Lotto[i] = i + 1;
		shuffle(Lotto);
		System.out.println(Arrays.toString(Lotto));
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i = 0 ; i < 6; i++)
			ts.add(Lotto[i]);
		System.out.println(ts);
		for(int i = 0 ; i < 6; i++)
			rslt[i] = ts.pollFirst();
		System.out.println(Arrays.toString(rslt));
		System.out.println(ts);
		System.out.println(Integer.valueOf(1500).hashCode());
		while(ts.size()<6) {
			ts.add((int)(Math.random()*45)+1);
		}
		System.out.println(ts);
	}

}
