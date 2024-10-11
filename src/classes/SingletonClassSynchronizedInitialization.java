package classes;

// Synchronized Initialization
public class SingletonClassSynchronizedInitialization {

    // variable is static so it belongs to class, not its object
    private static SingletonClassSynchronizedInitialization singletonClassObj;

    // constructor is private, no new instance can be created from outside the class
    private SingletonClassSynchronizedInitialization() {}

    // use this method to be called from outside to return class variable
    // synchronized will resolve concurrency issue
    // Each thread will hold lock of this method, access it, then unlock it. Will resolve concurrency but will make entire system slow
    synchronized public static SingletonClassSynchronizedInitialization getInstance() {
        if(singletonClassObj == null) {
            singletonClassObj = new SingletonClassSynchronizedInitialization();
        }
        return singletonClassObj;
    } 
}
