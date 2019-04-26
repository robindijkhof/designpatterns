package utils.factory.theme;

import java.awt.Color;

import model.Style;
import model.Theme;
import utils.StyleBuilder;

public class Theme3 implements AbstractThemeFactory {

	@Override
	public Theme getTheme() {
		Theme theme = new Theme();
        theme.color = Color.yellow;
        theme.showPageNumber = false;
        theme.styles = new Style[] {
                new StyleBuilder().setIndent(0).setColor(Color.red).setFontSize(60).setLeading(20).build(),
                new StyleBuilder().setIndent(30).setColor(Color.pink).setFontSize(40).setLeading(15).build(),
                new StyleBuilder().setIndent(50).setColor(Color.blue).setFontSize(30).setLeading(15).build(),
                new StyleBuilder().setIndent(60).setColor(Color.green).setFontSize(20).setLeading(10).build(),
                new StyleBuilder().setIndent(65).setColor(Color.orange).setFontSize(15).setLeading(5).build()
        };
        return theme;
	}

}
