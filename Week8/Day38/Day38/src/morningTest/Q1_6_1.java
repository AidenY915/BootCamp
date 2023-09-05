package morningTest;

import java.util.Random;

interface Generator {
    int rand();    // 매개변수 없는 메소드
}

class NoParamAndReturn {
    public static void main(String[] args) {
        Generator gen = ()->new Random().nextInt(50);
        System.out.println(gen.rand());
    }
}

//함수형 인터페이스란 추상 메소드가 오직 하나인 인터페이스를 의미한다. 디폴트나 스태틱 메소드의 수는 상관 없으며,
//추상 메소드가 오직 하나이므로, 람다식으로 표현할 수 있다.
//대표적인 예시로는 java.util.function 패키지에 있는 Predicate Consumer Supplier Function등이 있다.