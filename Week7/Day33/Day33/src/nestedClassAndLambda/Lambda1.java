package nestedClassAndLambda;

interface Printable1 {
    void print(String s);
}

class Lambda1 {
    public static void main(String[] args) {
        Printable1 prn = s -> System.out.println(s);
        prn.print("What is Lambda?");
    }
}

/*
What is Lambda?
*/