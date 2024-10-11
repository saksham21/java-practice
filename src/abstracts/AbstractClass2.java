package abstracts;

public abstract class AbstractClass2 extends AbstractClass1{
    public AbstractClass2(int var1) {
        super(var1);
    }

    @Deprecated
    public abstract void method4();

    @Override
    public void method1() {
        System.out.println("In AbstractClass2 Method1");
    }
}
