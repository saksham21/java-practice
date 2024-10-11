package abstracts;

public abstract class AbstractClass1 {

//    public AbstractClass1() {}
    int var1;
    public AbstractClass1(int var1) {
        this.var1 = var1;
    }

    public abstract void method1();

    public abstract void method2();

    public void method3() {
        System.out.println("In AbstractClass1 Method3");
    }
}
