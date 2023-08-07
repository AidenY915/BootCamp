import java.util.Scanner;
import java.util.Arrays;

class BinarySearch {
	public static int binarySearch(int[] arr, int target) {
		int p = 0, q = arr.length - 1;
		while(p <= q) {
			int pivot = (p+q)/2	;		
			if(arr[pivot] == target) return pivot;
			else if(arr[pivot] < target) {
				p = pivot + 1;
			}
			else if(arr[pivot] > target) {
				q = pivot - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] num = {1, 3, 4, 5, 7, 10, 27, 39, 50, 92};
		Arrays.sort(num);
		Scanner sc = new Scanner(System.in);
		int rslt = binarySearch(num, sc.nextInt());
		sc.close();
		if(rslt == -1) return;
		System.out.println(rslt+", "+num[rslt]);
	}

}