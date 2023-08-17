
public class Q9_4 {

	static void printGraph(int[] dataArr, char ch) {
		StringBuilder sb = new StringBuilder(20);
		for(int e : dataArr) {
			sb.delete(0, sb.length());
			for(int i = 0; i < e; i++) {
				sb.append(ch);
			}
			System.out.println(sb.toString() + e);
		}
	}
	public static void main(String[] args) {
		printGraph(new int[]{3,7,1,4},'*');
	}
}