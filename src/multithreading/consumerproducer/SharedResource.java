package multithreading.consumerproducer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    Queue<Integer> queue = new LinkedList<>();
    int maxSize = 5;

    synchronized public void addData(Integer data) {
        System.out.println("Inside addData method by producer thread " + Thread.currentThread().getName() + " for data:" + data);
        while(queue.size() >= maxSize) {
            try {
                System.out.println("Inside addData method WAIT by producer thread " + Thread.currentThread().getName() + " for data:" + data);
                wait();
            } catch (Exception e) {
                // add code to do exception handling here
            }
        }
        System.out.println("Inside addData method DATA ADDED by producer thread " + Thread.currentThread().getName() + " for data:" + data);
        queue.add(data);
        notify();
    }

    synchronized public void consumeData() {
        System.out.println("Inside consumeData method by consumer thread " + Thread.currentThread().getName());
        while(queue.isEmpty()) {
            try {
                System.out.println("Inside consumeData method WAIT by consumer thread " + Thread.currentThread().getName());
                wait();
            } catch (Exception e) {
                // add code to do exception handling here
            }
        }
        Integer data = queue.poll();
        System.out.println("Inside consumeData method CONSUMED by consumer thread " + Thread.currentThread().getName() + " and data is: " + data);
        notify();
    }
}
