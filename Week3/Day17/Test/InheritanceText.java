/*
class AA{}

class BBB extends AAA{}

2. 부모 생성자 호출

3. 부모의 메소드와 반환형 메소드 시그니쳐(이름 + 매개변수)가 모두 같은 자식 메소드를 만드는 것이다.
	업캐스팅을 해도 해당 메소드를 호출 시에는 오버라이딩된 자식 메소드가 호출된다.
*/

class Human{
	public static //부모 자식 스태틱 메모리 공유?
	protected void work(){
		System.out.println("sleep");
	}
	Human(){
		System.out.println("born human");
	}	
	protected int n = 4;		

}
class Programmer extends Human {
	Programmer() {
		super.work();
		System.out.println("change job to programmer");
	}
	public void work() {
		
		System.out.println("program");
			
	}
	public void printN() {
		System.out.println("부모 N " + super.n);
		System.out.println("자식 N " + n);
	} 
	private int n = 3;

}

class Main {
	public static void main(String[] args) {
		Programmer p  = new Programmer();
		p.work();
		p.printN();
	}

}