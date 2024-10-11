package threadpoolexecutor;

import java.sql.Time;
import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) {

//        Executors.defaultThreadFactory()
//        new ThreadPoolExecutor.DiscardPolicy()
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        executor.allowCoreThreadTimeOut(true);

        Future<?> futureObj = executor.submit(()-> {
            System.out.println("Task processing by: " + Thread.currentThread().getName());
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task processed by: " + Thread.currentThread().getName());
        });

        System.out.println("Is Done? : " + futureObj.isDone());

        try {
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            System.out.println("exception in future get call with msg: " + e.getMessage());
//            throw new RuntimeException(e);
        }

        try {
            futureObj.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Is Done? : " + futureObj.isDone());
        System.out.println("Is Cancelled? : " + futureObj.isCancelled());

        executor.shutdown();
    }
}