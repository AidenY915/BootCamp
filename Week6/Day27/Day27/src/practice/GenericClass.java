package practice;

class C1<T> {
	T m;
	@Override
	public String toString() {
		return m + " C1";
	}
	public void print() {
		
	}
}

class C2<T> extends C1<T> {
	@Override
	public String toString() {
		return m + " C2";
	}
}

public class GenericClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
