import java.util.Scanner;

class PhoneInfo  {				//전화번호
	private String name;
	private String number;
	private String birth;
	PhoneInfo(String _name, String _number, String _birth) {
		name = _name;
		number = _number;
		birth = _birth;
	}
	String getName() {return name;}
	void printInfo() {
		System.out.printf("이름 : %s\n전화번호 : %s\n생년월일 : %s\n\n" , name, number, birth);
	} 
}

class PhoneManager {		//전화번호부
	private final static int ADD = 1, SEARCH = 2, DELETE = 3, PRINT_ALL = 4, QUIT = 5;	//가독성을 위한 커맨드 상수화
	private PhoneInfo[] PhoneInfoArray = new PhoneInfo[100];
	private int count = 0;
	private int returnSearchedIndex(String name){			//검색
		for(int i = 0 ; i < count ; i++) {
			if(name.equals(PhoneInfoArray[i].getName())) return i;
		}
		return -1;
	}
	private void search(String name){				//검색 후 정보 출력
		int searchedIndex = returnSearchedIndex(name);
		if(searchedIndex == -1){
			System.out.println("정보 없음.\n");
			return;
		}
		PhoneInfoArray[searchedIndex].printInfo();
		System.out.println();
	}
	
	private void add(String name, String number, String birth) {	//추가
		if(count >= 100) {	
			System.out.println("데이터 초과.\n");
			return;
		}
		PhoneInfoArray[count] = new PhoneInfo(name, number, birth);
		count++;
		System.out.println("데이터 입력이 완료되었습니다.\n");
	}
	private void delete(String name) {				//삭제
		int searchedIndex = returnSearchedIndex(name);
		if(searchedIndex == -1){
			System.out.println("정보 없음.\n");
			return;
		}
		for(int i = searchedIndex; i < count - 1; i++)
			PhoneInfoArray[i] = PhoneInfoArray[i + 1];
		count--;
		System.out.println("데이터 삭제가 완료되었습니다.\n");
	}
	private void printAll() {					//모든 정보 출력
		for(int i = 0; i < count ; i++)
			PhoneInfoArray[i].printInfo();
	}

	public static void programStart(PhoneManager pm){		//전화번호부 관리 실행
		Scanner sc = new Scanner(System.in);
		String name = null, number = null, birth = null ;
		boolean run = true;
		while(run){
			System.out.print("선택하세요...\n1. 데이터 입력\n2. 데이터 검색\n3. 데이터 삭제\n4. 모든 데이터 보기\n5. 프로그램 종료\n선택 : ");
			int cmd = sc.nextInt();
			sc.nextLine();
			System.out.println();
			switch(cmd) {
				case ADD : 
					System.out.print("데이터 입력을 시작합니다.\n이름 : "); name = sc.nextLine();
					System.out.print("전화번호 : "); number = sc.nextLine();
					System.out.print("생년월일 : "); birth = sc.nextLine();
					pm.add(name, number, birth);
					break;
				case SEARCH : 
					System.out.print("데이터 검색을 시작합니다.\n이름 : "); name = sc.nextLine();
					pm.search(name);
					break;
				case DELETE : 
					System.out.print("데이터 삭제를 시작합니다.\n이름 : "); name = sc.nextLine();
					pm.delete(name);
					break;
				case PRINT_ALL :
					pm.printAll();
					break; 
				case QUIT :
					run = false;
					break;
			}
		}
	}
	
}

public class PhoneBook {
	public static void main(String[] args) {
		PhoneManager.programStart(new PhoneManager());
	}
}