package PhoneBookManager;

interface Constants {
	int MAX = 100;
	
	int NORMAL = 1;
	int UNIV = 2;
	int COMPANY = 3;
	
	int NAME = 0;
	int NUMBER = 1;
	
	int ADD = 1;
	int SEARCH = 2;
	int DELETE = 3;
	int SHOW = 4;
	int QUIT = 5;
	
	String GUIDE_MESSAGE = "1. 데이터 입력\r\n"
			+ "2. 데이터 검색\r\n"
			+ "3. 데이터 삭제\r\n"
			+ "4. 모든 데이터 보기\r\n"
			+ "5. 프로그램 종료\r\n"
			+ "선택 :";
			
	String ADD_MESSAGE = "데이터 입력을 시작합니다.\r\n"
			+ "1. 일반, 2. 대학, 3. 회사\n";
	String WRONG_INPUT_MESSAGE = "잘못된 입력입니다.";
}


class PhoneBook implements Constants {
	private static PhoneBook pb = new PhoneBook();
	private PhoneBook() {}
	public static PhoneBook getPhoneBook() {
		return pb;
	}
	
	private PhoneInfo[] piArr = new PhoneInfo[MAX];
	private int cnt;
	
	private int binarySearch(int mode ,String target) {
		int start = 0, end = cnt - 1; 
		while(start <= end) {
			int mid = (start + end) / 2;
			String midStr = mode == NAME ? piArr[mid].getName() : piArr[mid].getPhoneNumber();
			if(midStr.compareTo(target) == 0) return mid;
			else if (midStr.compareTo(target) < 0) start = mid + 1;
			else end = mid - 1;
		}
		return -start -1;
		
	}
	
	private void pushRight(int start) {
		PhoneInfo tmp = piArr[cnt];
		for(int i = cnt - 1; i > start ; i--) {
			piArr[i] = piArr[i - 1];
		}
		piArr[start] = tmp;
	}
	
	public boolean add(int type, String[] strs) {
		if(cnt == MAX) return false;
		PhoneInfo tmp = null;
		switch(type) {
		case NORMAL: tmp = new PhoneInfo(strs[0], strs[1]); break;
		case UNIV : tmp = new PhoneUnivInfo(strs[0], strs[1], strs[2], Integer.parseInt(strs[3])); break;
		case COMPANY : tmp = new PhoneCompanyInfo(strs[0], strs[1], strs[2]);
		}
		piArr[cnt] = tmp;
		pushRight(-binarySearch(NAME, piArr[cnt].getName())-1);
		cnt++;
		return true;
	}
	
	private void pushLeft(int start) {
		for(int i = start; i < cnt - 1 ; i++) {
			piArr[i] = piArr[i + 1];
		}
	}
	
	public boolean delete(String phoneNumber) {
		int targetIdx = binarySearch(NUMBER, phoneNumber);
		if(targetIdx < 0) return false;
		pushLeft(targetIdx);
		piArr[cnt - 1] = null;
		cnt--;
		return true;
	}
	
	public String search(String name) {
		int targetIdx = binarySearch(NAME, name);
		if(targetIdx < 0) return null;
		return piArr[targetIdx].getInfo();
	}
	
	public String getAllInfo() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < cnt ; i++) {
			sb.append(piArr[i].getInfo());
		}
		return sb.toString();
	}
}
