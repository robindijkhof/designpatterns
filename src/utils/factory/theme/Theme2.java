package utils.factory.theme;

import java.awt.Color;

import model.Style;
import model.Theme;
import utils.StyleBuilder;

public class Theme2 implements AbstractThemeFactory {

	@Override
	public Theme getTheme() {
		Theme theme = new Theme();
        theme.color = Color.green;
        theme.showPageNumber = true;
        theme.styles = new Style[] {
                new StyleBuilder().setIndent(0).setColor(Color.black).setFontSize(24).setLeading(20).build(),
                new StyleBuilder().setIndent(20).setColor(Color.blue).setFontSize(20).setLeading(10).build(),
                new StyleBuilder().setIndent(40).setColor(Color.black).setFontSize(16).setLeading(10).build(),
                new StyleBuilder().setIndent(60).setColor(Color.blue).setFontSize(14).setLeading(10).build(),
                new StyleBuilder().setIndent(80).setColor(Color.red).setFontSize(10).setLeading(10).build()
        };
        return theme;
	}

}
