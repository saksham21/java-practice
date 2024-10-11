package completableFuture;

import java.util.*;
import java.util.concurrent.*;

public class ThenCombineTest {

    public static void main(String[] arg) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,
                1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Threading name in completableFuture1 -> " + Thread.currentThread().getName());
            return "HELLO";
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Threading name in completableFuture2 -> " + Thread.currentThread().getName());
            return "WORLD";
        });

        CompletableFuture<Integer> completableFuture3 = completableFuture1.thenCombine(completableFuture2, (String var1, String var2) -> {
            return var1.length() - var2.length();
        });

        try {
            System.out.println("completableFuture3 --> " + completableFuture3.get());
//            System.out.println("completableFuture4 --> " + completableFuture4.get());
//            Thread.sleep(1000);
        } catch (Exception e) {
        }
        threadPoolExecutor.shutdown();
    }
}
