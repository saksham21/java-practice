package completableFuture;

import java.util.concurrent.*;

public class SupplyAsyncTest {

    public static void main(String[] arg) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,
                1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Threading name -> " + Thread.currentThread().getName());
            return "HELLO";
        });

        try {
            String result = completableFuture1.get();
            System.out.println(result);
        } catch (Exception e) {
        }
        threadPoolExecutor.shutdown();
    }
}
