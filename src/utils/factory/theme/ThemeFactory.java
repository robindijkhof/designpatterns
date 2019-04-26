package utils.factory.theme;

import model.Theme;

public class ThemeFactory {

	public static Theme getTheme(int themeNr) {
		switch(themeNr) {
			case 0:	return new Theme1().getTheme();
			case 1: return new Theme2().getTheme();
			case 2: return new Theme3().getTheme();
			default: return new Theme4().getTheme();
		}
	}
}
