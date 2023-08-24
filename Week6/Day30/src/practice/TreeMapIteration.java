package practice;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

	class TreeMapIteration {
		public static void main(String[] args) {
			TreeMap<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			}); 

			// Key-Value ��� ������ ����
			map.put(45, "Brown");
			map.put(37, "James");
			map.put(23, "Martin");

			// Key�� ��� �ִ� �÷��� �ν��Ͻ� ����
			Set<Integer> ks = map.keySet();

			// ��ü Key ��� (for-each�� ���)
			for(Integer n : ks)
				System.out.print(n.toString() + '\t');
			System.out.println();

			// ��ü Value ��� (for-each�� ���)
			for(Integer n : ks)
				System.out.print(map.get(n).toString() + '\t');
			System.out.println();

			// ��ü Value ��� (�ݺ��� ���)
			for(Iterator<Integer> itr = ks.iterator(); itr.hasNext(); )
				System.out.print(map.get(itr.next()) + '\t');
			System.out.println();
		}
	}

	/*
���� ���
23	37	45	
Martin	James	Brown	
Martin	James	Brown	
	 */

	/*
HashSet<E>�� �ؽ� �˰����� ������� �����Ǿ� �ֵ���, HashMap<K, V> ���� �ؽ�
�˰����� ������� �����Ǿ� �ִ�. �׸��� TreeSet<E>�� Ʈ�� �ڷᱸ���� �������
�����Ǿ� �־ ���� ���¸� �����ϵ��� TreeMap<K, V> ���� Ʈ�� �ڷᱸ���� �������
�����Ǿ� �־ ���� ���¸� �����Ѵ�.

���� ���� ��������� Key�� �ش��ϴ� ���� ������ ������������ ��µǾ���. �̷���
��� �÷��� �ν��Ͻ��� ���� ��ȯ�Ǵ� �ݺ����� ������ �޶�����. TreeMap<K, V>
�ν��Ͻ����� ��ȯ�� �ݺ��ڴ� ������������ Key�� �����Ѵ�.
	 */