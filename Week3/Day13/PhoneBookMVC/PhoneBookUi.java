import java.util.Scanner;
public class PhoneBookUi {
	private static PhoneBook pb = PhoneBook.getPhoneBook();
	private static Scanner sc = new Scanner(System.in);
	private static void add() {
		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.print("생년월일 : ");
		String birthDay = sc.nextLine();

		if(!pb.add(name, phoneNumber, birthDay)) {
			System.out.println("데이터 초과");
			return;
		}
		System.out.println("데이터 입력이 완료되었습니다.\n");
			
	}
	private static void search() {
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		if(!pb.search(name)) {
			System.out.println("검색한 이름이 없습니다.");
			return;
		}
		System.out.println("데이터 검색이 완료되었습니다.\n");
	}
	private static void delete() {
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름 : ");
		String phoneNumber = sc.nextLine();
		if(!pb.search(phoneNumber)) {
			System.out.println("검색한 번호가 없습니다.");
			return;
		}
		System.out.println("데이터 삭제가 완료되었습니다.\n");
	} 
	private static void showAll() {
		pb.showAll();
	}

	public static void start() {
		final int ADD = 1, SEARCH = 2, DELETE = 3, SHOW = 4, QUIT = 5;
		boolean run = true;
		while(run) {
			System.out.print("1. 데이터 입력\n2. 데이터 검색\n3. 데이터 삭제\n4. 모든 데이터 보기\n5. 프로그램 종료\n선택 : ");
			int cmd = sc.nextInt();
			sc.nextLine();
			switch(cmd) {
				case ADD :	add(); break;
				case SEARCH :	search(); break;
				case DELETE :	delete(); break;
				case SHOW :	showAll(); break;
				case QUIT :	System.out.println("프로그램을 종료합니다."); return;
			}
		}
	}
}