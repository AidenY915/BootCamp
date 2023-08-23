package test;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Person implements Comparable<Person>
{
    String name;
    int age;

    public Person(String name, int age)
    {
        this.name=name;
        this.age=age;
    }
    public void showData()
    {
    	System.out.printf("%s %d \n", name, age);
    }
    public int compareTo(Person p)
    {
        if(age>p.age)
            return 1;
        else if(age<p.age)
            return -1;
        else	
            return 0;
    }
}

class ComparablePerson 
{
	public static void main(String[] args)
	{
		TreeSet<Person> sTree=new TreeSet<Person>(new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.name.compareTo(p2.name);
			}
		});
		sTree.add(new Person("Lee", 24));
		sTree.add(new Person("Hong", 29));
		sTree.add(new Person("Choi", 21));
		
		Iterator<Person> itr=sTree.iterator();
		while(itr.hasNext())
			itr.next().showData();
	}
}