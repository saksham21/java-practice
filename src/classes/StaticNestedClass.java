package classes;

public class StaticNestedClass {

    int instanceVariable = 10;
    static int classVariable = 20;

    // NestedClass can be public/private/protected/default
    public static class NestedClass {

        public void print() {
//            This in incorrect since instanceVariable is linked to object of StaticNestedClass
//            classVariable is directly linked to StaticNestedClass. No need to create its object here
//            System.out.println(instanceVariable + classVariable);

            StaticNestedClass mainClass = new StaticNestedClass();
            System.out.println(mainClass.instanceVariable + classVariable);
        }
    }
}
