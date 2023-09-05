package morningTest;

import java.util.function.ToIntBiFunction;

class NoObjectMethodRef_1 {
    public static void main(String[] args) {
        IBox ib1 = new IBox(5);
        IBox ib2 = new IBox(7);

        // 두 상자에 저장된 값 비교하여 더 큰 값 반환
        ToIntBiFunction<IBox, IBox> bf = IBox::larger; // 람다식
        int bigNum = bf.applyAsInt(ib1,ib2);
        System.out.println(bigNum);}
}
