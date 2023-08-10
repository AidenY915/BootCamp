import java.util.Scanner;

class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		try{
			System.out.println(n/m);
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		sc.close();

	}

}

class Q4{
	public static void main(String[] args) {
		try{
			int[] arr = new int[0];
			arr[0] = 1;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());	
		}
		try{
			int[] arr = new int[-1];
		}catch(NegativeArraySizeException e){
			System.out.println(e.getMessage());	
		}
		try{
			String str = null;
			str = str.substring(0);
		}catch(NullPointerException e){
			System.out.println(e.getMessage());	
		}
		try{
			Object o = new Object();
			String str = (String) o;
		}catch(ClassCastException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Done");
	}

}



class Q7{
	public static void main(String[] args) {
		try{
			int a = 10/0;
		}catch(Exception e){
			System.out.println(e.getMessage());	
			return;
		}finally{
			System.out.println("Done");
		}
		
	}	

}

class Q8 {
	public static void checkAge(int age) throws Exception {
		if(age < 0)
			throw new Exception("나이 이상");
	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		try{
			checkAge(age);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
}

class Q10 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		try{
			if(age < 0)
			throw new Exception("나이 이상");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		sc.close();

	}
}

class Q14 {
	static class WrongNameException extends Exception{
		private String name;
		WrongNameException(String message, String _name){
			super(message);
			name = _name;
		}
		public String getName() {
			return name;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try{
			String name = sc.next();
			if(name.length() < 2) throw new WrongNameException("잘못된 이름", name);
			int age = sc.nextInt();
			if(age < 0)
			throw new Exception("나이 이상");
		}catch(WrongNameException e) {
			System.out.println(e.getMessage()+ ": " + e.getName());
			e.printStackTrace();
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		sc.close();
	}


}