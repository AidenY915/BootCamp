package PhoneBookManager;

class PhoneBook implements Nums {
	private static PhoneBook pb;
	private PhoneInfo[] piArr;
	private int cnt;

	private PhoneBook() {
		piArr = new PhoneInfo[MAX];
	};
	public static PhoneBook getPhoneBook() {
		if(pb == null)
			pb = new PhoneBook();
		return pb;
	}
	private void pushRight(int start, int end) {
		PhoneInfo tmp = piArr[end];
		for(int i = end; i > start; i--) {
			piArr[i] = piArr[i - 1];
		}
		piArr[start] = tmp;
	}
	public boolean add(byte type, String[] input) {
		if(cnt == MAX) return false;
		switch (type) {
		case TYPE_NORMAL: piArr[cnt++] = new PhoneInfo(input[0], input[1]); break;
		case TYPE_UNIV: piArr[cnt++] = new PhoneUnivInfo(input[0], input[1], input[2], Integer.parseInt(input[3])); break;
		case TYPE_COMPANY: piArr[cnt++] = new PhoneCompanyInfo(input[0], input[1], input[2]); break;
		}
		String name = piArr[cnt - 1].getName();
		if(cnt == 1 || name.compareTo(piArr[cnt - 2].getName()) >= 0) return true;
		for(int i = 0; i < cnt - 1 ; i++) {
			if(name.compareTo(piArr[i].getName()) < 0) {
				pushRight(i, cnt - 1);
				break;
			}
		}
		return true;
	}

	public String search(String name) {
		StringBuilder sb = new StringBuilder(50);
		boolean isFound = false;
		for(int i = 0; i < cnt; i++) {
			if(name.equals(piArr[i].getName())) {
				sb.append(piArr[i].getInfo());
				isFound = true;
			}
		}
		if(isFound) return sb.toString();
		return null;
	}

	private int binarySearchReturnIdx(String number) {
		int start = 0, end = cnt - 1;
		while(start <= end) {
			int mid = (start+end)/2;
			if(number.equals(piArr[mid].getNumber())) return mid;
			else if(number.compareTo(piArr[mid].getNumber()) < 0) end = mid - 1;
			else start = mid + 1;
		}
		return -1;
	}
	private void pushLeft(int start, int end) {
		for(int i = start; i < end; i++) {
			piArr[i] = piArr[i + 1];
		}
	}
	public boolean delete(String number) {
		int idx = binarySearchReturnIdx(number);
		if(idx == -1) return false;
		pushLeft(idx, cnt - 1);
		return true;
	}

	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < cnt; i++) {
			sb.append(piArr[i].getInfo());
		}
		return sb.toString();
	}

}
