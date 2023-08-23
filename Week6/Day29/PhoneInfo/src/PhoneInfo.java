import java.util.Objects;

public class PhoneInfo implements Comparable<PhoneInfo>{
	private String name;
	private String phone;

	PhoneInfo(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void showPhoneInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
	}
	@Override
	public int hashCode() {
		return Objects.hash(phone);
	}
	@Override
	public boolean equals(Object obj) {
		PhoneInfo op = (PhoneInfo)obj;
		return name.equals(op.name) && phone.equals(op.phone);
	}
	@Override
	public int compareTo(PhoneInfo o) {
		PhoneInfo op = (PhoneInfo)o;
		return name.compareTo(op.name);
	}
}