package multithreading.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class Main {

    public static void main(String []args) {
        System.out.println("Main method starts execution by thread: " + Thread.currentThread().getName());
        SharedResource sharedResource1 = new SharedResource();
        SharedResource sharedResource2 = new SharedResource();
        StampedLock lock = new StampedLock();
        Thread thread1 = new Thread(() -> {
            sharedResource1.producer(lock);
        });
        Thread thread2 = new Thread(() -> {
            sharedResource1.consumer(lock);
        });
        thread1.start();
        thread2.start();
        System.out.println("Main method ends execution by thread: " + Thread.currentThread().getName());
    }
}
