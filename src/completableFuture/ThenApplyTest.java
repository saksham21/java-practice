package completableFuture;

import java.util.concurrent.*;

public class ThenApplyTest {

    public static void main(String[] arg) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,
                1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Threading name in completableFuture1 -> " + Thread.currentThread().getName());
            return "HELLO";
        }, threadPoolExecutor);
        CompletableFuture<String> completableFuture2 = completableFuture1.thenApplyAsync((String v) -> {
            System.out.println("Threading name in completableFuture2 -> " + Thread.currentThread().getName());
            return v+" WORLD";
        }, threadPoolExecutor);
        CompletableFuture<String> completableFuture3 = completableFuture2.thenApply((String v) -> {
            System.out.println("Threading name in thenApplyAsync -> " + Thread.currentThread().getName());
            return v+" !!!";
        });

        try {
            System.out.println(completableFuture3.get());
        } catch (Exception e) {
        }
        threadPoolExecutor.shutdown();
    }
}
