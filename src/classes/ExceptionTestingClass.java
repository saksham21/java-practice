package classes;

import java.io.IOException;

public class ExceptionTestingClass {

    public static void main(String[] args) {
        try {
            method1(0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage() + " ");
        } finally {
            System.out.println("Exception try-catch complete");
            Integer a = 4;
            System.out.println(~a);
        }
    }

    public static void method1(Integer var) throws ArithmeticException{
        if(var == 0) {
            throw new ArithmeticException();
        }
    }
}
