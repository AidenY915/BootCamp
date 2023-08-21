package Test;

interface SimpleInterface
{
	public void showYourName();
}

class UpperClass
{
	public void showYourAncestor()
	{
		System.out.println("UpperClass");
	}
}

class AAA extends UpperClass
{
}

class BBB implements SimpleInterface
{
	public void showYourName() 
	{
		System.out.println("Class BBB");
	}
}

class BoundedTypeParam
{	
	public static <T extends UpperClass> void showInstanceAncestor(T param)
	{
		param.showYourAncestor();
	}
	
	public static <T extends SimpleInterface> void showInstanceName(T param)
	{
		param.showYourName();
	}
	
	public static void main(String[] args)
	{
		AAA aaa=new AAA();
		BBB bbb=new BBB();
		
		showInstanceAncestor(aaa);
		showInstanceName(bbb);
	}
}