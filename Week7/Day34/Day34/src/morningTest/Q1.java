package morningTest;

import java.util.TreeSet;

class Student implements Comparable<Student>{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	Student(String name, int ban, int no, int kor, int eng, int math) {
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
	public int compareTo(Student o) {
		return getTotal() - o.getTotal();
	}
	
	public void print() {
		System.out.printf("%s, %d, %d, %d, %d, %d, %d, %.1f\n",name, ban, no, kor, eng, math, getTotal(), getAvg());
	}
	
	public static int count(TreeSet<Student> studentSet, int start, int end) {
		return studentSet.subSet(new Student(null, 0, 0, start, start, start), new Student(null, 0, 0, end, end, end)).size();
	}
	
	public static void printAll(TreeSet<Student> studentSet) {
		for(Student e : studentSet)
			e.print();
		for(int i = 60; i <= 80; i+=10) { 
			System.out.printf("[%d~%d] %d\n", i, i+9, count(studentSet, i, i+10));
			
		}
		System.out.printf("[%d~%d] %d\n", 90, 100, count(studentSet, 90, 101));
	}
}

public class Q1 {

	public static void main(String[] args) {
		TreeSet<Student> studentSet = new TreeSet<>();
		studentSet.add(new Student("이자바",1,4,70,90,70));
		studentSet.add(new Student("남궁성",1,2,90,70,80));
		studentSet.add(new Student("김자바",1,3,80,80,90));
		studentSet.add(new Student("홍길동",1,1,100,100,100));
		Student.printAll(studentSet);
	}

}
