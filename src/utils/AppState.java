package utils;

import model.Theme;
import observable.Observable;
import model.Presentation;

public class AppState {
    public static final Observable<Presentation> $presentation = new Observable<>();
    public static final Observable<Theme> $theme = new Observable<>();

    private AppState(){
    }


}
