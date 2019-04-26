package utils.themefactory;

import model.AppTheme;

public class ThemeFactory {
    private ThemeFactory(){}


    public static AppTheme getTheme(int themeNumber){

        switch (themeNumber){
            case 0: return new DefaultThemeFactory().getTheme();
            case 1: return new FirstThemeFactory().getTheme();

            default: return new DefaultThemeFactory().getTheme();
        }
    }
}
