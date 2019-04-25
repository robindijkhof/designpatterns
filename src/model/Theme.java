package model;

import java.awt.*;

public class Theme {

    public Color color = Color.white;
    public boolean showPageNumber = true;
    public Style[] styles = new Style[] {new Style()};

    public Style getStyle(int level) {
        if (level >= styles.length) {
            level = styles.length - 1;
        }
        return styles[level];
    }
}
