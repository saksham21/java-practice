package classes;

// this is not Generic class but shows why generic subclass is good to implement
public class GenericClass1 {

    Object val;

    public void setVal(Object val) {
        this.val = val;
    }

    public Object getVal() {
        return val;
    }

    public static void main(String []args) {
        GenericClass1 genericClass1 = new GenericClass1();
        genericClass1.setVal(123);
//        Invalid since return type in Object and we will need to type-cast it
//        Integer val = genericClass1.getVal();
        Object val = genericClass1.getVal();
        if((Integer) val >= 100) {
            System.out.println("Win");
        } else {
            System.out.println("Lose");
        }
    }
}
