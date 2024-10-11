package completableFuture;

import java.util.concurrent.*;

public class ThenAcceptTest {

    public static void main(String[] arg) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,
                1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Threading name in completableFuture1 -> " + Thread.currentThread().getName());
            return "HELLO";
        });
        CompletableFuture<String> completableFuture2 = completableFuture1.thenApplyAsync((String v) -> {
            System.out.println("Threading name in completableFuture2 -> " + Thread.currentThread().getName());
            return v+" WORLD";
        });
        CompletableFuture<String> completableFuture3 = completableFuture2.thenApplyAsync((String v) -> {
            System.out.println("Threading name in thenApplyAsync -> " + Thread.currentThread().getName());;
            return v + " !!!";
//            return CompletableFuture.supplyAsync(() -> {
//                System.out.println("Threading name in thenApplyAsync:supplyAsync -> " + Thread.currentThread().getName());;
//                return v + " !!!";
//            });
        });
        CompletableFuture<Void> completableFuture4 = completableFuture3.thenAccept((String var) -> {
            System.out.println("completableFuture4 printing var --> " + var);
        });

        try {
//            System.out.println("completableFuture3 --> " + completableFuture3.get());
//            System.out.println("completableFuture4 --> " + completableFuture4.get());
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        threadPoolExecutor.shutdown();
    }
}
