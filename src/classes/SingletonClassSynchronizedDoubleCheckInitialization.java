package classes;

// Synchronized Double check Initialization
public class SingletonClassSynchronizedDoubleCheckInitialization {

    // variable is static so it belongs to class, not its object
    // volatile is added so that this value is always accessed from memory and not L1 cache
    // if volatile is not added, then there might be a chance that core saves this variable in cache and then updates to memory.
    // In between, other thread in some other core might not get it from the memory, nor their cache syncs. This will result in
    // null value for our variable
    private static volatile SingletonClassSynchronizedDoubleCheckInitialization singletonClassObj;

    // constructor is private, no new instance can be created from outside the class
    private SingletonClassSynchronizedDoubleCheckInitialization() {}

    // use this method to be called from outside to return class variable
    public static SingletonClassSynchronizedDoubleCheckInitialization getInstance() {
        // we check if the variable is null
        if(singletonClassObj == null) {
            // we add synchronized to create lock for a thread
            synchronized (SingletonClassSynchronizedInitialization.class) {
                // we double check if the variable is null.
                // in case of concurrent threads, For thread1 it will be null, but for Thread2 it won't be null
                if(singletonClassObj == null) {
                    singletonClassObj = new SingletonClassSynchronizedDoubleCheckInitialization();
                }
            }
        }
        return singletonClassObj;
    } 
}
