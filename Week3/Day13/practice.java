import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
class mkRandom {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int min = sc.nextInt();
		int[] arr = new int[10];
		for(int i = 0; i < 10 ; i++)
			arr[i] = (int)(Math.random() * (max - min + 1)) + min;	/*개수 + 시작점*/
		System.out.println(Arrays.toString(arr));

		Random rand = new Random();		//랜덤 클래스
		for(int i = 0; i < 10 ; i++)
			arr[i] = rand.nextInt(max - min + 1) + min;	/*개수 + 시작점*/
		System.out.println(Arrays.toString(arr));

	}

}


class mkLotto {
	public static void swapInt(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String[] args){
		int[] arrForShuffle = new int[46];
		boolean[] arrForCheck = new boolean[46];
		for(int i = 1; i <= 45; i++) {
			arrForShuffle[i] = i;
		}

		for(int i = 1; i <= 44; i++) {
			int n = (int)(Math.random()*(45 - i +1))+i;
			swapInt(arrForShuffle, i, n);
		}	
	
		int[][] lottoArr = new int[5][];
		for(int i = 0; i < 5; i++) {
			lottoArr[i] = new int[5];
			for(int j = 1; j <= 45; j++)
				arrForCheck[j] = false;
			for(int j = 0; j < 5; j++) {
				int tmp = (int)(Math.random()*45)+1;
				if(arrForCheck[tmp]) {
					i--;
					continue;
				}
				arrForCheck[tmp]= true;
				lottoArr[i][j] =arrForShuffle[tmp];
			}
			for(int j = 0; j <  5 - 1 ; j++) {
				for(int k = 0; k <  5 - j - 1 ; k++) {
					if(lottoArr[i][k] > lottoArr[i][k + 1])
						swapInt(lottoArr[i] ,k, k + 1);
				}
			}
			System.out.println(Arrays.toString(lottoArr[i]));
		}
		System.out.println(Arrays.toString(arrForShuffle));
	}	



}