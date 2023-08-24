package practice;

import java.util.ArrayDeque;

public class StackEx2 {

	public static void main(String[] args) {

		DeqStack<Byte> stack = new DeqStack<>(new ArrayDeque<Byte>(5));

		for (String str : args)
		{
			System.out.print(str);
			int len = str.length();
			for(int i = 0; i < len; i++) {
				if(str.charAt(i) == '(') 
					stack.push((byte)0);
				if(str.charAt(i) == ')')
				{
					if(stack.isEmpty()) {
						System.out.println("��ȣ ����ġ");
						return;
					}
					stack.pop();
				}
			}
			System.out.println();
			if(!stack.isEmpty()) {
				System.out.println("��ȣ ����ġ");
				return;
			}
			System.out.println("��ȣ ��ġ");
		}
	}
}