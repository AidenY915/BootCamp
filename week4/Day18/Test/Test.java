//01
class Car	// 기본 연료 자동차
{
	private int gasolineGauge;
	Car(int _gasolineGauge){gasolineGauge = _gasolineGauge;}
	public void showCurrentGauge()
	{
		System.out.println("잔여 가솔린 : " + gasolineGauge);
	}
}

class HybridCar extends Car	// 하이브리드 자동차
{
	private int electricGauge;
	HybridCar(int _gasolineGauge, int _electricGauge) {
		super(_gasolineGauge);
		electricGauge = _electricGauge;
	}
	public void showCurrentGauge()
	{
		super.showCurrentGauge();
		System.out.println("잔여 전기량 : " + electricGauge);
	}
}

class HybridWaterCar extends HybridCar		// 하이브리드 워터카
{
	private int waterGauge;
	HybridWaterCar(int _gasolineGauge, int _electricGauge, int _waterGauge) {
		super(_gasolineGauge, _electricGauge);
		waterGauge = _waterGauge;
	}
	public void showCurrentGauge()
	{
		super.showCurrentGauge();
		System.out.println("잔여 워터량 : " + waterGauge);
	}
}

class Q1 {
	public static void main(String[] args) {
		HybridWaterCar hwc = new HybridWaterCar(1,2,3);
		hwc.showCurrentGauge();
	}

}

//Q2
class Box
{
	public void wrap(){System.out.println("simple wrap");}
}

class PaperBox extends Box
{
	public void wrap() {System.out.println("paper wrap");}
}

class GoldPaperBox extends PaperBox
{
	public void wrap() {System.out.println("gold wrap");}
}

class Q2
{
	public static void wrapBox(Box box){
		box.wrap();
	}
	
	public static void main(String[] args)
	{
		Box box1=new Box();
		PaperBox box2=new PaperBox();
		GoldPaperBox box3=new GoldPaperBox();
		
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
	}
}


/*
Q4
1. 객체를 생성하지 못하게 만드는 클래스는? 추상 클래스
2. 추상 메서드를 만들고 그 예시를 드시오. 그리고 그 추상 메소드가 있는 클래스를 상속 받으면 어떻게 해야 하나?
	abstract class AAA {
		abstract protected void methodA();
	}
	class BBB extends AAA{
		public void methodA() {System.out.println("methodA")};	
	}

	추상클래스에 속한 추상 메소드를 모두 구현해야함.
3. 모든 클래스들의 최상위 클래스는? Object
4. System.out.println에 참조변수를 넣으면 어떻게 되나? toString()이 호출됨.

*/

class Tmp {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("aa");
		String a = "123" + sb;
		System.out.println(a);
	}
}