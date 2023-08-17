
public class Q9_13 {
	public static void main(String[] args) {
		String src = "aabbccAABBCCaa";
		System.out.println(src);
		System.out.println("aa " + stringCount(src, "aa") +" 를 개 찾았습니다.");
	}
	static int stringCount(String src, String key) {
		return stringCount(src, key, 0);
	}
	static int stringCount(String src, String key, int pos) {
		int count = 0;
		int index = 0;
		if (key == null || key.length() == 0)
			return 0;
		
		if(pos >= src.length()) return 0;
		index = pos;
		while(index < src.length()) {
			index = src.indexOf(key, index);
			if(index == -1) break;
			index++;
			count++;
		}
		return count;
	}
}
