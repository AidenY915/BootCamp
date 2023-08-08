class MethodOverloading
{
	
	static int add(int... args) {		//가변인자는 맨 끝에 선언.
		int rslt = 0;
		for(int e : args) 		//내부적으로 배열 객체를 생성해서 적재.
			rslt += e;
		System.out.println("가변인자");
		return rslt;
	}
	
	static int add(int a) {	//같은 경우 가변인자가 아닌 오버로딩된 메소드가 호출됨.
		return a;
	}
	static int add(int a, int b) {
		return a+b;
	}
	static int add(int a, int b, int c) {
		return a+b+c;
	}
	
	public static void main(String[] args)
	{
		System.out.println(add(5));	// 5
		System.out.println(add(5, 10));		// 15
		System.out.println(add(5, 10, 15));	// 30
		System.out.println(add(5, 10, 15, 0));	// 30
	}
}