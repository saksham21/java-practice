package classes;

public class GenericClass2<T> {

    T val;

    public void setVal(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public static void main(String []args) {
        GenericClass2<Integer> genericClass2 = new GenericClass2<Integer>();
        genericClass2.setVal(123);
        Integer val = genericClass2.getVal();
        if(val >= 100) {
            System.out.println("Win");
        } else {
            System.out.println("Lose");
        }
    }
}
