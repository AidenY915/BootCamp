package Stream;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.DoubleStream;

class GradeAverage90 {
    public static void main(String[] args) {
        ReportCard[] cards = {
            new ReportCard(98, 84, 90),
            new ReportCard(92, 87, 95),
            new ReportCard(85, 99, 93)
        };       
        if(Stream.of(cards).allMatch(e -> e.getEng()+e.getKor()+e.getMath() >= 270))
        	System.out.println("모두 평균 90 이상입니다.");
        if(Stream.of(cards).anyMatch(e -> e.getEng()+e.getKor()+e.getMath() >= 270))
        	System.out.println("평균 90 이상이 한명 이상입니다.");


    }
}
