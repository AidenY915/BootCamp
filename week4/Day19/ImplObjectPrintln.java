class ClassPrinter 
{
	public static void print(Object x) {
		String str = x.toString();
		if(x instanceof UpperCasePrintable)
			str = str.toUpperCase();
		System.out.println(str);
	}
}

interface UpperCasePrintable {
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
		String posInfo="[x pos:"+xPos + ", y pos:"+yPos+"]";
		return posInfo;
	}
}

class Point2 extends Point implements UpperCasePrintable
{
	Point2(int x, int y) {super(x,y);} 
}

class ImplObjectPrintln
{
	public static void main(String[] args)
	{
		Point pos1=new Point(1, 2);
		Point pos2=new Point(5, 9);
		
		ClassPrinter.print(pos1);
		ClassPrinter.print(pos2);

		Point2 pos3=new Point2(1, 2);
		Point2 pos4=new Point2(5, 9);
		
		ClassPrinter.print(pos3);
		ClassPrinter.print(pos4);
	}
}