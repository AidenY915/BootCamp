import java.util.function.BiConsumer;

class BBB1 {
	
}

class AAA1 {
	
	public void method1(BBB1 a) {
		System.out.println("인스턴스 메소드");
	}
	
	public static void method1(AAA1 a1, BBB1 a2) {
		System.out.println("스태틱 메소드");
	}
}


public class MethodRefDifferentType {

	public static void main(String[] args) {
		BiConsumer<AAA1, BBB1> bc = AAA1::method1;	// 이름 겹침 컴파일 에러

	}

}
