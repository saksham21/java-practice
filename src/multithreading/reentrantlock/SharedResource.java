package multithreading.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    private boolean isAvailable = false;

     public void producer(ReentrantLock lock, Condition condition) {
         // add lock
         lock.lock();
        try {
            System.out.println(isAvailable + "Producer Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(2000);
            while(isAvailable) {
                System.out.println(isAvailable + "Producer Thread waiting: " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release lock here
            System.out.println("Producer Lock release by: " + Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public void consumer(ReentrantLock lock, Condition condition) {
        // add lock
        lock.lock();
        try {
            System.out.println(isAvailable + " --> Consumer Lock acquired by: " + Thread.currentThread().getName());
            while (!isAvailable) {
                System.out.println(isAvailable + "Consumer Thread waiting: " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release lock here
            System.out.println("Consumer Lock release by: " + Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
