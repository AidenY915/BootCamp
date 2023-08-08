interface TV
{
	abstract public void onTV();
}

class TvImpl {
	public void onTV() {
		System.out.println("영상 출력 중");
	}
}

interface Computer
{
	public void dataReceive();
}

class ComputerImpl
{	
	public void dataReceive()
	{
		System.out.println("영상 데이터 수신 중");
	}
}

class IPTV implements TV, Computer	//다중 구현 + 멤버 -> has a 관계로 다중 상속처럼
{
	ComputerImpl comp=new ComputerImpl();
	TvImpl tv = new TvImpl();
	@Override
	public void onTV()
	{
		tv.onTV();
	}
	@Override
	public void dataReceive()
	{
		comp.dataReceive();
	}
	public void powerOn()
	{
		dataReceive();
		onTV();
	}
}

class MultiInheriAlternative
{	

	public static void main(String[] args)
	{
		IPTV iptv=new IPTV();
		iptv.powerOn();
		
		TV tv=iptv;
		Computer comp=iptv;
	}
}