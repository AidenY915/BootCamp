import java.util.function.BiConsumer;

class AAA {
	
	public void method1(AAA a) {
		System.out.println("인스턴스 메소드");
	}
	
	public static void method1(AAA a1, AAA a2) {
		System.out.println("스태틱 메소드");
	}
}


public class MethodRefCollision {

	public static void main(String[] args) {
		BiConsumer<AAA, AAA> bc = AAA::method1;	// 이름 겹침 컴파일 에러

	}

}
