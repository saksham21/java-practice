package interfaces;

public interface Interface1 {

    public void method1();
    default void method4() {
        System.out.println("Interface1 default method4");
    }

    default void method5() {
        System.out.println("Interface1 default method5");
    }
}
