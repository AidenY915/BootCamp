package morningTest;

import java.util.ArrayList;
import java.util.List;

class ToyStream1 {
    public static void main(String[] args) {
        List<ToyPriceInfo> ls = new ArrayList<>();
        ls.add(new ToyPriceInfo("GUN_LR_45", 200));
        ls.add(new ToyPriceInfo("TEDDY_BEAR_S_014", 350));
        ls.add(new ToyPriceInfo("CAR_TRANSFORM_VER_7719", 550));
        
        ls.stream().filter(e -> e.getModel().length() > 10).map(e -> e.getModel()).forEach(System.out::println);
    }
}