package threadpoolexecutor;

import multithreading.MyThreadClass1;

import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) {

//        Executors.defaultThreadFactory()
//        new ThreadPoolExecutor.DiscardPolicy()
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        executor.allowCoreThreadTimeOut(true);

        Future<?> futureObj = executor.submit(()-> {
            System.out.println("Task processing by: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task processed by: " + Thread.currentThread().getName());
        });

        System.out.println(futureObj.isDone());
        executor.shutdown();
    }
}