package multithreading.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    Boolean isAvailable = false;

     public void producer(Semaphore lock) {
         // add read lock
        try {
            lock.acquire();
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(1000);
            isAvailable = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release read lock here
            System.out.println("Read Lock release by: " + Thread.currentThread().getName());
            lock.release();
        }
    }

    public void consumer(Semaphore lock) {
        // add write lock
        try {
            lock.acquire();
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release write lock here
            System.out.println("Write Lock release by: " + Thread.currentThread().getName());
            lock.release();
        }
    }
}
