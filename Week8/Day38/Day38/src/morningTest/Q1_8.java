package morningTest;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

class PredicateDemo {
    public static int sum(Predicate<Integer> p, List<Integer> lst) {
    	int sum = 0;
    	for(Integer e : lst ) {
    		sum += p.test(e) ? e : 0;
    	}
    	return sum;
    }
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 7, 9, 11, 12);
    
        int s;
        s = sum((n) -> n%2 == 0 , list);
        System.out.println("짝수 합: " + s);

        s = sum((n) -> n%2 != 0, list);
        System.out.println("홀수 합: " + s);

    }
}