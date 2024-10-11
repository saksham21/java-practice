package classes;

import abstracts.AbstractClass1;

public class AnonymousInnerClass1 {

    public static void main(String args[]) {
        AbstractClass1 abstractClass1Obj = new AbstractClass1(1) {
            @Override
            public void method1() {
                System.out.println("Method1 called");
            }

            @Override
            public void method2() {
                System.out.println("Method2 called");
            }
        };
        abstractClass1Obj.method2();
    }
}
