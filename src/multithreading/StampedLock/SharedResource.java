package multithreading.StampedLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    Boolean isAvailable = false;

     public void producer(StampedLock lock) {
         // add read lock
        long stamp = lock.readLock();
        try {
            System.out.println(stamp +  " " + isAvailable + " --> Read Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(4000);
            isAvailable = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release read lock here
            System.out.println("Read Lock release by: " + Thread.currentThread().getName());
            lock.unlockRead(stamp);
        }
    }

    public void consumer(StampedLock lock) {
        // add write lock
        long stamp = lock.readLock();
        try {
            System.out.println(stamp + " " + isAvailable + " --> Write Lock acquired by: " + Thread.currentThread().getName());
            while(!isAvailable);
            isAvailable = false;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release write lock here
            System.out.println("Write Lock release by: " + Thread.currentThread().getName());
            lock.unlockRead(stamp);
        }
    }
}
