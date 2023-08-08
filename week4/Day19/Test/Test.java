import java.util.Scanner;
import java.util.Arrays;
class Q01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int len = String.valueOf(n).length();
		System.out.println(String.valueOf(n).length());
		
		int[] arr = new int[len];
		for(int i = len - 1; i >=0 ; i--) {
			arr[i] = n%10;
			n/=10;
		}
		System.out.println(Arrays.toString(arr));
	}

}

class Q2 {
	public static int binarySearch(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		while(start <= end) {
			int mid= (start+end)/2;
			if(arr[mid] == target) return mid;
			else if(arr[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		return -1;

	}
	public static void main(String[] args) {
		int[] num = {1, 3, 4, 5, 7, 10, 27, 39, 50, 92};
		int a1 = binarySearch(num, 5);
		int a2 = binarySearch(num, 9);
		System.out.println(a1 >= 0 ? num[a1] : a1);
		System.out.println(a2 >= 0 ? num[a2] : a2);
	}
	
}

/*
Q3 객체를 생성하지 못하게 만드는 클래스는? 추상 클래스 abstract class
Q4 메서도 오버라이딩을 할 때, 애너테이션 주는 방법은? 그 예시를 드시오.
	@Override
	public String toString(){}
Q5 다음 AAA 클래스에 sayHello 메소드의 사용을 더이상 권장하고 싶지 않을 때, 어떻게 해야하나?
@Deprecated
class AAA
{

	public void sayHello()
	{
		System.out.println("Hello");
	}
}
6. 컴파일 경고를 사용하지 않도록 설정해주는 애너테이션은?
그리고 다음 소스코드에서 그 사용예시를 보이시오.

class AAA
{
	@Deprecated
	public void sayHello()
	{
		System.out.println("Hello");
	}
}

class MainClass
{
	@SuppressWarnings("deprecation") //해당 클래스를 호출하거나 사용하는 클래스 영역에 사용해야함 

	public static void main(String[] args)
	{
		AAA aaa = new AAA();
		aaa.sayHello();
	}
}

7. 추상 메서드를 만들고 그 예시를 드시오. 그리고 그 추상 메소드가 있는 클래스를 상속 받으면 어떻게 해야 하나?
 abstract class AAA {
	int n;
	abstract public void methodAaa();
}

abstract class BBB extends AAA{
	@Override
	public void methodAaa() { System.out.println("AAA"); }
}

8. 인터페이스에 대해서 설명하시오.
 추상메소드의 집합이며, implements 키워드를 통해 상속받을 수 있다.
멤버가 전부 추상메소드 밖에 없기 때문에, 자신의 모든 멤버를 자식 클래스에서 오버라이딩해야지만 사용할 수 있다.
클래스와는 다르게 다중상속이 가능하며, 업캐스팅을 통해 자식 객체를 자신의 참조 변수에 연결 할 수 있다.

9. 인터페이스를 구현하는 예시를 드시오.
abstract interface AAA {
	int n;
	abstract public void methodAaa();
}

abstract class BBB implements AAA{
	@Override
	public void methodAaa() { System.out.println("AAA"); }
}

*/


