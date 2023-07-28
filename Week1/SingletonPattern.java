//싱글톤 -> 유일객체공유

/*
class SimpleNumber
{
	int num=0;
	private static SimpleNumber snInst = new SimpleNumber();
	private SimpleNumber() {}	// 생성자 private
	public void addNum(int n) { num += n; }
	public void showNum() 
	{ 
		System.out.println(num); 
	}
	
	public static SimpleNumber getSimpleNumberInst()
	{
		return snInst;
	}
}
*/

class SimpleNumber
{
	int num=0;
	private static SimpleNumber snInst;	//getSimpleNumberInst()가 접근해야 하기 함. -> static
	private SimpleNumber() {}	// 생성자 private
	public void addNum(int n) { num += n; }
	public void showNum() 
	{ 
		System.out.println(num); 
	}
	
	public static SimpleNumber getSimpleNumberInst()	//객체 생성 또는 호출 함수
	{
		if(snInst == null)		//최초 객체 생성
			snInst = new SimpleNumber;
		return snInst;		//기존 객체 주소 반환
	}
}

class SingletonPattern
{
	public static void main(String[] args)
	{
		SimpleNumber num1 = SimpleNumber.getSimpleNumberInst();	//생성자 대신 wrapper 함수 사용
		num1.addNum(20);

		SimpleNumber num2 = SimpleNumber.getSimpleNumberInst();
		num2.addNum(30);

		num1.showNum();
		num2.showNum();
	}
}