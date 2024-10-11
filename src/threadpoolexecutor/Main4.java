package threadpoolexecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main4 {
    public static void main(String[] args) {

//        Executors.defaultThreadFactory()
//        new ThreadPoolExecutor.DiscardPolicy()
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        executor.allowCoreThreadTimeOut(true);

        Future<?> futureObj1 = executor.submit(()-> System.out.println("Task processed by: " + Thread.currentThread().getName()));

        System.out.println("Is Done? : " + futureObj1.isDone());

        try {
            Object futureObjResult =  futureObj1.get();
            System.out.println(futureObjResult == null);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // .submit(Runnable r)
        List<String> listStr = new ArrayList<>();
        Future<List<String>> futureObj2 = executor.submit(()-> {
            listStr.add("Hello Saksham From Runnable");
            System.out.println("Task processed by: " + Thread.currentThread().getName());
        }, listStr);

        // .submit(Runnable r, V value)
        try {
            List<String> list = futureObj2.get();
            System.out.println(list.size() + " --> " + list.get(0));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // .submit(Callable r)

        Future<List<String>> futureObj3 = executor.submit(() -> {
            System.out.println("Task processed by: " + Thread.currentThread().getName());
            return new ArrayList<>(Arrays.asList("Hello Saksham From Callable"));
        });
        try {
            List<String> list = futureObj3.get();
            System.out.println(list.size() + " --> " + list.get(0));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
    }
}