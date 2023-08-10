interface TV
{
	public void onTV();
		
}

interface Computer
{	
	public void dataReceive();
	
}


class ComputerClass implements Computer{
	public void dataReceive()
	{
		System.out.println("영상 데이터 수신 중");
	}	
}

class TVClass implements TV{
	public void onTV()
	{
		System.out.println("영상 출력 중");
	}
	
}

class IPTV implements TV, Computer
{
	TVClass tv =new TVClass();		//HAS-A
	ComputerClass computer = new ComputerClass();
	public void powerOn()
	{
		dataReceive();
		onTV();
	}
	public void dataReceive()		//구현 필
	{
		computer.dataReceive();
	}
	public void onTV()
	{
		tv.onTV();
	}
}

class CompileErrorExample
{	

	public static void main(String[] args)
	{
		IPTV iptv=new IPTV();
		iptv.powerOn();
		
		TV tv=iptv;
		Computer comp=iptv;
	}
}