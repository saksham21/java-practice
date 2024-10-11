package classes;

import interfaces.*;

public class ConcreteClass3 implements Interface2WithInnerInterface {
    @Override
    public void method2() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method5() {
        System.out.println("ConcreteClass3 method5");
    }

    private Integer privateMethod1() {
        System.out.println("privateMethod1 invoked!!!");
        return 1;
    }

    Integer privateMethod2() {
        return 1;
    }

    public Integer privateMethod3() {
        return 1;
    }

    protected Integer privateMethod4() {
        return 1;
    }
}
