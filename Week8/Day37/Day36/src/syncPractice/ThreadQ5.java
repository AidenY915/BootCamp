package syncPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IntSum {
	private int sum = 0;
	boolean isRenewed = true;
	public int getSum() { 
		if (!isRenewed) {
			synchronized(this) {
				try {
					wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		isRenewed = false;
		int rslt = sum;
		notify();
		return rslt;
	}
	public void setSum(int n) { 
		if(isRenewed) {
			synchronized(this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		sum += n;
		isRenewed = true;
		notify();
	}
}



public class ThreadQ5 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = null;
		try {
			inputs = br.readLine().split(" ");
		}catch(IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < inputs.length; i++) {
			intArr[i] = Integer.parseInt(inputs[i]);
		}
		
		
		
		
	}

}
