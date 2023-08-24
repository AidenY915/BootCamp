package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



public class QueueQ1 {

	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		boolean run = true;
		while(run) {
			String str = br.readLine();
			if(q.size()==MAX_SIZE)
				q.poll();
			q.offer(str);
			if(str.equalsIgnoreCase("q")) {
				run = false;
				break;
			}
			else if(str.equalsIgnoreCase("help"))
				System.out.println(" help - 도움말을 보여줍니다.\r\n"
						+ " q 또는 Q - 프로그램을 종료합니다.\r\n"
						+ " history - 최근에 입력한 명령어를 5개 보여줍니다.");
			else if(str.equalsIgnoreCase("history")) {
				System.out.println(q);
			}
			
		}
		br.close();
		
	}
}
