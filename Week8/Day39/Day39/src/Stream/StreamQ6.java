package Stream;

import java.util.Arrays;

class ReportCard {
    private int kor;    // 국어 점수
    private int eng;    // 영어 점수
    private int math;    // 수학 점수
    
    public ReportCard(int k, int e, int m) {
        kor = k;
        eng = e;
        math = m;    
    }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }
}


class GradeAverage2 {
    public static void main(String[] args) {
        ReportCard[] cards = {
            new ReportCard(70, 80, 90),
            new ReportCard(90, 80, 70),
            new ReportCard(80, 80, 80)
        };       
        double avg = Arrays.stream(cards).mapToDouble((e) -> (e.getEng()+e.getKor()+e.getMath())/3.0).average().orElse(0);
        System.out.println(avg);
        
     }
}