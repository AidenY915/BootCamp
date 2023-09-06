package morningTest;

import java.util.Arrays;
import java.util.List;

class Box1<T>
{
	private T ob;
	public Box1(T o) { ob = o; }
	public T get() { return ob; }
}
class BoxToString {

	public static void main(String[] args) {
		List<Box1<String>> ls = Arrays.asList(new Box1<>("Robot"), new Box1<>("Simple"));
		ls.stream().map(Box1<String>::get).forEach(e -> System.out.println(e));
		// 이 위치에 스트림의 생성 및 맵핑 연산을 진행하는 문장 구성
	}

}