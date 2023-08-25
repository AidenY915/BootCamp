package CollectionQuiz;
import java.util.*;

class Q7 {
	static HashMap<String,HashMap<String,String>> phoneBook = new HashMap<>();
	//group이 1차키 phoneNumber가 2차키
	private static void addPhoneNo(String group, String name, String phoneNum) {
		if(phoneBook.get(group) == null)
			phoneBook.put(group, new HashMap<String,String>());
		phoneBook.get(group).put(phoneNum,name);
	}
	private static void addPhoneNo(String name, String phoneNum) {
		addPhoneNo("기타", name, phoneNum);
	}
	private static void printList() {
		Set phoneBookKeySet = phoneBook.keySet();
		Iterator<String> pbItr = phoneBookKeySet.iterator();
		while(pbItr.hasNext()) {
			String groupKey = pbItr.next();
			HashMap<String, String> group = phoneBook.get(groupKey);
			System.out.println(groupKey + " ["+ group.size() + "]");
			
			Set GroupKeySet = group.keySet();
			Iterator<String> gItr = GroupKeySet.iterator();
			while(gItr.hasNext()) {
				String phoneNumber= gItr.next();
				String name = group.get(phoneNumber);
				System.out.println(name + " " + phoneNumber);
			}
		}
	}
	
	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-2222");
		addPhoneNo("친구", "김자바", "010-333-3333");
		addPhoneNo("회사", "김대리", "010-444-4444");
		addPhoneNo("회사", "김대리", "010-555-5555");
		addPhoneNo("회사", "박대리", "010-666-6666");
		addPhoneNo("회사", "이과장", "010-777-7777");
		addPhoneNo("세탁", "010-888-8888");

		printList();
	} // main
}