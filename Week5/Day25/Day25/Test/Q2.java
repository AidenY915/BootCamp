import java.util.Arrays;

public class Q2 {
	
	public static void main(String[] args) {
		char[] dest = new char[10];
		char[] src = {'1', '2', '3', '4'};
		
		Arrays.fill(dest, '0');
		System.arraycopy(src, 0, dest, 0, src.length);
		System.out.println(Arrays.toString(dest));
		
		Arrays.fill(dest, '0');
		System.arraycopy(src, 0, dest, dest.length - src.length , src.length);
		System.out.println(Arrays.toString(dest));
		
		Arrays.fill(dest, '0');
		System.arraycopy(src, 0, dest, (dest.length - src.length)/2, src.length);
		System.out.println(Arrays.toString(dest));
	}

}
