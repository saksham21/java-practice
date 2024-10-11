package classes;

import abstracts.AbstractClass2;

public class ConcreteClassFromAbstractClass extends AbstractClass2 {

    public ConcreteClassFromAbstractClass(int var) {
        super(var);
    }

    @Override
    public void method4() {

    }

    @Override
    public void method2() {

    }

    // this is optional since method1 is already added in AbstractClass2
    // But if we want to create method1() for this class, then we can add too
    @Override
    public void method1() {
        System.out.println("In ClassFromAbstractClass Method1");
    }

}
