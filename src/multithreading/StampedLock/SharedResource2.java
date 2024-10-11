package multithreading.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource2 {
    int a = 10;

    public void producer(StampedLock lock) {
         // add read lock
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println(stamp + " --> Read Lock acquired by: " + Thread.currentThread().getName());
            a=a+1;
            Thread.sleep(4000);
            if(lock.validate(stamp)) {
                System.out.println("Successfully Update to a= " + a);
            } else {
                System.out.println("RollBack happening !!!");
                a=10;
                System.out.println("Successfully RollBacked to a= " + a);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release read lock here
            stamp = lock.tryOptimisticRead();
            System.out.println(stamp + " --> Read Lock release by: " + Thread.currentThread().getName());
        }
    }

    public void consumer(StampedLock lock) {
        // add write lock
        long stamp = lock.writeLock();
        try {
            System.out.println(stamp + " --> Write Lock acquired by: " + Thread.currentThread().getName());
            a=a-1;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // release write lock here
            System.out.println("Write Lock release by: " + Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }
}
