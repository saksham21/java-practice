package multithreading.reentrantlock;

import multithreading.MyThreadClass1;
import multithreading.MyThreadClass2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main method start by thread - " + Thread.currentThread().getName());
        SharedResource sharedResource = new SharedResource();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(() -> {
                sharedResource.producer(lock, condition);
            });
            thread.start();
        }
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(() -> {
                sharedResource.consumer(lock, condition);
            });
            thread.start();
        }
        System.out.println("Main method finish by thread - " + Thread.currentThread().getName());

    }
}
