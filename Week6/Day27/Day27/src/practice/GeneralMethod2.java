package practice;

public class GeneralMethod2 {

	private static <T> void method(T a) {	//Object로 오버로딩된 것
	//	T a = new T(); 사실상 T는 Object
		System.out.println(a + "Generic");
	}
	private static void method(String a) {
		//	T a = new T(); 사실상 T는 Object
			System.out.println(a);
		}
	
	public static void main(String[] args) {
		method("abc");
		method(1);
	}

}
