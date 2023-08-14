package practice;

class Point implements Cloneable
{
	private int xPos;
	private int yPos;
	
	public Point(int x, int y)
	{
		xPos=x;
		yPos=y;
	}
	public void showPosition()
	{
		System.out.printf("[%d, %d]", xPos, yPos);
	}
	public void changePos(int x, int y)
	{
		xPos=x;
		yPos=y;
	}
	public Point clone() throws CloneNotSupportedException
	{
		return (Point)(super.clone());
	}
}

class Rectangle implements Cloneable
{
	Point upperLeft, lowerRight;
	
	public Rectangle(int x1, int y1, int x2, int y2)
	{
		upperLeft=new Point(x1, y1);
		lowerRight=new Point(x2, y2);
	}
	public void showPosition()
	{
		System.out.println("직사각형 위치정보...");
		System.out.print("좌 상단: ");
		upperLeft.showPosition();
		System.out.println("");	
		System.out.print("우 하단: ");
		lowerRight.showPosition();	
		System.out.println("\n");
	}
	public void changePos(int x1, int y1, int x2, int y2)
	{
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
	}
	public Rectangle clone() throws CloneNotSupportedException
	{
		var newClone = (Rectangle)super.clone();	//클래스 변수 수준 깊은 복사 + 멤버 참조 필드 수준 얕은 복사
		newClone.upperLeft = upperLeft.clone();		//멤버 수준 깊은 복사
		newClone.lowerRight = lowerRight.clone();
		return newClone;
	}
}

class ShallowCopyToDeepCopy
{	
	public static void main(String[] args)
	{
		Rectangle org=new Rectangle(1, 1, 9, 9);
		Rectangle cpy;
		
		try
		{
			cpy=(Rectangle)org.clone();
			org.changePos(2, 2, 7, 7);
			org.showPosition();		
			cpy.showPosition();		
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}
}
