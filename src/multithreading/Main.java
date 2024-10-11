package multithreading;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main method start by thread - " + Thread.currentThread().getName());
        MyThreadClass1 myThreadClass1 = new MyThreadClass1();
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(myThreadClass1);
            thread.start();
        }
        System.out.println("Main method finish by thread - " + Thread.currentThread().getName());

        System.out.println("Main method start by thread - " + Thread.currentThread().getName());
        MyThreadClass2 myThreadClass2 = new MyThreadClass2();
        myThreadClass2.start();
        System.out.println("Main method finish by thread - " + Thread.currentThread().getName());

    }
}
