package morningTest;

import java.util.function.BiFunction;

class Box<T, U>{
	private T id;
	private U con;
	public Box(T i, U c) {
		id = i;
		con = c;
	}
	public void showIt() {
		System.out.println("ID: " + id + ", " + "Contents: " + con);
	}
}

public class BoxMaker {

	public static void main(String[] args) {
		// 채워 넣어야 할 문장, 참조변수 bf의 선언
		BiFunction<Integer,String, Box<Integer,String>> bf = Box::new; 
		Box<Integer, String> b1 = bf.apply(1, "Toy");	// 1과 "Toy" 저장된 상자 반환
		Box<Integer, String> b2 = bf.apply(2, "Robot"); // 2와 "Robot" 저장된 상자 반환
		b1.showIt();
		b2.showIt();
	}
}	// BiFunction<T, U, R> R apply(T t, U u)