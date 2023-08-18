
import java.util.Arrays;

class Person1 implements Comparable<Person1> {
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }    
    @Override
    public String toString() {
        return name + ": " + age;
    }

	@Override
	public int compareTo(Person1 p) {
		if(this.age < p.age)		//age가 private인데 어떻게 p의 age에 직접 접근하지? 같은 클래스라서 가능한가? 맞다.
            return 1;
        else if(this.age > p.age)
            return -1;
        else
            return 0;
	}
}

class Person2 implements Comparable<Person2> {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }    
    @Override
    public String toString() {
        return name + ": " + age;
    }
    
	@Override
	public int compareTo(Person2 p) {
		return this.name.length() - p.name.length();
	}
}

class Person3 implements Comparable<Person3> {
    private String name;
    private int age;

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }    
    @Override
    public String toString() {
        return name + ": " + age;
    }
	@Override
	public int compareTo(Person3 p) {
		return name.compareTo(p.name);
	}
}

class ArrayObjSort {
    public static void main(String[] args) {
        Person1[] ar1 = new Person1[3];

        ar1[0] = new Person1("Lee", 29);
        ar1[1] = new Person1("Goo", 15);
        ar1[2] = new Person1("Soo", 37);

        Arrays.sort(ar1);
        for(Person1 p : ar1) 
            System.out.println(p);
        
        Person2[] ar2 = new Person2[3];

        ar2[0] = new Person2("1", 29);
        ar2[1] = new Person2("sd", 15);
        ar2[2] = new Person2("abc", 37);

        Arrays.sort(ar2);
        for(Person2 p : ar2) 
            System.out.println(p);
        
        
        Person3[] ar3 = new Person3[3];
        
        ar3[0] = new Person3("Lee", 29);
        ar3[1] = new Person3("Goo", 15);
        ar3[2] = new Person3("Soo", 37);

        Arrays.sort(ar3);
        for(Person3 p : ar3) 
            System.out.println(p);
    }
}
