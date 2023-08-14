import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.awt.Point;

class Main{
	public static void mazeRun(byte[][] map, int distance[][]) {		//비재귀형 DFS 만들어보기		//pop한 것만 조회해야함. 들어가면서 보면 안되고.
		Stack<Point> stack = new Stack<Point>();
		stack.add(new Point(0, 0));
		distance[0][0] = 1;
		while(!stack.isEmpty()) {
			Point now = stack.pop();
			int x = now.x;
			int y = now.y;
			if(y < 0 || y >= map.length || x >= map[y].length || x < 0 || map[y][x] == 0) continue;
			int distanceNow = distance[y][x];
			if(x+1 < map[y].length && distance[y][x+1] > distanceNow + 1 ) {
				stack.add(new Point(x+1,y));
				distance[y][x+1] = distanceNow + 1;
			}
			if(y+1 < map.length && distance[y+1][x] > distanceNow + 1) {
				stack.add(new Point(x,y+1));
				distance[y+1][x] = distanceNow + 1;
			}

			if(x-1 >= 0 && distance[y][x-1] > distanceNow + 1) {
				stack.add(new Point(x-1,y));
				distance[y][x-1] = distanceNow + 1;
			}
						
			if(y-1 >= 0 && distance[y-1][x] > distanceNow + 1) {
				stack.add(new Point(x,y-1)); 
				distance[y-1][x] = distanceNow + 1;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		byte[][] map = new byte[n][m];
		int[][] distance = new int[n][m];
		for(int i = 0; i < map.length; i++) {
			String line = br.readLine();
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = (byte)(line.charAt(j)-'0');
				distance[i][j] = 10000;
			}
		}
		mazeRun(map, distance);
		br.close();
		System.out.println(distance[n-1][m-1]);
	}
}