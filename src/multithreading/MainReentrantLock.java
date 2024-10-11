package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class MainReentrantLock {

    public static void main(String []args) {
        System.out.println("Main method starts execution by thread: " + Thread.currentThread().getName());
        SharedResourceReentrantLock sharedResource = new SharedResourceReentrantLock();
        ReentrantLock lock = new ReentrantLock();
        Thread producerThread = new Thread(() -> {
//            System.out.println("Inside producerThread. About to addItem by thread: " + Thread.currentThread().getName());
            sharedResource.producer(lock);
//            System.out.println("Inside producerThread. Item Added by thread: " + Thread.currentThread().getName());
        });

        Thread consumerThread = new Thread(() -> {
//            System.out.println("Inside consumerThread. About to addItem by thread: " + Thread.currentThread().getName());
            sharedResource.producer(lock);
//            System.out.println("Inside consumerThread. Item Added by thread: " + Thread.currentThread().getName());
        });

        producerThread.start();
        consumerThread.start();
        System.out.println("Main method ends execution by thread: " + Thread.currentThread().getName());
    }
}
