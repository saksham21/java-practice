package interfaces;

public interface InterfaceWithStaticMethod {

    // this static method cannot be overwritten by classes which implements it
    static boolean canUse() {
        return true;
    }
}
