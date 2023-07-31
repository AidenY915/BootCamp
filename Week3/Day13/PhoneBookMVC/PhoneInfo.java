public class PhoneInfo {
	private String name;
	private String phoneNumber;
	private String birthDay;
	PhoneInfo(String _name, String _phoneNumber, String _birthDay) {
		name = _name;
		phoneNumber = _phoneNumber;
		birthDay = _birthDay;
	}
	public void printInfo() {
		System.out.printf("이름 : %s\n전화번호 : %s\n생년월일 : %s\n", name, phoneNumber, birthDay);
	}
	public String getName() { return name; }
	public String getPhoneNumber() { return phoneNumber; }
}
