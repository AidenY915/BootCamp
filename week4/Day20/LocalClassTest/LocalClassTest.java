class Outer {
	public int a = 3;
	class Inner {
		int b = a +2;
	}
	
	public void testMethod() {
		a++;
		final int b = 3;
		System.out.println(a);	
		class Local {
			int c = a+2+b;
		}
		Local local = new Local();
		System.out.println(local.c);	

	}
}

public class LocalClassTest {
	public static void main(String[] args){	
		Outer outer1 = new Outer();
		Outer.Inner inner = outer1.new Inner();
		Outer outer2 = new Outer();	
		outer1.testMethod();	
		outer2.testMethod();	
		outer2.testMethod();	
	}
}