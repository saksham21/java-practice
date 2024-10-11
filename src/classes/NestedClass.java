package classes;

// Member Inner class
public class NestedClass {
    int instanceVariable = 10;
    static int classVariable = 20;

    public class InnerClass {

        public void print() {
            System.out.println(instanceVariable + classVariable);
        }
    }
}
