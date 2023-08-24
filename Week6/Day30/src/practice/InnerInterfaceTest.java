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

    // InnerInterface�� �������� ����

    public static void main(String[] args) {
    	OuterClass outerObj = new OuterClass();
        outerObj.outerMethod();
    }
}
