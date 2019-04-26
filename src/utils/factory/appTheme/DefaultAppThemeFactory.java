package utils.themefactory;

import model.AppTheme;
import model.Style;
import model.Theme;
import utils.StyleBuilder;

import java.awt.*;

class DefaultThemeFactory implements AbstractThemeFactory {
    @Override
    public AppTheme getTheme() {
        Theme theme = new Theme();
        theme.color = Color.black;
        theme.showPageNumber = true;
        theme.styles = new Style[] {
                new StyleBuilder().setIndent(0).setColor(Color.red).setFontSize(48).setLeading(20).build(),
                new StyleBuilder().setIndent(0).setColor(Color.blue).setFontSize(40).setLeading(10).build(),
                new StyleBuilder().setIndent(0).setColor(Color.black).setFontSize(36).setLeading(10).build(),
                new StyleBuilder().setIndent(0).setColor(Color.black).setFontSize(30).setLeading(10).build(),
                new StyleBuilder().setIndent(0).setColor(Color.black).setFontSize(24).setLeading(10).build()
        };

        return new AppTheme(theme);
    }
}
