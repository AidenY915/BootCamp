package ObjectIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Point implements Serializable {
	private int xPos;
	private int yPos;
	public Point(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	public void showPointInfo() {
		System.out.printf("[%d, %d] \n", xPos, yPos);
	}
}

class Circle implements Serializable
{
	Point p;
	double rad;
	
	public Circle(int x, int y, double r)
	{
		p = new Point(x,y);
		rad=r;
	}
	public void showCircleInfo()
	{
		System.out.println("rad: "+rad);
		p.showPointInfo();
	}
}

public class Q1 {

	public static void main(String[] args) {
		String fileName = "src\\ObjectIO\\Q1.ser";
		Circle c1 = new Circle(1,2,3);
		String str = "abc";
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(c1);
			oos.writeObject(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			try {
				((Circle)ois.readObject()).showCircleInfo();
				System.out.println(ois.readObject());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
