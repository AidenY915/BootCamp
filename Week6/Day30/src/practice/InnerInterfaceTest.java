package practice;


interface OuterInterface {
    void outerMethod();

    interface InnerInterface {
        void innerMethod();
    }
}

class OuterClass implements OuterInterface { 
    @Override
    public void outerMethod() {
        System.out.println("Outer method implementation");
    }

    // InnerInterface를 구현하지 않음

    public static void main(String[] args) {
    	OuterClass outerObj = new OuterClass();
        outerObj.outerMethod();
    }
}
