package interfaces;

@FunctionalInterface
public interface CustomFunctionalInterface<K, T> {

    public T getMethdodResult(K... args);
}
