
public class Q9_11 {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("시작 단과 끝 단 두 개의 정수를 입력해주세요.");
			return;
		}
		int from = 0;
		int to = 0;
		try {
			from = Math.min(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			to = Math.max(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		}catch(RuntimeException e){
			System.out.println("시작 단과 끝 단 두 개의 정수를 입력해주세요.");
		}
		StringBuilder sb = new StringBuilder(8*9*6);
		for(int i = from ; i <= to ; i++) {
			for(int j =  1; j <= 9 ; j++) {
				sb.append(i + "*" + j + "=" + i*j + "\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
