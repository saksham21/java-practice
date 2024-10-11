package classes;

// Eager Initialization - on class load this variable will be created since it's a class variable.
public class SingletonClassEagerInitialization {

    // variable is static so it belongs to class, not its object
    private static SingletonClassEagerInitialization singletonClassObj = new SingletonClassEagerInitialization();

    // constructor is private, no new instance can be created from outside the class
    private SingletonClassEagerInitialization() {}

    // use this method to be called from outside to return class variable
    public static SingletonClassEagerInitialization getInstance() {
        return singletonClassObj;
    }
}
