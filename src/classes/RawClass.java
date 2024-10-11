package classes;

public class RawClass {

    public static void main(String []args) {
        GenericClass2<Integer> parametrizedClassObj = new GenericClass2<>();
        parametrizedClassObj.setVal(1);
        System.out.println(parametrizedClassObj.getVal());

        GenericClass2 rawClassObj = new GenericClass2();
        rawClassObj.setVal(1);
        System.out.println(rawClassObj.getVal());
        rawClassObj.setVal("abc");
        System.out.println(rawClassObj.getVal());
    }
}
