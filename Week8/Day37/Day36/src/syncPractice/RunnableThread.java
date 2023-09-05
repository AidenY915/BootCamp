package syncPractice;

class Sum
{ 
	int num;
	public Sum() { num=0; }
	public void addNum(int n) { num+=n; }
	public int getNum() { return num; }
}

class AdderThread extends Thread
{	
	int start, end;
	
	Sum sum;
	
	public AdderThread(int s, int e)
	{
		start=s;
		end=e;
		sum = new Sum();
	}
	public void run()
	{
		for(int i=start; i<=end; i++)
			sum.addNum(i);
	}
	public int getNum() {
		return sum.getNum();
	}
}

class RunnableThread
{
	public static void main(String[] args)
	{
		AdderThread at1=new AdderThread(1, 50);
		AdderThread at2=new AdderThread(51, 100);
		at1.start();
		at2.start();
		
		try
		{
			at1.join();
			at2.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("1~100까지의 합: "+(at1.getNum()+at2.getNum()));
	}
}
