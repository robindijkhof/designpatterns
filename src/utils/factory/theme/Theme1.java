package utils.factory.theme;

import java.awt.Color;

import model.Style;
import model.Theme;
import utils.StyleBuilder;

public class Theme1 implements AbstractThemeFactory {

	@Override
	public Theme getTheme() {
		Theme theme = new Theme();
        theme.color = Color.gray;
        theme.showPageNumber = true;
        theme.styles = new Style[] {
                new StyleBuilder().setIndent(0).setColor(Color.red).setFontSize(48).setLeading(20).build(),
                new StyleBuilder().setIndent(10).setColor(Color.blue).setFontSize(40).setLeading(10).build(),
                new StyleBuilder().setIndent(20).setColor(Color.white).setFontSize(36).setLeading(10).build(),
                new StyleBuilder().setIndent(30).setColor(Color.white).setFontSize(30).setLeading(10).build(),
                new StyleBuilder().setIndent(40).setColor(Color.white).setFontSize(24).setLeading(10).build()
        };
        return theme;
	}

}
