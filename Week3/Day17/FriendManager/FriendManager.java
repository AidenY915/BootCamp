import java.util.Scanner;

class Friend {
	private String name;
	private String phoneNum;
	private String address;
	
	Friend(String _name, String _phoneNum, String _address) {
		name = _name; phoneNum = _phoneNum; address = _address;
	}
	protected void showData() {
		System.out.printf("이름 : %s\n전화번호 : %s\n주소 : %s\n", name, phoneNum, address);	
	}
	protected void showBasicInfo() {
		System.out.printf("이름 : %s\n전화번호 : %s\n", name, phoneNum);
	}
}

class HighFriend extends Friend {
	private String job;
	HighFriend(String _name, String _phoneNum, String _address, String _job){
		super(_name, _phoneNum, _address);
		job = _job;
	}
	protected void showData() {
		super.showData();
		System.out.printf("직장 : %s\n", job);
	}
	protected void showBasicInfo() {
		super.showBasicInfo();
		System.out.printf("직장 : %s\n", job);
	}
}

class UnivFriend extends Friend {
	private String major;
	UnivFriend(String _name, String _phoneNum, String _address,String _major) {
		super(_name, _phoneNum, _address);
		major = _major;
	}
	protected void showData() {
		super.showData();
		System.out.printf("전공 : %s\n", major);
	}
	protected void showBasicInfo() {
		super.showBasicInfo();
		System.out.printf("전공 : %s\n", major);
	}
	
}

class FriendManager {
	private static FriendManager fm;
	private FriendManager(){};
	private Friend[] friendArr = new Friend[100]; 
	private int cnt;
	public static FriendManager getFriendManger() {
		if( fm == null )
			fm = new FriendManager();
		return fm;
	}
	
	public void addFriend(int kind, String name, String phoneNum, String address, String info) {
		if(cnt >= friendArr.length ) {
			System.out.println("최대수 초과");
			return;
		}
		switch (kind) {
			case FriendManagerUi.HIGH : 
				friendArr[cnt] = new HighFriend(name, phoneNum, address, info); break;
			case FriendManagerUi.UNIV : 
				friendArr[cnt] = new UnivFriend(name, phoneNum, address, info); break;
		}
		cnt++;
	}
	
	public void printData() {
		for(int i = 0; i < cnt ; i++) {
			friendArr[i].showData();
			System.out.println();
		}
	}
	
	public void printBasicInfo() {
		for(int i = 0; i < cnt ; i++) {
			friendArr[i].showBasicInfo();
			System.out.println();
		}
	}

}

class FriendManagerUi{
	public static final int HIGH = 1, UNIV = 2, PRINT_DATA = 3, PRINT_BASIC_INFO = 4, QUIT = 5;
	private static FriendManager fm = FriendManager.getFriendManger();

	private static Scanner sc = new Scanner(System.in , "EUC-KR");
	private static String guide= "*** 메뉴 선택 ***\n1. 고교 정보 저장\n2. 대학 친구 저장\n3. 전체 정보 출력\n4. 전체 기본 정보 출력\n5. 프로그램 종료\n선택>>";

	private static void addFriend(int kind) {
		System.out.println((kind == HIGH ? "고교" : "대학") + "친구 정보 입력을 시작합니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phoneNum = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		String tmp = kind == HIGH ? "직장" : "전공";
		System.out.print(tmp + " : ");
		String info = sc.nextLine();
		System.out.println();
		fm.addFriend(kind, name, phoneNum, address, info);  
	}
	
	private static void printData() {
		fm.printData();
	}
	private static void printBasicInfo() {
		fm.printBasicInfo();
	}
	

	public static void start() {
		boolean run = true;
		while(run) {
			System.out.print(guide);
			int cmd = sc.nextInt();
			sc.nextLine();
			System.out.println();
			switch(cmd) {	
				case HIGH :  
				case UNIV : addFriend(cmd); break;
				case PRINT_DATA : printData(); break;
				case PRINT_BASIC_INFO : printBasicInfo(); break;
				case QUIT : run = false;
			}
		}
		sc.close();
	}

}


class FriendManagerMain{
	public static void main(String[] args) {
		FriendManagerUi.start();
	}
}