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
				System.out.println(" help - ������ �����ݴϴ�.\r\n"
						+ " q �Ǵ� Q - ���α׷��� �����մϴ�.\r\n"
						+ " history - �ֱٿ� �Է��� ��ɾ 5�� �����ݴϴ�.");
			else if(str.equalsIgnoreCase("history")) {
				System.out.println(q);
			}
			
		}
		br.close();
		
	}
}
