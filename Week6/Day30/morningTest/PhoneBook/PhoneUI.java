package PhoneBook;

import java.util.Scanner;

public class PhoneUI {
	public static Scanner sc = new Scanner(System.in);
	private static PhoneBook pb = PhoneBook.getPhoneBookInst();


	private PhoneUI(){}
	public static void mainMenu()
	{
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ��� ������ ����");
		System.out.println("5. ���α׷� ����");
		System.out.print("���� : ");
	}

	public static void inputMenu()
	{
		System.out.println("1. �Ϲ�, 2. ����, 3. ȸ��");
	}
	public static void inputMenuChoice() throws MenuChoiceException
	{
		int choice=0;
		choice = sc.nextInt();
		sc.nextLine();
		if(choice < PhoneMenuString.GENERAL || choice > PhoneMenuString.COMPANY)
			throw new MenuChoiceException(choice);
		switch(choice)
		{
		case PhoneMenuString.GENERAL:
			inputGeneralPhoneInfo();
			break;
		case PhoneMenuString.UNIVERCITY:
			inputUniversityPhoneInfo();
			break;
		case PhoneMenuString.COMPANY:
			inputCompanyPhoneInfo();
			break;
		}
	}

	public static void inputGeneralPhoneInfo()
	{
		String name;
		String phone;

		System.out.println("������ �Է��� �����մϴ�.");
		System.out.print("�̸� : ");
		name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		phone = sc.nextLine();
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
		pb.inputPhoneInfo( new PhoneInfo(name, phone) );
	}

	public static void inputUniversityPhoneInfo()
	{
		String name;
		String phone;
		String major;
		int year;

		System.out.println("������ �Է��� �����մϴ�.");
		System.out.print("�̸� : ");
		name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		phone = sc.nextLine();
		System.out.print("���� : ");
		major = sc.nextLine();
		System.out.print("�г� : ");
		year = sc.nextInt();
		sc.nextLine();
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
		pb.inputPhoneInfo( new PhoneUnivInfo(name, phone, major, year) );
	}

	public static void inputCompanyPhoneInfo()
	{
		String name;
		String phone;
		String company;

		System.out.println("������ �Է��� �����մϴ�.");
		System.out.print("�̸� : ");
		name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		phone = sc.nextLine();
		System.out.print("ȸ�� : ");
		company = sc.nextLine();
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
		pb.inputPhoneInfo( new PhoneCompanyInfo(name, phone, company) );
	}

	public static void searchPhoneInfo()
	{
		String name;
		System.out.println("������ �˻��� �����մϴ�.");
		System.out.println("�˻��Ͻð��� �ϴ� �̸��� �Է��ϼ���.");
		name = sc.nextLine();
		pb.searchPhoneInfo(name);			
	}
	public static void deletePhoneInfo()
	{
		String name;
		PhoneInfo result=null;
		int answer=0;
		System.out.println("�˻��Ͻð��� �ϴ� �̸��� �Է��ϼ���.");		
		name = sc.nextLine();		
		result = pb.search(name);
		if(result != null)
		{
			System.out.println("���� �����Ͻðڽ��ϱ�? 1. Yes 2. No");
			answer = sc.nextInt();
			sc.nextLine();
			switch(answer)
			{
			case PhoneMenuString.YES:
				pb.deletePhoneInfo(result);
				break;
			case PhoneMenuString.NO:
				break;
			default:
				System.out.println("�߸� �����̽��ϴ�.");
			}
		}
		else
			System.out.println("�����Ͻ÷��� �����Ͱ� �����ϴ�.");
	}
	public static void showAllPhoneInfo()
	{
		pb.showAllPhoneInfo();
	}
}
