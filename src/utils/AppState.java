package utils;

import model.AppTheme;
import model.Presentation;
import observable.Observable;

public class AppState {
    public static final Observable<Presentation> $presentation = new Observable<>();
    public static final Observable<AppTheme> $appTheme = new Observable<>();

    private AppState(){
    }


}
