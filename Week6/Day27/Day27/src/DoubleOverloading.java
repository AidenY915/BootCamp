abstract class AAA{
}

interface BBB{
}

class CCC extends AAA implements BBB {
}



public class DoubleOverloading {

	private static void print(AAA a) {
		System.out.println("AAA");
	}
	private static void print(BBB b) {
		System.out.println("BBB");
	}
	public static void main(String[] args) {
		CCC c = new CCC();
		//print(c);		//ambigous
	}

}
