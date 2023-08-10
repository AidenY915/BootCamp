package PhoneBookManager;

class PhoneInfo {
	private String name;
	private String phoneNumber;
	
	PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public String getInfo() {
		return "이름 : " + name + "\n전화번호 : " + phoneNumber + "\n";
	} 
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
}

class PhoneUnivInfo extends PhoneInfo {
	private String major;
	private int year;
	public PhoneUnivInfo(String name, String phoneNumber, String major, int year) {
		super(name, phoneNumber);
		this.major = major;
		this.year = year;
	}
	@Override
	public String getInfo() {
		return super.getInfo() + "전공 : " + major + "\n학년 : " + year + "\n";
	}
}
class PhoneCompanyInfo extends PhoneInfo {
	private String company;

	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}

	@Override
	public String getInfo() {
		return super.getInfo() +  "회사 : " + company + "\n";
	}	
}
