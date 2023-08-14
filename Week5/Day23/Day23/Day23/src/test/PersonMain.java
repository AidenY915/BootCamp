package test;

public class PersonMain {

	public static void main(String[] args) {
		Person p1 = new Person("ABC", 10);
		Person p2 = null;
		try {
			p2 = p1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		p1.show();
		p2.show();
	}

}
