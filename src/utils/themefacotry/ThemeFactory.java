package utils.themefacotry;

import model.Theme;

public class ThemeFactory {
    private ThemeFactory(){}


    static Theme getTheme(int themeNumber){

        switch (themeNumber){
            case 0: return new DefaultThemeFactory().getTheme();

            default: return new DefaultThemeFactory().getTheme();
        }
    }
}
