import java.util.Scanner;

class PhoneInfo
{
	private String name;
	private String phoneNumber;

	PhoneInfo(String _name, String _phoneNumber){
		name = _name; phoneNumber = _phoneNumber;
	}

	public String getInfoString() {
		return "이름 : " + name + "\n전화번호 : " + phoneNumber + "\n";
	}

	public String getName() {return name;}
	public String getPhoneNumber() {return phoneNumber;}
}

class PhoneUnivInfo extends PhoneInfo {
	private String major;
	private int year;
	PhoneUnivInfo(String _name, String _phoneNumber, String _major, int _year) {
		super(_name, _phoneNumber);
		major = _major;
		year = _year;
	}
	public String getInfoString() {
		return super.getInfoString() + "전공 : \n" + major + "학년 : " + year + "\n" ;
	}

}

class PhoneCompanyInfo extends PhoneInfo {
	private String company;
	PhoneCompanyInfo(String _name, String _phoneNumber, String _company) {
		super(_name, _phoneNumber);
		company = _company;
	}
	public String getInfoString() {
		return super.getInfoString() + "회사 : " + company + "\n" ;
	}
}

class PhoneBook  {
	private static PhoneBook pb = new PhoneBook();
	private PhoneInfo[] piArr = new PhoneInfo[100];
	private int cnt;
	private final static int NAME = 0, NUMBER = 1;
	private PhoneBook(){}
	public static PhoneBook getPhoneBook() {return pb;}
	
	private void pushLeft(int idx) {
		for(int i = idx; i < cnt - 1; i++) {
			piArr[i] = piArr[i+1];
		}
		piArr[cnt - 1] = null;
		cnt--;
	}
	
	private void pushRight(int idx) {
		for(int i = cnt; i > idx; i--) {
			piArr[i] = piArr[i-1];
		}
		cnt++;
	}	

	private int binarySearch(int mod, String target) {	//무조건 큰거 부터 푸쉬
		int start = 0;
		int end = cnt - 1;
		while(start <= end) {
			
			int mid = (start + end)/2;
			String pivot = mod == NAME ? piArr[mid].getName() : piArr[mid].getPhoneNumber();
			if(pivot.compareTo(target) == 0) {
				return mid;
			}
			else if(pivot.compareTo(target) < 0) {
				start = mid + 1;
			}
			else if(pivot.compareTo(target) > 0) {
				end = mid - 1;
			}
		}
		return -start - 1;	//못찾았으면서 -1곱해서 푸쉬 위치도 알 수 있음.
	}

	public void add(int type, String[] input) {
		PhoneInfo tmp = null;
		switch (type) {
			case PhoneBookUi.NORMAL : tmp = new PhoneInfo(input[0], input[1]); break;
			case PhoneBookUi.UNIV : tmp = new PhoneUnivInfo(input[0], input[1], input[2], Integer.parseInt(input[3])); break;
			case PhoneBookUi.COMPANY : tmp = new PhoneCompanyInfo(input[0], input[1], input[2]); break;
		}
		int idx = binarySearch(NAME,tmp.getName());
		idx = idx < 0 ? -(idx + 1) : idx;
		pushRight(idx);
		piArr[idx] = tmp;
	}
	
	public String search(String name) {
		int idx = binarySearch(NAME,name);
		if(idx > 0) return null;
		return piArr[idx].getInfoString();
			
	}	
	public boolean delete(String number) {
		int idx = binarySearch(NUMBER,number);
		if(idx < 0) return false;
		pushLeft(idx);
		return true;
	}
	public String showAll() {
		StringBuilder sb = new StringBuilder(cnt * 50);
		for(int i = 0 ; i < cnt; i++)
			sb.append(piArr[i].getInfoString());
		return sb.toString();
	}

}

class PhoneBookUi {
	public final static int NORMAL = 1, UNIV = 2, COMPANY = 3;
	public final static int ADD = 1, SEARCH = 2, DELETE = 3, SHOW = 4, QUIT = 5;
	private static PhoneBook pb = PhoneBook.getPhoneBook();
	private static String[] input = new String[4]; 
	private static Scanner sc = new Scanner(System.in);	
	private static void add() {
		final String GUIDE = "데이터입력을 시작합니다.\n1. 일반, 2. 대학, 3. 회사\n선택 >> ";
		System.out.print(GUIDE);
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 : ");
		input[0] = sc.nextLine();
		System.out.print("전화번호 : ");
		input[1] = sc.nextLine();
		switch (type) {
			case UNIV : 
				System.out.print("전공 : ");
				input[2] = sc.nextLine();
				System.out.print("학년 : ");
				input[3] = sc.nextLine();
				break;
			case COMPANY : 
				System.out.print("회사 : ");
				input[2] = sc.nextLine();
				break;
		}
		pb.add(type, input);
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	private static void search() {
		System.out.print("데이터 검색을 시작합니다.\n이름 : ");
		String name = sc.nextLine();
		System.out.println(pb.search(name) + "데이터 검색이 완료되었습니다.");
	}
	
	private static void delete() {
		System.out.print("데이터 삭제를 시작합니다.\n전화번호 : ");
		String phoneNumber = sc.nextLine();
		if(!pb.delete(phoneNumber)) {
			System.out.println("찾으시는 정보가 없습니다.");
			return;
		}
		System.out.println("데이터 삭제가 완료되었습니다.");
	}

	private static void showAll() {
		 System.out.print(pb.showAll());
	}	

	public static void start() {
		boolean run = true;
		final String GUIDE = "선택하세요...\n1. 데이터 입력\n2. 데이터 검색\n3. 데이터 삭제\n4. 모든 데이터 보기\n5. 프로그램 종료\n선택 : ";
		while(run) {
			System.out.print(GUIDE);
			int cmd = sc.nextInt();
			sc.nextLine();
			switch(cmd) {
				case QUIT : run = false; break;
				case ADD :  add(); break;
				case SEARCH : search(); break;
				case DELETE : delete(); break;
				case SHOW : showAll(); break;
			}
			System.out.println();
		}
		sc.close();
	}
}

class PhoneBookMain {
	public static void main(String[] args) {
		PhoneBookUi.start();
	}
}