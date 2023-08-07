import java.util.Scanner;

class Friend {
	private String name;
	private String phoneNum;
	private String address;

	Friend(String _name, String _phoneNum, String _address) {
		name = _name;
		phoneNum = _phoneNum;
		address = _address;
	}
	protected String showData() {
		return "이름 : " + name + "\n전화번호 : " + phoneNum + "\n주소 : " + address + "\n";
	}
	protected String showBasicInfo() {
		return "이름 : " + name + "\n";
	}
	protected String getPhoneNum() {
		return phoneNum;
	}
}

class HighFriend extends Friend {
	private String job;
	HighFriend(String _name, String _phoneNum, String _address, String _job) {
		super(_name, _phoneNum, _address);
		job = _job;
	}
	public String showData() {
		return super.showData() + "직장 : " + job + "\n";
	}
	public String showBasicInfo() {
		return super.showBasicInfo() + "전화번호 : " + super.getPhoneNum() + "\n직장 : " + job + "\n"; 
	}

}

class UnivFriend extends Friend {
	private String major;
	UnivFriend (String _name, String _phoneNum, String _address, String _major) {
		super(_name, _phoneNum, _address);
		major = _major;
	}
	public String showData() {
		return super.showData() + "전공 : " + major + "\n";
	}
	public String showBasicInfo() {
		return super.showBasicInfo() + "전공 : " + major + "\n"; 
	}
}

class FriendManager{
	private static FriendManager fm = new FriendManager();
	private Friend[] friendArr = new Friend[100];
	private int cnt = 0;
	
	private FriendManager(){}
	public static FriendManager getFriendManager() {
		return fm;
	}
	public void add(int type, String name, String phoneNum, String address, String info) {
		Friend tmp = null;
		switch (type) {
			case FriendManagerUi.ADD_HIGH :
				tmp = new HighFriend(name, phoneNum, address, info); break;
			case FriendManagerUi.ADD_UNIV :
				tmp = new UnivFriend(name, phoneNum, address, info); break;
			default : cnt --;	
		}
		friendArr[cnt++] = tmp;
	}
	
	public String showData() {
		StringBuilder sb = new StringBuilder(cnt * 100);
		for(int i = 0 ; i < cnt ; i++){
			sb.append(friendArr[i].showData() + "\n");
		}
		return sb.toString();
	}

	public String showBasicInfo() {
		StringBuilder sb = new StringBuilder(cnt * 100);
		for(int i = 0 ; i < cnt ; i++){
			sb.append(friendArr[i].showBasicInfo() + "\n");
		}
		return sb.toString();
	}
}

class FriendManagerUi {
	public final static int ADD_HIGH = 1, ADD_UNIV = 2, SHOW_ALL = 3, SHOW_BASIC = 4, QUIT = 5;
	public static FriendManager fm = FriendManager.getFriendManager();
	private FriendManagerUi(){}
	private static Scanner sc = new Scanner(System.in);
	private final static String guide = "*** 메뉴 선택 ***\n1. 고교 정보 저장\n2. 대학 친구 저장\n3. 전체 정보 출력\n4. 전체 기본 정보 출력\n5. 프로그램 종료\n선택>>";

	private static void add(int type) {
		System.out.print("이름 : ");
		String name = sc.nextLine();	
		System.out.print("전화번호 : ");
		String phoneNum = sc.nextLine();	
		System.out.print("주소 : ");
		String address = sc.nextLine();
		String info = null;
		switch (type) {
			case ADD_HIGH : 
				System.out.print("직장 : ");
				break;
			case ADD_UNIV : 
				System.out.print("전공 : ");	
				break;
		}
		info = sc.nextLine();
		fm.add(type, name, phoneNum, address, info);	
	}

	private static void showData() {
		System.out.print(fm.showData());
	}

	private static void showBasicInfo() {
		System.out.print(fm.showBasicInfo());
	}
	
	public static void start() {
		boolean run = true;
		while(run) {
			System.out.print(guide);
			int cmd = sc.nextInt();
			sc.nextLine();
			System.out.println();
			switch(cmd) {
				case ADD_HIGH : case ADD_UNIV :
					add(cmd); break;
				case SHOW_ALL : 
					showData(); break;
				case SHOW_BASIC :
					showBasicInfo(); break;
				case QUIT :
					run = false; break;
			}
			System.out.println();
		}
		sc.close();
	}
}


class FriendManagerMain {
	public static void main(String[] args) {
		FriendManagerUi.start();
	}
}