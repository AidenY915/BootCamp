package syncPractice;

class Increment {
	private int num;

	public Increment(int num) {
		this.num = num;
	}

	public synchronized void increase() { 
		for(int i = 0 ; i < 1000000; i++)
			num++;
	}
	public int getNum() {
		return num;
	}

}

public class Q6Increment {

	public static void main(String[] args) {
		Increment inc = new Increment(0);
		Thread[] threads = new Thread[3];
		for(int i = 0; i < 3; i++) {
			threads[i] = 
					new Thread(()->inc.increase(),"t"+i);
		}
		for(int i = 0; i < 3; i++)
			threads[i].start();
		for(int i = 0; i < 3; i++)
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println(inc.getNum());
	}

}
