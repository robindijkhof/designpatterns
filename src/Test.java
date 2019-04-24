import observable.Observable;
import observable.Subscription;

public class Test {
    public static void main(String argv[]) {
        Observable<String> observable = new Observable<>();
        observable.next("Test");
        Subscription subscription = observable.subscribe((String a) -> {
        	System.out.println("dit kwam er binnen: " + a);
        });
        Subscription subscription2 = observable.subscribe(Test::SomeFunc);
        observable.next("nog een test");
        
        Subscription subscription3 = observable.subscribe(System.out::println);
        observable.next("nog een test");
        subscription.unsubscribe();;
    }
    
    
    public static void SomeFunc(String a) {
    	System.out.println("uit SomeFunc: " + a);
    }
}