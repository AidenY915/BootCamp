package Stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Box<T>
{
	private T ob;
	public Box(T o) { ob = o; }
	public T get() { return ob; }
}
public class BoxToString {

	public static void main(String[] args) {
		List<Box<String>> ls = Arrays.asList(new Box<>("Robot"), new Box<>("Simple"));
		// 이 위치에 스트림의 생성 및 맵핑 연산을 진행하는 문장 구성
		Stream<String> strStream = ls.stream().map((e) -> e.get());
		strStream.forEach(System.out::println);
	}

}