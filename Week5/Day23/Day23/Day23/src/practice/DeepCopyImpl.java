package practice;

class Business implements Cloneable
{
	private String company;
	private String work;

	public Business(String company, String work)
	{
		this.company = company;
		this.work = work;
	}
	public void showBusinessInfo()
	{
		System.out.println("회사 : " + company);
		System.out.println("업무 : " + work);
	}
	public void changeWork(String work)
	{
		this.work=work;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

class PersonalInfo implements Cloneable
{
	private String name;
	private int age;
	private Business bness;

	public PersonalInfo(String name, int age, String company, String work)
	{
		this.name = name;
		this.age = age;
		bness = new Business(company, work);
	}
	public void showPersonalInfo()
	{
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		bness.showBusinessInfo();
		System.out.println("");
	}
	public void changeWork(String work)
	{
		bness.changeWork(work);
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		PersonalInfo newClone = (PersonalInfo)super.clone();
		newClone.bness = (Business)bness.clone(); 			//String은 immutable해서 깊은 복사할 필요가 없음.
		return newClone;
	}
	
}

class DeepCopyImpl
{
	public static void main(String[] args)
	{

			PersonalInfo pInfo = new PersonalInfo("James", 22, "HiMedia", "encoding");
			PersonalInfo pCopy = null;
			try {
				pCopy = (PersonalInfo)pInfo.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pCopy.changeWork("decoding");

			pInfo.showPersonalInfo();
			pCopy.showPersonalInfo();
	}
}