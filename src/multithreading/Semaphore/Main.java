package multithreading.Semaphore;

import multithreading.MyThreadClass1;
import multithreading.MyThreadClass2;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main method start by thread - " + Thread.currentThread().getName());
        SharedResource sharedResource = new SharedResource();
        Semaphore semaphore = new Semaphore(2);
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(() -> {
                sharedResource.producer(semaphore);
            });
            thread.start();
        }
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(() -> {
                sharedResource.consumer(semaphore);
            });
            thread.start();
        }
        System.out.println("Main method finish by thread - " + Thread.currentThread().getName());

    }
}
