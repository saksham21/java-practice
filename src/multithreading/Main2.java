package multithreading;

public class Main2 {

    public static void main(String []args) {
        System.out.println("Main method starts execution by thread: " + Thread.currentThread().getName());
        SharedResource sharedResource = new SharedResource();
        Thread producerThread = new Thread(() -> {
            System.out.println("Inside producerThread. About to addItem by thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResource.addItem();
            System.out.println("Inside producerThread. Item Added by thread: " + Thread.currentThread().getName());
        });

        Thread consumerThread = new Thread(() -> {
            System.out.println("Inside consumerThread. About to reserve item by thread: " + Thread.currentThread().getName());
            sharedResource.reserveItem();
            System.out.println("Inside consumerThread. Item reserved by thread: " + Thread.currentThread().getName());
        });

        producerThread.start();
        consumerThread.start();
        System.out.println("Main method ends execution by thread: " + Thread.currentThread().getName());
    }
}
