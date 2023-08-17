
public class Q9_12 {
	private static int getRand(int from, int to) {
			int min = Math.min(from,to);
			int gap = Math.abs(to-from);
			return (int)(Math.random()*(gap+1))+min;
			
	}
	
	public static void main(String[] args)
	{
		for(int i=0; i< 20; i++)
			System.out.print(getRand(1,-3)+",");
	}
}
