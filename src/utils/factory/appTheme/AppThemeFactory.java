package utils.factory.appTheme;

import model.AppTheme;

public class AppThemeFactory {
    private AppThemeFactory(){}


    public static AppTheme getTheme(int themeNumber){

        switch (themeNumber){
            case 0: return new DefaultAppThemeFactory().getAppTheme();
            case 1: return new SecondAppThemeFactory().getAppTheme();
            case 2: return new ThirdAppThemeFactory().getAppTheme();

            default: return new DefaultAppThemeFactory().getAppTheme();
        }
    }
}
