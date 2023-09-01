
public class ThreadQ1 {

	public static void main(String[] args) {
		Thread t1 = new Thread("t1"){
			public void run() {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int i = 0; i < 100; i++) {
					System.out.println(getName());		//private은 자식조차 조회할 수 없기 때문.
					
				}
			}
		};

		Thread t2 = new Thread(()->{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		}, "t2");
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);

		t2.start();
		t1.start();
	}

}
