import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.awt.Point;
class Main{
	public static void mazeRun(byte[][] map, Point p) {		//비재귀형 DFS 만들어보기
		Stack<Point> stack = new Stack<Point>();
		cnt = 0;
		while(y < map.length && x < map[y].length) {
			if(x == map[y].length - 1 && y == map.length - 1)
				cnt++;
			while(x < map[y].length - 1 && map[y][x+1] == 1) {
				x++;
			}
			
		}

	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		byte[][] map = new byte[n][m];
		int[][] distance = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		n--;
		m--;
		for(int i = 0; i < arr.length; i++) {
			String line = br.readLine();
			for(int j = 0; j < arr[i].length; j++) {
				map[i][j] = Byte.parseByte(line.charAt(j));
			}
		}
	}
}