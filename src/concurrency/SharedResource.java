package concurrency;

public class SharedResource {
    int counter = 0;

    public void increment() {
        counter++;
    }
    public int get() {
        return counter;
    }
}
