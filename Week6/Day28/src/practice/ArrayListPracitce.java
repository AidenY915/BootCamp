package practice;

import java.util.ArrayList;

public class ArrayListPracitce {

	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.ensureCapacity(500);
		intList.ensureCapacity(intList.size()*2);
	}

}
