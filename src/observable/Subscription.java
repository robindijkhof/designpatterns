package observable;

import java.util.Collection;

public class Subscription {

    private Collection observers;
    private Observer observer;

    public Subscription(Collection observers, Observer observer){
        this.observers = observers;
        this.observer = observer;

    }

    public boolean isClosed(){
        return observers == null || observers.contains(observer);
    }

    public void unsubscribe(){
        this.observers.remove(observer);
    }
}
