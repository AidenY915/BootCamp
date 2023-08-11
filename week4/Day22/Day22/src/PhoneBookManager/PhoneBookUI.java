package PhoneBookManager;

import java.util.Scanner;

interface Nums {
	int MAX = 10;
	
	byte TYPE_NORMAL = 1;
	byte TYPE_UNIV = 2;
	byte TYPE_COMPANY = 3;
	
	byte ADD = 1;
	byte SEARCH = 2;
	byte DELETE = 3;
	byte SHOW = 4;
	byte QUIT = 5;
	
	String GUIDE_MESSAGE = "선택하세요...\r\n"
			+ "1. 데이터 입력\r\n"
			+ "2. 데이터 검색\r\n"
			+ "3. 데이터 삭제\r\n"
			+ "4. 모든 데이터 보기\r\n"
			+ "5. 프로그램 종료\r\n"
			+ "선택 : ";
	String INPUT_GUIDE_MESSAGE = "데이터 입력을(를) 시작합니다.\r\n"
			+ "1. 일반, 2. 대학, 3. 회사\n" + "선택 : ";
	String INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";
	String ARRAY_EXCEED_MESSAGE = "저장한도를 초과했습니다.";
	String WORK_MESSAGE = "을(를) 시작하겠습니다.";
	String DONE_MESSAGE = "을(를) 완료했습니다.";
	String NOT_FOUND_MESSAGE = "을(를) 찾지 못했습니다.";
	String DELETE_CHECK_MESSAGE = "정말로 삭제하시겠습니까?(YES: 1, NO: 2)";
}


abstract class PhoneBookUI implements Nums{
	private static PhoneBook pb = PhoneBook.getPhoneBook();
	private static Scanner sc = new Scanner(System.in);
	
	static class WrongTypeSelectException extends Exception{

		WrongTypeSelectException() {
			super("잘못된 선택입니다.");
		}
		
	}
	
	private static void add() {
		System.out.print(INPUT_GUIDE_MESSAGE);
		byte type = 0;
		try {
			type = sc.nextByte(); sc.nextLine();
			if(type < 1 || type > 3) throw new WrongTypeSelectException();
		}catch(WrongTypeSelectException e) { 
			System.out.println(e.getMessage());
			add();
			return;
		}
		String[] input = new String[4];
		System.out.print("이름 : ");
		input[0] = sc.nextLine();
		System.out.print("전화번호 : ");
		input[1] = sc.nextLine();
		switch (type) {
		case TYPE_UNIV: {
			System.out.print("전공 : ");
			input[2] = sc.nextLine();
			System.out.print("학년 : ");
			input[3] = sc.nextLine();
		}
		case TYPE_COMPANY:
			System.out.print("회사 : ");
			input[2] = sc.nextLine();
		}
		pb.add(type, input);
	}
	private static void search() {
		System.out.print("검색" + WORK_MESSAGE + "\n검색할 이름 : ");
		String name = sc.nextLine();
		String rslt = pb.search(name);
		System.out.println(rslt);
	}
	private static void delete() {
		System.out.print("삭제" + WORK_MESSAGE + "\n삭제할 번호 : ");
		String number = sc.nextLine();
		System.out.print(DELETE_CHECK_MESSAGE);
		Byte selection = sc.nextByte();
		if(selection != 1) return;
		if(!pb.delete(number)) System.out.println(NOT_FOUND_MESSAGE);
	}
	private static void show() {
		System.out.println("데이터 출력" + WORK_MESSAGE);
		String info = pb.getInfo();
		System.out.println(info);
	}
	
	public static void start() {
		boolean run = true;
		while(run) {
			System.out.print(GUIDE_MESSAGE);
			int cmd = sc.nextByte();
			sc.nextLine();
			switch (cmd) {
			case ADD: add(); break;
			case SEARCH: search(); break;
			case DELETE: delete(); break;
			case SHOW: show(); break;
			case QUIT: run = false; break;
			}
		}
	}
}

