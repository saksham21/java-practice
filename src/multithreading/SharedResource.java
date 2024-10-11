package multithreading;

public class SharedResource {

    public Boolean isItemAvailable = false;

    synchronized public void addItem() {
        System.out.println("SharedResource addItem by thread: "  +Thread.currentThread().getName());
        isItemAvailable = true;
        notifyAll();
    }

    synchronized  public void reserveItem() {
        System.out.println("SharedResource reserveItem by thread: "  +Thread.currentThread().getName());

        while(!isItemAvailable) {
            System.out.println("SharedResource reserveItem - item not available by thread: "  +Thread.currentThread().getName());
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("SharedResource reserveItem - successfully reserved by thread: "  +Thread.currentThread().getName());
        isItemAvailable = false;
    }
}
