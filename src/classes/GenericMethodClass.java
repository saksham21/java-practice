package classes;

public class GenericMethodClass {

    public <K,V> void print(K key, V val) {
        System.out.println("Testing generic method");
    }
}
