package morningTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Point {
	int xPos;
	int yPos;
	public Point(int xPos, int yPos) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
	}
	public void showPointInf() {
		System.out.printf("[%d, %d] \n", xPos, yPos);
	}
}

class Circle implements Serializable
{
	
	transient Point p;
	double rad;
	{
		System.out.println("생성자");
	}
	public Circle() {
		p = new Point(0,0);
		System.out.println("생성자");
	}
	
	public Circle(int x, int y, double r)
	{
		p = new Point(x,y);
		rad=r;
	}
	public void showCircleInfo()
	{
		if(p!=null)
			p.showPointInf();
		System.out.println("rad: "+rad);
	}
}

public class ObjectIOQ1 {

	public static void main(String[] args) {
		String fileName = "src\\morningTest\\ObjectQ1.ser";
		Circle c1 = new Circle(1, 1, 2.4);
		Circle c2 = new Circle(2, 2, 4.8);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			oos.writeObject(c1);
			oos.writeObject(c2);
			oos.writeObject(fileName);
			
			try {
				((Circle)ois.readObject()).showCircleInfo();
				((Circle)ois.readObject()).showCircleInfo();
				System.out.println(ois.readObject());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


