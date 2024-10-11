package classes;

import java.util.ArrayList;
import java.util.List;

public class WildCardExpressionClass {

    public void setValues1 (List<? super Class1> valueList) {
    }
    public void setValues2 (List<? extends Class1> valueList) {
    }

    public static void main(String []args) {
        List<Class1> class1List = new ArrayList<>();
        class1List.add(new Class1());
        class1List.add(new Class2());
        class1List.add(new Class3());

        WildCardExpressionClass wildCardExpressionClass = new WildCardExpressionClass();
        wildCardExpressionClass.setValues1(class1List);

        List<Class2> class2List = new ArrayList<>();
        List<Object> class3List = new ArrayList<>();
/*
        for(Class1 class1: class1List) {
            class2List.add((Class2) class1);
        }
*/
        wildCardExpressionClass.setValues2(class2List);
        wildCardExpressionClass.setValues1(class3List);
    }
}