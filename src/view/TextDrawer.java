package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.List;

import model.Drawer;
import model.SlideItem;
import model.Style;
import model.TextItem;

public class TextDrawer implements Drawer {

	@Override
	public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer, SlideItem slideItem) {
		TextItem textItem = ((TextItem)slideItem);
		String text = textItem.getText();
		
		if (text == null || text.length() == 0) {
			return;
		}
		List<TextLayout> layouts = textItem.getLayouts(g, style, scale);
		Point pen = new Point(x + (int)(style.indent * scale), 
				y + (int) (style.leading * scale));
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(style.color);
		for (TextLayout layout : layouts) {
			pen.y += layout.getAscent();
			layout.draw(g2d, pen.x, pen.y);
			pen.y += layout.getDescent();
		}
		
	}

	
}
