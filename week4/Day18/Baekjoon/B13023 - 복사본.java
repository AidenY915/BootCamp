import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Iterator;

class Person {
	int idx;
	byte visit;
	LinkedList<Person> incidence = new LinkedList<Person>();
	Person(int _idx) {idx = _idx;}
	int cnt;
	int findRelationship5(int _cnt) {
		if(visit == 1) return -1;
		visit = 1;
		cnt = _cnt+1;
		int rslt = cnt;				//예제 3번 cnt는 초기값을 유지해야 다음 반복자에서 이전 반복과 독립적으로 카운터를 보냄
		if(rslt >= 5) {
			visit = 0;
			return rslt;
		}
		Iterator<Person> iterator = incidence.iterator();
		while(iterator.hasNext()) {
			int tmp = iterator.next().findRelationship5(cnt);
			rslt = rslt > tmp ? rslt : tmp;	
			if(rslt >= 5) {
				visit = 0;					//0으로 초기화 안해주면 사이클이 있는 곳은 다른 갈림길 가능성을 제거
				return rslt;
			}
		}
		visit = 0;
		return rslt;
	}
}

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		Person[] personArr = new Person[n];
		for(int i = 0 ; i<n ; i++)
			personArr[i] = new Person(i);
		for(int i = 0 ; i < m ; i++) {
			input = br.readLine().split(" ");
			int f1 = Integer.parseInt(input[0]);
			int f2 = Integer.parseInt(input[1]);
			personArr[f1].incidence.add(personArr[f2]);
			personArr[f2].incidence.add(personArr[f1]);
		}
		br.close();
		for(int i = 0 ; i<n ; i++){
		/*	for(int j = 0 ; j < i ;j++)
				personArr[j].visit = 1;	*/
			if(personArr[i].findRelationship5(0) >= 5) {		//앞의 visit들은 -로 해도 됨, 2 반복자면 1을 거치는 루트는 다 확인 했기 때문. 쌍방향이라	//절대 안됨. 시작점이 중간인 경우를 생각하지 않기 때문
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);

	}

}