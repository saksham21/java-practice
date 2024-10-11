package concurrency;

public class Main2 {
    public static void main(String[] args) {

        SharedResource2 sharedResource = new SharedResource2();
        Thread t1 = new Thread( ()-> {
            for(int i=0;i<500;i++) {
                sharedResource.increment();
            }
        });
        Thread t2 = new Thread( ()-> {
            for(int i=0;i<500;i++) {
                sharedResource.increment();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sharedResource.get());
    }
}