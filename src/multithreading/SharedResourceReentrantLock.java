package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceReentrantLock {

     public void producer(ReentrantLock lock) {
         // add lock
         lock.lock();
        try {
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release lock here
            System.out.println("Lock release by: " + Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
