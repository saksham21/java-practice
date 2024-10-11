package multithreading;

public class MyThreadClass1 implements Runnable{
    volatile int counter = 0;

    @Override
    synchronized public void run() {
        System.out.println("Inside MyThreadClass1 run - by " + Thread.currentThread().getName() + " --> counter is" + (counter++));
    }
}
