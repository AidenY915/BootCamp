package practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class SearchingNumber {

	private static String[] phoneNumArr = {
			"012-3456-7890",
			"099-2456-7980",
			"088-2346-9870",
			"013-3456-7890"
	};
	
	public static String[] searchReturnidx(String word) {
		word=word.replaceAll("-", "");
		word=word.replaceAll(" ", "");
		Vector<String> numsVec = new Vector<String>(4); 
		for(int i = 0; i < phoneNumArr.length; i++) {
			String target = phoneNumArr[i];
			target = target.replaceAll("-", "");
			target = target.replaceAll(" ", "");
			if(target.contains(word))
				numsVec.add(phoneNumArr[i]);
		}
		String[] nums = new String[numsVec.size()];
		for(int i = 0 ;i < nums.length; i++) {
			nums[i] = numsVec.get(i);
		}
		return nums;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] nums = searchReturnidx(sc.nextLine());
		sc.close();
		
		if(nums == null)
			return;
		System.out.println(Arrays.toString(nums));

	}

}
