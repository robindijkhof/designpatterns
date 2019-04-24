package observable;

import java.util.ArrayList;
import java.util.Collection;

public class Observable<T> {
    private Collection<Observer<T>> observers = new ArrayList<>();
    private T object;

    public void next(T object){
        observers.forEach(observer -> {
            if(observer != null){
                observer.onResult(object);
            }
        });


        this.object = object;
    }

    public Subscription subscribe(Observer<T> observer){
        observers.add(observer);
        observer.onResult(object);
        return new Subscription(observers, observer);
    }
}