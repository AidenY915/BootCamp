public class PhoneBook {
	private static PhoneBook pb = new PhoneBook();  
	private PhoneInfo[] phoneInfoArr = new PhoneInfo[100];
	private int cnt = 0;
	
	private PhoneBook(){}
	public static PhoneBook getPhoneBook() {
		return pb;	
	}
	
	public boolean add(String name, String phoneNumber, String birthDay) {
		if(cnt >= 100) return false;
		phoneInfoArr[cnt++] = new PhoneInfo(name, phoneNumber, birthDay);
		return true;
	}	

	private int searchReturnIndex(int type, String info) {
		switch (type) {		//type 1은 전화번호로 검색
			case 1 : 
				for(int i = 0; i < cnt; i++) {
					if(phoneInfoArr[i].getPhoneNumber().equals(info))
						return i;
				}
				break;
		}
			return -1;
	}
	
	public boolean search(String name) {
		boolean finded = false;
		for(int i = 0; i < cnt; i++) {
			if(phoneInfoArr[i].getName().equals(name)){
				phoneInfoArr[index].printInfo();
				finded = true;		
			}
		}
		return finded;
	}
	public boolean delete(String phoneNumber) {
		int index = searchReturnIndex(1, phoneNumber);
		if(index == -1) return false;
		for(int i = index ; i < cnt - 1; i++){
			phoneInfoArr[i] = phoneInfoArr[i + 1];
		}
		phoneInfoArr[cnt--] = null;
		return true;
	} 
	public void showAll() {
		for(int i = 0; i < cnt; i++)
			phoneInfoArr[i].printInfo();
	}

}
	
