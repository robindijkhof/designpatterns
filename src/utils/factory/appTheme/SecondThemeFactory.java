package utils.themefactory;

import model.AppTheme;
import model.Style;
import model.Theme;
import utils.StyleBuilder;

import java.awt.*;

class FirstThemeFactory implements AbstractThemeFactory {
    @Override
    public AppTheme getTheme() {
        Theme theme = new Theme();
        theme.color = Color.gray;
        theme.showPageNumber = false;
        theme.styles = new Style[] {
                new StyleBuilder().setIndent(0).setColor(Color.green).setFontSize(30).setLeading(20).build(),
                new StyleBuilder().setIndent(0).setColor(Color.orange).setFontSize(24).setLeading(10).build(),
                new StyleBuilder().setIndent(0).setColor(Color.black).setFontSize(18).setLeading(10).build(),
                new StyleBuilder().setIndent(0).setColor(Color.black).setFontSize(12).setLeading(10).build(),
                new StyleBuilder().setIndent(0).setColor(Color.black).setFontSize(6).setLeading(10).build()
        };

        return new AppTheme(theme, new Theme());
    }
}