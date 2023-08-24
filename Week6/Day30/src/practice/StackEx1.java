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
		System.out.println("���� : " + back.peek());
	}
	
	
	
	public static void main(String[] args) {
		goURL("1.����Ʈ");
		goURL("2.����");
		goURL("3.���̹�");
		goURL("4.����");

		printStatus();
		// back:[1.����Ʈ, 2.����, 3.���̹�, 4.����]
		// forward:[]
		// ����ȭ���� '4.����' �Դϴ�.		

		goBack();
		System.out.println("= �ڷΰ��� ��ư�� ���� �� =");  
		printStatus();
		// = �ڷΰ��� ��ư�� ���� �� =
		// back:[1.����Ʈ, 2.����, 3.���̹�]
		// forward:[4.����]
		// ����ȭ���� '3.���̹�' �Դϴ�.

		goBack();
		System.out.println("= '�ڷ�' ��ư�� ���� �� =");  
		printStatus();
		// = '�ڷ�' ��ư�� ���� �� =
		// back:[1.����Ʈ, 2.����]
		// forward:[4.����, 3.���̹�]
		// ����ȭ���� '2.����' �Դϴ�.

		goForward();
		System.out.println("= '������' ��ư�� ���� �� =");  
		printStatus();
		// = '������' ��ư�� ���� �� =
		// back:[1.����Ʈ, 2.����, 3.���̹�]
		// forward:[4.����]
		// ����ȭ���� '3.���̹�' �Դϴ�.

		goURL("codechobo.com");
		System.out.println("= ���ο� �ּҷ� �̵� �� =");  
		printStatus();
		// = ���ο� �ּҷ� �̵� �� =
		// back:[1.����Ʈ, 2.����, 3.���̹�, codechobo.com]
		// forward:[]
		// ����ȭ���� 'codechobo.com' �Դϴ�.
	}
	
}