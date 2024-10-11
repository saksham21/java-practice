package classes;

import interfaces.Interface1;

public class AnonymousInnerClass2 {

    public static void main(String args[]) {
        Interface1 interfaceClass = new Interface1() {
            @Override
            public void method1() {
                System.out.println("In method1");
            }
        };
        interfaceClass.method1();
    }
}
