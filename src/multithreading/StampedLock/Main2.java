package multithreading.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class Main2 {

    public static void main(String []args) {
        System.out.println("Main method starts execution by thread: " + Thread.currentThread().getName());
        SharedResource2 sharedResource = new SharedResource2();
        StampedLock lock = new StampedLock();
        Thread thread1 = new Thread(() -> {
            sharedResource.producer(lock);
        });
        Thread thread2 = new Thread(() -> {
            sharedResource.consumer(lock);
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main method ends execution by thread: " + Thread.currentThread().getName());
    }
}
