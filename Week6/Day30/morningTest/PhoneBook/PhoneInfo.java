package PhoneBook;

public class PhoneInfo {
	private String name;
	private String phone;

	PhoneInfo(String name, String phone)
	{
		this.name = name;
		this.phone = phone;
	}
	public String getName()
	{
		return name;
	}
	public void showPhoneInfo()
	{
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ��ȣ : " + phone);
	}
}