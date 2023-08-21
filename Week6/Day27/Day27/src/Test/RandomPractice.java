package Test;

import java.util.Random;

public class RandomPractice{
	public static void main(String[] args) {
		Random rand = new Random(System.currentTimeMillis());
		rand.setSeed(System.currentTimeMillis());
		System.out.println(rand.nextDouble());
	}
	
	
}
