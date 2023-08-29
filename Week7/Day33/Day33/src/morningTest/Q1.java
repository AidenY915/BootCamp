package morningTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class HashMapEx3 {
	static HashMap<String,HashMap<String,String>> phoneBook = new HashMap<>();
	
	private static void addPhoneNo(String group, String name, String phoneNum) {
		if(!phoneBook.containsKey(group))
			phoneBook.put(group,new HashMap<String,String>());
		phoneBook.get(group).put(phoneNum, name);
	}
	private static void addPhoneNo(String name, String phoneNum) {
		addPhoneNo("기타", name, phoneNum);
	}
	private static void printList() {
		Iterator<Map.Entry<String, HashMap<String,String>>> itr = phoneBook.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<String, HashMap<String,String>> groupEntry =  itr.next();
			HashMap<String, String> group = groupEntry.getValue();
			System.out.println(groupEntry.getKey()+ "[" + group.size() + "]");
			Iterator<Map.Entry<String, String>> gItr = group.entrySet().iterator();
			while(gItr.hasNext()) {
				Map.Entry<String,String> phoneNumEntry  = gItr.next();
				System.out.println(phoneNumEntry.getValue() + " " + phoneNumEntry.getKey());
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