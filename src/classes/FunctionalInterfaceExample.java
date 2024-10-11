package classes;

import interfaces.CustomFunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {

    public static void main(String []args) {
        Consumer<Integer> objA = (Integer var) -> {
            System.out.println("Consumer variable is: " +  var);
        };

        objA.accept(1);

        Supplier<String> objB = () -> {
            String r = "My String";
            System.out.println("Supplier returns: " +  r);
            return r;
        };
        objB.get();

        Function<Integer, String> objC = (Integer var1) -> {
            String r;
            if(var1 >= 10) {
                r = "Win";
            } else {
                r = "Lose";
            }
            System.out.println("Function returns: " +  r + " for variable: " + var1);
          return r;
        };
        objC.apply(1);

        Predicate<Integer> objD = (Integer var) -> {
            return var >= 10;
        };

        Predicate<Integer> objE = (Integer var) -> var >= 10;
        System.out.println(objD.test(4));
        System.out.println(objE.test(4));

        CustomFunctionalInterface<Integer, String> customFunctionalInterfaceObj = (Integer... v1) -> {
            for(int i=1;i<v1.length;i++) {
                if(v1[i-1] != v1[i]) {
                    return "All vars are not equal";
                }
            }
            return "All vars are equal";
        };

        System.out.println(customFunctionalInterfaceObj.getMethdodResult(1,1,1,1));
        System.out.println(customFunctionalInterfaceObj.getMethdodResult(1,2,1,4));

        List<String> a = Arrays.asList("a","b","B");
        printVals(a,a,a,a);
    }

    // heap pollution example - how to do
    public static void printVals(List<String>... valueList) {
        Object[] objectList = valueList;

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        objectList[0] = integerList;
    }
}
