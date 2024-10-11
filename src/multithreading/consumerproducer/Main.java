package multithreading.consumerproducer;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            for(int i=0;i<12;i++)
                sharedResource.addData(i);
        });
        Thread consumerThread = new Thread(() -> {
            while(true) sharedResource.consumeData();
        });

        producerThread.start();
        consumerThread.start();
    }
}
