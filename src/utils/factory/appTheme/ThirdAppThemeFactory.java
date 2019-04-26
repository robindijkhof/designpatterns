package utils.factory.appTheme;

import model.AppTheme;
import model.Style;
import model.Theme;
import utils.StyleBuilder;
import utils.factory.theme.ThemeFactory;

import java.awt.*;

class ThirdAppThemeFactory implements AbstractAppThemeFactory {
    @Override
    public AppTheme getAppTheme() {
    	/*
        Theme theme = new Theme();
        theme.color = Color.black;
        theme.showPageNumber = true;
        theme.styles = new Style[] {
                new StyleBuilder().setIndent(0).setColor(Color.red).setFontSize(48).setLeading(20).build(),
                new StyleBuilder().setIndent(10).setColor(Color.blue).setFontSize(40).setLeading(10).build(),
                new StyleBuilder().setIndent(20).setColor(Color.white).setFontSize(36).setLeading(10).build(),
                new StyleBuilder().setIndent(30).setColor(Color.white).setFontSize(30).setLeading(10).build(),
                new StyleBuilder().setIndent(40).setColor(Color.white).setFontSize(24).setLeading(10).build()
        };
		*/
    	
        return new AppTheme(ThemeFactory.getTheme(1), ThemeFactory.getTheme(3));
    }
}
