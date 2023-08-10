package PhoneBookManager;

import java.util.Scanner;

class PhoneBookUi implements Constants {
	private static PhoneBook pb = PhoneBook.getPhoneBook();
	private static Scanner sc = new Scanner(System.in);
	
	private static void add() {
		System.out.print(ADD_MESSAGE);
		int type = sc.nextInt();
		sc.nextLine();
		try {
			if(type > 3 || type < 1) throw new Exception(WRONG_INPUT_MESSAGE);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			add();
			return;
		}
		String[] input = new String[4];
		System.out.print("이름 : ");
		input[0] = sc.nextLine();
		System.out.print("전화번호 : ");
		input[1] = sc.nextLine();
		switch(type) {
		case UNIV : 
			System.out.print("전공 : ");
			input[2] = sc.nextLine();
			System.out.print("학년 : ");
			input[3] = sc.nextLine();
			break;
		case COMPANY :
			System.out.print("회사 : ");
			input[2] = sc.nextLine();
		}
		
		if(!pb.add(type, input)) {
			System.out.println("등록 가능 최대 인원 초과");
		}
	}
	
	private static void search() {
		System.out.println("검색을 시작합니다.");
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		String rslt = pb.search(name);
		if(rslt==null) {
			System.out.println("찾는 이름이 없습니다.");
			return;
		}
		System.out.println(rslt);
	}
	
	private static void delete() {
		System.out.println("삭제할 번호를 입력하세요");
		String phoneNumber = sc.nextLine();
		if(!pb.delete(phoneNumber)) {
			System.out.println("삭제하고자 하는 번호가 없습니다.");
		}
	}
	private static void showAllInfo() {
		System.out.println("모든 정보를 출력합니다.");
		System.out.println(pb.getAllInfo());
	}
	
	
	
	public static void start() {
		boolean run = true;
		
		while(run) {
			System.out.print(GUIDE_MESSAGE);
			int cmd;
			try {
			cmd = sc.nextInt();
			if(cmd < ADD || cmd > QUIT) throw new Exception(WRONG_INPUT_MESSAGE);
			}catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}
			sc.nextLine();
			switch(cmd) {
			case ADD: add(); break;
			case SEARCH: search(); break;
			case DELETE: delete(); break;
			case SHOW: showAllInfo(); break;
			case QUIT: run = false; break;
			}
		}
		sc.close();
	}
}
