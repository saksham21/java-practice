package multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResourceReadWriteLock {

     public void producer(ReadWriteLock lock) {
         // add read lock

        try {
            Thread.sleep(4000);
            lock.readLock().lock();
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release read lock here
            System.out.println("Read Lock release by: " + Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void consumer(ReadWriteLock lock) {
        // add write lock
        try {
            lock.writeLock().lock();
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release write lock here
            System.out.println("Write Lock release by: " + Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
}
