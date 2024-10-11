package classes;

public class GenericClass3<K,V> {

    K key;
    V val;

    public void put(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public static void main(String []args) {
        GenericClass3<Integer, String> genericClass3 = new GenericClass3<>();
        genericClass3.put(123, "Saksham");
        System.out.println(genericClass3.key);
        System.out.println(genericClass3.val);
    }
}
