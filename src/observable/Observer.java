package observable;

public interface Observer<T> {
    void onResult(T item);
}
