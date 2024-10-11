package threadpoolexecutor;

import classes.*;
import enums.SimpleEnumImplementsInteface;
import enums.SimpleEnumWithMethodOverride;
import interfaces.Interface1;
import multithreading.MyThreadClass1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

//        Executors.defaultThreadFactory()
//        new ThreadPoolExecutor.DiscardPolicy()
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new CustomRejectHandler());

        executor.allowCoreThreadTimeOut(true);

        for(int i=1;i<=7;i++) {
            executor.submit(()-> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Task processed by: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}