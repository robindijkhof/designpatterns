import observable.Observable;
import observable.Subscription;

public class Test {
    public static void main(String argv[]) {
        Observable<String> observable = new Observable<>();
        observable.next("Test");
        Subscription subscription = observable.subscribe(System.out::println);
        observable.next("nog een test");
        subscription.unsubscribe();;


    }
}