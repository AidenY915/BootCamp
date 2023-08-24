package practice;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AsListTest {

	public static void main(String[] args) {
		List<Point> list1 = Arrays.asList(new Point(1,2));
		List<Point> list2 = new ArrayList<>(list1);
		System.out.println(list1);
		System.out.println(list2);
		
		list2.get(0).x=100;
		
		System.out.println(list2);		
		System.out.println(list1);
	}

}
