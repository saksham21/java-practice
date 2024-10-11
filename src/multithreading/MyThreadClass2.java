package multithreading;

public class MyThreadClass2 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThreadClass2 run by - " + Thread.currentThread().getName());
    }
}
