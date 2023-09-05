package morningTest;

interface Calculate1 {
    int cal(int a, int b);
}

class TwoParamAndReturn {
    public static void main(String[] args) {
        Calculate1 c;
        
        c = (a,b) -> {
        	System.out.println(a+b);
        	return a+b;
        };
        System.out.println(c.cal(4, 3));
    }
}