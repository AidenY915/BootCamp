import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.TreeSet;

public class PhoneBook  {

	private static PhoneBook pb;
	private TreeSet<PhoneInfo> set;
	private File file = new File("book.ser");
	
	private PhoneBook() 
	{
		set = load();
		if(set == null) {
			set = new TreeSet<PhoneInfo>();
		}
	}

	public static PhoneBook getPhoneBook()
	{
		if(pb==null)
			pb = new PhoneBook();
		return pb;
	}

	public boolean insertPhoneInfo(PhoneInfo phoneInfo)
	{		
		return set.add(phoneInfo);
	}

	public boolean searchPhoneInfoByName(String name)
	{
		PhoneInfo pInfo = null;
		Iterator<PhoneInfo> itr = set.iterator();
		boolean result = false;

		while(itr.hasNext())
		{			
			pInfo = itr.next();
			if(pInfo.getName().equals(name))
			{
				pInfo.printCurrentState();
				result = true;
			}
		}

		return result;
	}

	public boolean deletePhoneInfoByPhoneNumber(String phoneNumber)
	{
		PhoneInfo pInfo = null;
		Iterator<PhoneInfo> itr = set.iterator();

		while(itr.hasNext())
		{			
			pInfo = itr.next();
			if(pInfo.getPhoneNumber().equals(phoneNumber))
			{
				itr.remove();
				return true;
			}
		}
		return false;
	}

	public void printAllPhoneInfo()
	{
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext())
		{
			itr.next().printCurrentState();
		}
//		for(PhoneInfo info: set)
//			info.printCurrentState();
	}
	
	public TreeSet<PhoneInfo> load() {
		if(!file.exists()) return null;
		
		TreeSet<PhoneInfo> rslt = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			rslt = (TreeSet<PhoneInfo>)ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("최초 실행");
			return null;
		}catch (IOException e) {
			System.out.println("저장 파일 손실 발생");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rslt;
	}
	public void save() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
			oos.writeObject(set);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}