package morningTest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SLenComparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Robot");
        list.add("Lambda");
        list.add("Box");

        Collections.sort(list, (s1,s2) -> s1.compareTo(s2));    // 정렬

        for(String s : list)
            System.out.println(s);
    }
}