package classes;

public class LocalInnerClass {

    int instanceVariable = 10;
    static int classVariable = 20;

    public void display() {
        int methodLocalVariable = 30;

        class InnerClass {
            int localInnerVariable = 40;

            public void print() {
                System.out.println(instanceVariable + classVariable + methodLocalVariable + localInnerVariable);
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.print();
    }

    public class InnerClass1 {
        int innerClass1 = 5;

        public void print() {
            System.out.println(innerClass1);
        }
    }

    public class InnerClass2 extends InnerClass1 {
        int innerClass2 = 6;

        @Override
        public void print() {
            System.out.println(instanceVariable + classVariable + innerClass1 + innerClass2);
        }
    }
}
