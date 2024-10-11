package interfaces;

public interface Interface2WithInnerInterface extends Interface1{

    public void method2();

    public interface InnerInterface2 {
        public void method1();
        public void method2();
        public void method3();
    }

    default void method4() {
        Interface1.super.method4();
        System.out.println("Interface2 default method4");
    };

    // made this method abstract in this child interface, although its present in Interface1 as default
    void method5();

    // default is added in Java8
    default void method6() {
        staticMethod();
        privateMethod();
        privateStaticMethod();
    }

    // static is added in Java8
    static void staticMethod() {
        // we can only call other static methods from a static method
        privateStaticMethod();
    }

    // private method is added in Java9
    private void privateMethod() {
        // private methods can call static and non-static methods
        privateStaticMethod();
        staticMethod();
    }

    // private static method is added in Java9
    private static void privateStaticMethod() {}
}
