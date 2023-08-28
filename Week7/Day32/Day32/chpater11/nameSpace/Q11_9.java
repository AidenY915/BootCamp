package nameSpace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank; // 전교등수
	int classRank; // 반등수
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor+eng+math;
	}
	int getTotal() {
		return total;
	}
	float getAverage() {
		return (int)((getTotal()/ 3f)*10+0.5)/10f;
	}
	public int compareTo(Object o) {
		if(o instanceof Student) {
			Student tmp = (Student)o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
	}
	public String toString() {
		return name
				+","+ban
				+","+no
				+","+kor
				+","+eng
				+","+math
				+","+getTotal()
				+","+getAverage()
				+","+schoolRank
				+","+classRank // 새로추가
				;
	}
} // class Student
class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		int banGap = ((Student)o1).ban - ((Student)o2).ban;
		
		return banGap != 0 ? banGap : ((Student)o2).total - ((Student)o1).total;
	}
}
class Exercise11_9 {
	public static void calculateClassRank(List list) {
		// . 먼저 반별 총점기준 내림차순으로 정렬한다
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int cnt = 1;
		for(Object e : list) {
			Student s = (Student)e;
			if(s.ban != prevBan) {
				prevBan = s.ban;
				prevRank = 0;
				prevTotal = -1;
				cnt = 1;
			}
			if(s.total != prevTotal) {
				prevTotal = s.total;
				prevRank+=cnt;
				cnt = 1;
			}
			else {
				cnt++;
			}
			s.classRank = prevRank;
		}
		
		/*
(2) . 아래의 로직에 맞게 코드를 작성하시오
1. list Student . 반복문을 이용해서 에 저장된 객체를 하나씩 읽는다
1.1 ,(ban prevBan ) 반이 달라지면 과 이 다르면
이전 등수 와 이전 총점 을 초기화한다 (prevRank) (prevTotal) .
1.2 (total) (prevTotal) 총점 이 이전총점 과 같으면
이전 등수 를 등수 로 한다 (prevRank) (classRank) .
1.3 , 총점이 서로 다르면
등수 의 값을 알맞게 계산해서 저장한다 (classRank) .
이전에 동점자였다면 그 다음 등수는 동점자의 수를 고려해야 한다 , .
( ) 실행결과 참고
1.4 (prevBan), 현재 반과 총점과 등수를 이전 반
이전 총점 이전 등수 에 저장한다 (prevTotal), (prevRank) .

		 */
	} // public static void calculateClassRank(List list) {
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // list . 먼저 를 총점기준 내림차순으로 정렬한다
		int prevRank = 0; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int cnt = 1;
		for(Object e : list) {
			Student student = (Student)e;
			if(student.total < prevTotal || prevTotal == -1) {
				prevRank+=cnt;
				cnt = 1;
			}
			else {
				cnt++;
			}
			student.schoolRank = prevRank;
			prevTotal = student.total;
		}
	}
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("이자바",2,1,70,90,70)); 
		list.add(new Student("안자바",2,2,60,100,80)); 
		list.add(new Student("홍길동",1,3,100,100,100)); 
		list.add(new Student("남궁성",1,1,90,70,80)); 
		list.add(new Student("김자바",1,2,80,80,90)); 
		calculateSchoolRank(list);
		calculateClassRank(list);
		Iterator it = list.iterator();
		while(it.hasNext())
		System.out.println(it.next());
	}
}