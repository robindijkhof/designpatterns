package utils.factory.theme;

import java.awt.Color;

import model.Style;
import model.Theme;
import utils.StyleBuilder;

public class Theme4 implements AbstractThemeFactory {

	@Override
	public Theme getTheme() {
		Theme theme = new Theme();
        theme.color = Color.white;
        theme.showPageNumber = true;
        theme.styles = new Style[] {
                new StyleBuilder().setIndent(0).setColor(Color.gray).setFontSize(40).setLeading(40).build(),
                new StyleBuilder().setIndent(10).setColor(Color.black).setFontSize(32).setLeading(30).build(),
                new StyleBuilder().setIndent(20).setColor(Color.gray).setFontSize(24).setLeading(30).build(),
                new StyleBuilder().setIndent(30).setColor(Color.black).setFontSize(16).setLeading(30).build(),
                new StyleBuilder().setIndent(40).setColor(Color.gray).setFontSize(12).setLeading(20).build()
        };
        return theme;
	}

}
