package morningTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Student1 implements Comparable<Student1>{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	private int rank;
	private int classRank;
	Student1(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int getTotal() {
		return kor + eng +math;
	}
	public double getAvg() {
		return getTotal() / 3.0;
	}

	@Override
	public int compareTo(Student1 o) {
		return getTotal() - o.getTotal();
	}

	public String toString() {
		return name + " " + ban + " "  + no + " " + kor + " " + eng + " " + math + " " + getTotal() + " " + String.format("%.1f",getAvg()) + " " + rank + " " + classRank;
	}
	public static void calculateSchoolRank(ArrayList<Student1> list) {
		Collections.sort(list, (o1,o2) -> o2.getTotal() - o1.getTotal());
		int len = list.size();
		for(int i = 0; i < len; i++) {
			list.get(i).rank = (i+1);
			if(i == 0) continue;
			if(list.get(i).getTotal() == list.get(i-1).getTotal())
				list.get(i).rank = list.get(i-1).rank;
		}
	}
	public static void calculateClassRank(ArrayList<Student1> list) {
		Collections.sort(list, (o1,o2) -> {
			int banGap = o1.ban - o2.ban;
		return banGap == 0 ? o2.getTotal() - o1.getTotal() : banGap;});
		
		int len = list.size();
		int rank = 1;
		int prevBan = -1;
		int prevTotal = -1;
		for(int i = 0; i < len; i++) {
			if(prevBan != list.get(i).ban)
				rank = 1;
			list.get(i).classRank = rank;
			if(list.get(i).getTotal() == prevTotal && rank != 1)
				list.get(i).classRank = list.get(i-1).classRank;
			prevTotal = list.get(i).getTotal();
			prevBan = list.get(i).ban;
			rank++;
		}
	}
}

public class Q2 {
	public static void main(String[] args) {
		ArrayList<Student1> list = new ArrayList<Student1>();
		list.add(new Student1("이자바",2,1,70,90,70)); 
		// 이름, 반, 번호, 국어, 영어, 수학
		list.add(new Student1("안자바",2,2,60,100,80)); 
		list.add(new Student1("홍길동",1,3,100,100,100)); 
		list.add(new Student1("남궁성",1,1,90,70,80)); 
		list.add(new Student1("김자바",1,2,80,80,90));
		Student1.calculateSchoolRank(list);
		Student1.calculateClassRank(list);
		Iterator<Student1> it = list.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
