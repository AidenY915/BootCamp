package PhoneBook;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {
	private static PhoneBook pb;
	private Set<PhoneInfo> pInfoSet;
	private PhoneBook()
	{
		pInfoSet = new TreeSet<PhoneInfo>();
	}
	public static PhoneBook getPhoneBookInst()
	{
		if(pb == null)
			pb = new PhoneBook();
		return pb;
	}
	public void inputPhoneInfo(PhoneInfo pInfo)
	{
		pInfoSet.add(pInfo);
	}
	public void searchPhoneInfo(String name)
	{
		PhoneInfo result = search(name);
		if(result != null)
			result.showPhoneInfo();
		else
			System.out.println("ã���ô� �����Ͱ� �����ϴ�.");
	}
	public void deletePhoneInfo(PhoneInfo target)
	{
		pInfoSet.remove(target);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}


	public PhoneInfo search(String name)
	{
		Iterator<PhoneInfo> itr = pInfoSet.iterator();
		while(itr.hasNext())
		{
			PhoneInfo rslt = itr.next();
			if(rslt.getName().compareTo(name) == 0)
				return rslt;
		}
		return null;		
	}

	public void showAllPhoneInfo()
	{
		for(PhoneInfo e : pInfoSet)
			e.showPhoneInfo();
	}
}
