package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import model.Style;
import model.BitmapItem;
import model.Drawer;
import model.SlideItem;


public class ImageDrawer implements Drawer {

	@Override
	public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer, SlideItem slideItem) {
		
		BufferedImage bufferedImage = ((BitmapItem)slideItem).GetBufferedImage();
		int width = x + (int) (style.indent * scale);
		int height = y + (int) (style.leading * scale);
		g.drawImage(bufferedImage, width, height,(int) (bufferedImage.getWidth(observer)*scale),
                (int) (bufferedImage.getHeight(observer)*scale), observer);
	}

		
}
