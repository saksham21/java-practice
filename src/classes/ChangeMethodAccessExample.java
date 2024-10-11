package classes;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ChangeMethodAccessExample {
    public static void main(String[] args) {
        try {
            // Create an instance of the ExampleClass
            ExampleClass example = new ExampleClass();

            // Get the private method using reflection
            Method privateMethod = ExampleClass.class.getDeclaredMethod("privateMethod");

            // Print the original access modifier
            System.out.println("Original access modifier: " + Modifier.toString(privateMethod.getModifiers()));

            // Change the method's accessibility to allow invocation
            privateMethod.setAccessible(true);

            // Try to print the new access modifier
            // Note: The modifier will not change, it will still show as private
            System.out.println("Access modifier after setAccessible: " + Modifier.toString(privateMethod.getModifiers()));

            // Invoke the private method
            privateMethod.invoke(example);


            Field modifiersField = Method.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(privateMethod, 1);

            System.out.println("Access modifier after setAccessible: " + Modifier.toString(privateMethod.getModifiers()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ExampleClass {
    private void privateMethod() {
        System.out.println("Private method invoked");
    }
}

