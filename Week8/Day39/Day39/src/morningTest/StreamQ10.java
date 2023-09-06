package morningTest;

import java.util.List;
import java.util.ArrayList;

class ToyPriceInfo {			// 장난감 모델 별 가격 정보
    private String model;		// 모델 명
    private int price;			// 가격
    
    public ToyPriceInfo(String m, int p) {
        model = m;
        price = p;
    }

    public int getPrice() {
        return price;
    }
    public String getModel() { return model; }
}

class ToyStream {
    public static void main(String[] args) {
        List<ToyPriceInfo> ls = new ArrayList<>();
        ls.add(new ToyPriceInfo("GUN_LR_45", 200));
        ls.add(new ToyPriceInfo("TEDDY_BEAR_S_014", 350));
        ls.add(new ToyPriceInfo("CAR_TRANSFORM_VER_7719", 550));
        
        int sum = ls.stream().filter(e -> e.getPrice() < 500).mapToInt(e -> e.getPrice()).sum();
        System.out.println(sum);
    }
}