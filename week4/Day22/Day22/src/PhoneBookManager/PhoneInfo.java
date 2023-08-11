package PhoneBookManager;

class PhoneInfo {
	private String name;
	private String number;
	public PhoneInfo(String name, String number) {
		this.name = name;
		this.number = number;
	}
	public String getInfo() {
		return "이름 : " + name + "\n전화번호 :" + number + "\n";
	}
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
}

class PhoneUnivInfo extends PhoneInfo {
	private String major;
	private int year;
	public PhoneUnivInfo(String name, String number, String major, int year) {
		super(name, number);
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

	public PhoneCompanyInfo(String name, String number, String company) {
		super(name, number);
		this.company = company;
	}

	@Override
	public String getInfo() {
		return super.getInfo() + "회사 : " + company;
	}
}