/*
1. 다음 소스코드의 실행결과가 주석과 같이 나올 수 있도록 add라는 메소드를 정의하시오.
가변인수를 사용하는 방식과 메소드 오버로딩을 사용하는 방식 두가지로 작성하시오.
*/
class Test1
{
	public static int add(int... args){
		int rslt  = 0;
		for(int e : args) rslt += e;
		return rslt;
	}
	public static int add(int a){
		return a;
	}
	public static int add(int a, int b){
		return a+b;
	}
	

	public static void main(String[] args)
	{
		System.out.println(add(5));	// 5
		System.out.println(add(5, 10));		// 15
		System.out.println(add(5, 10, 15));	// 30
	}
}

//2. 다음의 출력결과를 쓰시오.(Document 참고)

class Test2 {

	public static void main(String[] args) {
		String str1 = "ABC";
		String str2 = "abc";
		
		System.out.println(str1.equals(str2));	
		System.out.println(str1.equalsIgnoreCase(str2));	
		
		System.out.println(str1.compareTo(str2));	
		System.out.println(str1.compareToIgnoreCase(str2));
	}
}
/*
false
true
'A'-'a'
0
*/


/*3. import static 예시 작성
import statc java.util.Arrays.sort;
	
	sort(arr);
*/