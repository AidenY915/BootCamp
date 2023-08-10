import java.util.Scanner;
class Q1{
	public static void main(String[] args) {
		try{
			System.out.println(10/0);
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}

class Q4_7 {
	public static void main(String[] args) {
		try{
			System.out.println(1);
			int[] arr = new int[-1];
			
		}
		catch(NegativeArraySizeException e) {
			System.out.println(2);
			System.out.println(e.getMessage() + "음수 크기");
			System.out.println(3);
			if(e!=null)
				return;
			System.out.println(5);
		}
		finally {	//finally는 try문에 입장하면 무조건 돌음. catch 문에 return 이 있어도 딜레이 시키고 자기가 돌고 리턴시킴.
			System.out.println(4);
			System.out.println("finally 도착!");
		}	
	}
}


class Q8 {
	/*static class AgeException extends Exception {
		AgeException(){super("나이X");}
	}*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
			int n = sc.nextInt();
			if(n<0)
				throw new Exception("나이X");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}	
}

class Q14 {
	static class ShortNameException extends Exception{
		ShortNameException(){super("이름 짧음.");}
		private String name;
		public void setName(String _name) {name=_name;}
		public void printName() {System.out.println(name);}
	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
			int age = sc.nextInt();
			String name = sc.next();
			System.out.println(name.length());
			if(name.length() < 2) {
				var e = new ShortNameException();
				e.setName(name);
				throw e;
			}
		}catch(ShortNameException e) {
			System.out.println(e.getMessage());
			e.printName();
			e.printStackTrace();
		}
		sc.close();
	}	
	
}


