package utils;

import model.Style;

import java.awt.*;

public class StyleBuilder {
    private Style style = new Style();

    public StyleBuilder setColor(Color color){
        style.color = color;
        return this;
    }

    public StyleBuilder setIndent(int indent){
        style.indent = indent;
        return this;
    }

    public StyleBuilder setFontSize(int fontSize){
        style.fontSize = fontSize;
        return this;
    }

    public StyleBuilder setLeading(int leading){
        style.leading = leading;
        return this;
    }

    public Style build(){
        style.font = new Font(Style.FONTNAME, Font.BOLD, style.fontSize);
        return style;
    }
}
