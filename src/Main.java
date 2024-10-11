import classes.*;
import enums.*;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConcreteClassFromAbstractClass c = new ConcreteClassFromAbstractClass(2);
        System.out.println(c.getClass());

        StaticNestedClass.NestedClass nestedClass = new StaticNestedClass.NestedClass();
        nestedClass.print();

        NestedClass.InnerClass innerClass = new NestedClass().new InnerClass();
        innerClass.print();

        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.display();

        LocalInnerClass.InnerClass2 innerClass2 = new LocalInnerClass().new InnerClass2();
        innerClass2.print();

        Interface1 interface1 = new Interface1() {
            @Override
            public void method1() {
                System.out.println("Inteface1 method1 called by saksham");
            }
        };
        MultiBoundedGenericClass<Interface1> multiBoundedGenericClass = new MultiBoundedGenericClass<>();
        multiBoundedGenericClass.setVar(interface1);
        System.out.println(multiBoundedGenericClass.getVar());
        multiBoundedGenericClass.getVar().method1();


        SimpleEnumWithMethodOverride.MONDAY.dummyMethod();
        SimpleEnumWithMethodOverride.TUESDAY.dummyMethod();

        SimpleEnumImplementsInteface.MONDAY.method1();
        SimpleEnumImplementsInteface.SUNDAY.method1();

        List<Integer> intList = new ArrayList<>();
//        intList.stream()

        ConcreteClass3 concreteClass3Obj = new ConcreteClass3();
        concreteClass3Obj.method4();
        concreteClass3Obj.method5();
    }
}