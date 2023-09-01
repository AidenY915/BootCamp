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
		return sum;
	}
	public void setSum(int n) { 
		if(isRenewed) {
			
		}
		sum += n;
		
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
		int[] intArr = new int[inputs.length];
		for(int i = 0; i < inputs.length; i++) {
			intArr[i] = Integer.parseInt(inputs[i]);
		}
		
		
		
	}

}
