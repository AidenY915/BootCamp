import java.awt.Point;
import java.util.Arrays;

public class ArraysCopyOfTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point[] pArr = new Point[1];
		pArr[0] = new Point(1,1);
		System.out.println(Arrays.toString(pArr));
		Point[] pArrCpy = Arrays.copyOf(pArr, pArr.length);
		pArrCpy[0].x = 2;
		System.out.println(Arrays.toString(pArr));
	}

}
