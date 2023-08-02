class SutdaCard {
	private int num;
	private boolean isKwang;
	
	SutdaCard() {
		num = 1;
		isKwang = true;
	}
	SutdaCard(int _num, boolean _isKwang) {
		num = _num;
		isKwang = _isKwang;
	}
	public String info() {
		return "" + num + (isKwang ? "K" : "");
	}
}

class Q2 {
	public static void main(String args[]) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		System.out.println(card1.info());
		System.out.println(card2.info());
	}
}


class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	Student(){}
	Student(String _name, int _ban, int _no, int _kor, int _eng, int _math) {
		name = _name;
		ban = _ban;
		no = _no;
		kor = _kor;
		eng = _eng;
		math = _math;
	}

	public int getTotal() {
		return kor + eng + math;
	}
	public double getAverage() {
		return Math.round(getTotal() / 3.0 * 10) / 10.0;
	}

	public String info() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math;
	}
}

class Q4 {
	public static void main(String args[]) {
		Student s = new Student();
		s.name = "홍길동"; 
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		System.out.println("이름 :"+s.name); 
		System.out.println("총점 :"+s.getTotal()); 
		System.out.println("평균 :"+s.getAverage()); 
	}
}


class Q5 {
	public static void main(String args[]) {
		Student s = new Student("홍길동",1,1,100,60,76); 
		System.out.println(s.info());
	}
}


class Q6 {
	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt((x1-x) * (x1-x) + (y1-y) * (y1-y));
	}

	public static void main(String args[]) {
		System.out.println(getDistance(1,1,2,2));
	}
}

class MyPoint {
	int x;
	int y;
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	double getDistance(int x1, int y1) {
		return Math.sqrt((x1-x) * (x1-x) + (y1-y) * (y1-y));
	}
}

class Q7 {
	public static void main(String args[]) {
		MyPoint p = new MyPoint(1,1);
		// p (2,2) . 와 의 거리를 구한다
		System.out.println(p.getDistance(2,2));
	}
}

/*
Q8
클래스변수 : width height
인스턴스 변수 : kind num
지역 변수 k n card args[]

Q9 weapon armor 모든 병사의 공격력 방어력이 같아야하기 때문
	weaponUp() armorUp() 각각 스태틱 필드만 접근하기 때문.

Q10 b(?초기화를 하기 위한 것 객체 생성은 new 연산자가 담당), e
Q11 b (스태틱 멤버 안에서 사용 불가)
Q12 c, d
Q13 b, c, d
Q14 c e
Q15 a
Q16 a  / /지역 변수가 클래스(프로그램 종료 시까지)나 인스턴스 변수(가비지 컬렉션 대기)보다 메모리 부담이 적은가? 스택에 정적할당하고, 삭제되서?
	e   - 스택영역에 생성되며, 가비지 컬렉션과 상관없음
Q17 b 
Q18 	라인 A  스태틱 변수가 먼저 초기화 되는데, 생성되지도 않은 인스턴스 변수에 접근
	라인 B static method에서 인스턴스 변수 접근
	라인 D도 마찬가지로 스태틱 메소드가 인스턴스 메소드에 접근
Q19 ABC123
	After change: ABC123	//주소를 보냈는데 해당 주소를 담은 변수에 새로운 주소를 대입한 것이 끝이기 때문 (new는 객체생성 -> 새로운 주소 대입)
*/

class Q20
{
	static int[] shuffle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int j = (int)(Math.random()*(arr.length-i)) + i;
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		return arr;
	}
	public static void main(String[] args)
	{
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}

class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	void turnOnOff() {
		isPowerOn = !isPowerOn;		
		// (1) isPowerOn true false , false true . 의 값이 면 로 면 로 바꾼다
	}
	void volumeUp() {
		volume = volume < MAX_VOLUME ? volume + 1 : volume; 
		// (2) volume MAX_VOLUME 1 . 의 값이 보다 작을 때만 값을 증가시킨다
	}
	void volumeDown() {
		volume = volume > MIN_VOLUME ? volume - 1 : volume; 
		// (3) volume MIN_VOLUME 1 . 의 값이 보다 클 때만 값을 감소시킨다
	}
	void channelUp() {
		channel = channel < MAX_CHANNEL ? channel + 1 : MIN_CHANNEL; 
		// (4) channel 1 . 의 값을 증가시킨다
		// channel MAX_CHANNEL , channel MIN_CHANNEL . 만일 이 이면 의 값을 로 바꾼다
	}
	void channelDown() {
		channel = channel > MIN_CHANNEL ? channel - 1 : MAX_CHANNEL;
		// (5) channel 1 . 의 값을 감소시킨다
		// channel MIN_CHANNEL , channel MAX_CHANNEL . 만일 이 이면 의 값을 로 바꾼다
	}
} // class MyTv


class Q21{ 
	public static void main(String args[]) {
		MyTv t = new MyTv();
		t.channel = 100;
		t.volume = 0;
		System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
		t.channelDown();
		t.volumeDown();
		System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
	}

}

class Q22 {
	public static boolean isNumber(String str) {
		for(int i = 0 ; i < str.length(); i++)
			if(str.charAt(i) < '0' || str.charAt(i) > '9')
				return false;
		return true;
	}
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+" 는 숫자입니까	? "+isNumber(str));
		str = "1234o";
		System.out.println(str+" 는 숫자입니까	? "+isNumber(str)); 
	}
}

class Q23 {
	private static int max(int[] arr) {
		int rslt = -999999;
		if(arr == null || arr.length < 1) return rslt;
		rslt = arr[0];
		for(int i = 1; i < arr.length; i++)
			rslt = rslt < arr[i] ? arr[i] : rslt;
		return rslt;
	}
	public static void main(String[] args){
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값 :"+max(data));
		System.out.println("최대값 :"+max(null)); 
		System.out.println("최대값 :"+max(new int[]{})); //   크기가 0인 배열
	}
}

class Q24 {
	private static int abs(int value) {
		return value < 0 ? -value : value;
	}
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value+"의 절대값 :"+abs(value));
		value = -10;
		System.out.println(value+"의 절대값 :"+abs(value));
	}
}

