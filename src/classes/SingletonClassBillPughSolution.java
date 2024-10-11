package classes;

// Bill Pugh Solution
public class SingletonClassBillPughSolution {

    // create another class which stores the class object
    private static class SingletonHelperClass {
        // create static final variable of the class object
        // it will not be called on application startup, thus resolving issue in Eager Initialization.
        private static final SingletonClassBillPughSolution SINGLETON_CLASS_OBJ = new SingletonClassBillPughSolution();
    }

    // constructor is private, no new instance can be created from outside the class
    private SingletonClassBillPughSolution() {}

    // use this method to be called from outside to return class variable
    public static SingletonClassBillPughSolution getInstance() {
        return SingletonHelperClass.SINGLETON_CLASS_OBJ;
    }
}
