package practice;

import java.util.Objects;

class TmpClass {
	int n;
	String str;
	public TmpClass(int n, String str) {
		super();
		this.n = n;
		this.str = str;
	}
	@Override
	public int hashCode() {
		return Objects.hash(n,str);
	}
}

public class HashTest {

	public static void main(String[] args) {
		TmpClass t1 = new TmpClass(1,"a");
		TmpClass t2 = new TmpClass(1,"a");
		
		System.out.println(t1.hashCode()+" "+t2.hashCode());
	}

}
