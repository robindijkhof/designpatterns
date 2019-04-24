import observable.Observable;
import model.Presentation;

public class AppState {
    public static final Observable<Presentation> $presentation = new Observable<>();

    private AppState(){
    }


}
