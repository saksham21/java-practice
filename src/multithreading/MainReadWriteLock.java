package multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainReadWriteLock {

    public static void main(String []args) {
        System.out.println("Main method starts execution by thread: " + Thread.currentThread().getName());
        SharedResourceReadWriteLock sharedResource1 = new SharedResourceReadWriteLock();
        SharedResourceReadWriteLock sharedResource2 = new SharedResourceReadWriteLock();
        ReadWriteLock lock = new ReentrantReadWriteLock(true);
        Thread thread1 = new Thread(() -> {
            sharedResource1.producer(lock);
        });
        thread1.start();

        for(int i=0;i<10;i++) {
            try {
                Thread thread2 = new Thread(() -> {
                    sharedResource2.consumer(lock);
                });
                thread2.start();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Main method starts execution by thread: " + Thread.currentThread().getName());
//                throw new RuntimeException(e);
            }
        }
        System.out.println("Main method ends execution by thread: " + Thread.currentThread().getName());
    }
}
