interface UpperCaseMarkable {
}

class ClassPrinter 
{
	public static void print(Object x) {
		String str = x.toString();
		if(x instanceof UpperCaseMarkable)
			str = str.toUpperCase();
		System.out.println(str);
	}
}

class Point
{
	private int xPos, yPos;
	
	Point(int x, int y)
	{
		xPos=x;
		yPos=y;
	}
	
	public String toString()
	{
		String posInfo="[x:"+xPos + ", y:"+yPos+"]";
		return posInfo;
	}
}

class UpperCasePoint extends Point implements UpperCaseMarkable{
	UpperCasePoint(int x, int y){
		super(x,y);
	}
}

class ImplObjectPrintln
{
	public static void main(String[] args)
	{
		Point pos1=new Point(1, 2);
		Point pos2=new Point(5, 9);
		
		ClassPrinter.print(pos1);
		ClassPrinter.print(pos2);

		UpperCasePoint pos3=new UpperCasePoint(1, 2);
		UpperCasePoint pos4=new UpperCasePoint(5, 9);

		ClassPrinter.print(pos3);
		ClassPrinter.print(pos4);
	}
}