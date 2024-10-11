package interfaces;

@FunctionalInterface
public interface FunctionalInterface1 {

    void method(String var);

    // cannot add another abstract method due to @FunctionalInterface
//    void method2(String var);

    // default and static methods can be added
    default void method2(String var) {
        System.out.println("default method2 of FunctionalInterface1 interface");
    }

    static void method3(String var) {
        System.out.println("static method3 of FunctionalInterface1 interface");
    }

    // Object class methods CAN also be added since we don't need to provide its impl in class file which implements this interface
    String toString();
}
