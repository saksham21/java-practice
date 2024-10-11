package classes;

// Lazy Initialization - variable will be created only when getInstance() is called.
public class SingletonClassLazyInitialization {

    // variable is static so it belongs to class, not its object
    private static SingletonClassLazyInitialization singletonClassObj;

    // constructor is private, no new instance can be created from outside the class
    private SingletonClassLazyInitialization() {}

    // use this method to be called from outside to return class variable
    public static SingletonClassLazyInitialization getInstance() {
        if(singletonClassObj == null) {
            singletonClassObj = new SingletonClassLazyInitialization();
        }
        return singletonClassObj;
    }
}
