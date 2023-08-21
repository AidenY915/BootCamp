package Test;

class AAA1 {
	public static <T> void print(T a) {
		System.out.println(a);
	}
	
}
class AAA2 {
	public static <T, U> void print(T a, U b) {
		System.out.println(a);
		System.out.println(b);
	}
	
}

class MyClass
{
	public <T> void simpleMethod(T param)
	{
//		param.showData();		//T는 모든 클래스를 받아야 하기 때문에, 사실상 Object를 의미한다. 그런데 showData()는 Object의 메소드가 아니기 때문에 에러가 발생한다.
		System.out.println(param);
	}
}

public class Test {

	public static void main(String[] args) {
		AAA2.print("aaa",5);
	}

}
