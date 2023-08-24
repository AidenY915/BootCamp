package practice;

import java.util.Deque;
import java.util.LinkedList;

class DeqStack<T> {
	Deque<T> deq;
	public boolean push(T e) { 
		return deq.offerLast(e);
	}
	public T pop() { 
		return deq.pollLast();
	}
	public T peek() { 
		return deq.peekLast();
	}
	public boolean isEmpty() {
		return deq.isEmpty();
	}
	public DeqStack(Deque<T> deq) {
		this.deq = deq;
	}
	public void clear() {
		deq.clear();
	}
	@Override
	public String toString() {
		return deq.toString();
	}
}

public class StackEx1 {
	public static DeqStack<String> back  = new DeqStack<String>(new LinkedList<String>());
	public static DeqStack<String> forward = new DeqStack<String>(new LinkedList<String>());  
	public static void goURL(String url) {
		back.push(url);
		forward.clear();
	}
	
	public static void goBack() {
		String now;
		now = back.pop();
		forward.push(now);
	}
	public static void goForward() {
		String now;
		now = forward.pop();
		back.push(now);
	}
	
	public static void printStatus() {
		System.out.println(back + "\n" + forward);
		System.out.println("현재 : " + back.peek());
	}
	
	
	
	public static void main(String[] args) {
		goURL("1.네이트");
		goURL("2.야후");
		goURL("3.네이버");
		goURL("4.다음");

		printStatus();
		// back:[1.네이트, 2.야후, 3.네이버, 4.다음]
		// forward:[]
		// 현재화면은 '4.다음' 입니다.		

		goBack();
		System.out.println("= 뒤로가기 버튼을 누른 후 =");  
		printStatus();
		// = 뒤로가기 버튼을 누른 후 =
		// back:[1.네이트, 2.야후, 3.네이버]
		// forward:[4.다음]
		// 현재화면은 '3.네이버' 입니다.

		goBack();
		System.out.println("= '뒤로' 버튼을 누른 후 =");  
		printStatus();
		// = '뒤로' 버튼을 누른 후 =
		// back:[1.네이트, 2.야후]
		// forward:[4.다음, 3.네이버]
		// 현재화면은 '2.야후' 입니다.

		goForward();
		System.out.println("= '앞으로' 버튼을 누른 후 =");  
		printStatus();
		// = '앞으로' 버튼을 누른 후 =
		// back:[1.네이트, 2.야후, 3.네이버]
		// forward:[4.다음]
		// 현재화면은 '3.네이버' 입니다.

		goURL("codechobo.com");
		System.out.println("= 새로운 주소로 이동 후 =");  
		printStatus();
		// = 새로운 주소로 이동 후 =
		// back:[1.네이트, 2.야후, 3.네이버, codechobo.com]
		// forward:[]
		// 현재화면은 'codechobo.com' 입니다.
	}
	
}