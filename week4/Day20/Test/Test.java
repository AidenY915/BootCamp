//Q1 Q2
abstract class A {
	abstract public void methodA();
}

/*
Q4
abstract 클래스를 상속하는 클래스는 추상메소드들을 반드시 구현해야 한다.
abstract class AAA
{
	void methoodOne() { . . . }
	abstract void methodTwo();
}

class BBB extends AAA
{
	void methodThree() { . . . }
	//추가
	@Override
	void methodTwo(){ . . . }
}
*/

/*
//Q5
abstract class IdManager {
	private String name;
	private String id;
	
	public abstract void addPersonalInfo(String name, String perNum);
	public abstract String searchName(String perNum);

}

//Q6
class Main {
	public static void main(String[] args) {
		/*
		A사클래스 im = new A사클래스();
		im.addPersonallInfo("이름", "번호");
		im.searchName("번호");
		*/
	}
}

//Q7
interface는 추상 메소드의 집합으로, 다른 클래스가 구현하여 사용하게끔 한다.
하나의 클래스는 여러 interface를 구현하는 다중 구현이 가능하다.
상수들을 저장하기도 한다.
또한 업캐스팅을 이용하며 여러 종류의 클래스를 하나의 interface로 묶어 일괄적으로 관리할 수도 있다.

Q9 
interface A {public abstract void methodA();}
interface B {public abstract void methodB();}
class C implements A, B {
	public abstract void methodA() {
		System.out.println("A");	
	}
	public abstract void methodB() {
		System.out.println("B");
	}
}

//Q10
interface A {public abstract void methodA();}
interface B extend A{public abstract void methodB();}
class C implements B {
	public abstract void methodA() {
		System.out.println("A");	
	}
	public abstract void methodB() {
		System.out.println("B");
	}
}

Q11. 다음 클래스를 인터페이스를 이용하여 바꿔보시오.
interface Week
{
	public static final int MON=1;
	public static final int TUE=2;
	public static final int WED=3;
	public static final int THU=4;
	public static final int FRI=5;
	public static final int SAT=6;
	public static final int SUN=7;
}

Q16
Inner 클래스란 하나의 클래스 안에서 정의된 클래스이다.
일반적으로 outer 클래스의 객체를 통해서 생성이 가능하지만, static의 경우 outer 클래스의 객체가 없어도 outer클래스의 이름을 통해 객체 생성이 가능하다.
로딩 시점은 outer클래스가 로딩되는 시점이다.
inner 클래스는 outer 클래스의 멤버에 접근(연산 관계성 O)할 수 있으며, static으로 선언된 경우 outer 클래스의 static 변수에만 접근할 수 있다.

class outer  {
	static class inner {

	}
}

Q17
Nested 클래스는 static inner class로 코드 상에는 inner class 처럼 outer class 안에서 정의 되지만 정적으로 선언되기에
outer 클래스와 독립적으로 존재한다. 따라서 outer class의 인스턴스 변수에는 직접 접근할 수 없다.
주로 네임스페이스를 위해 사용된다.

*/





