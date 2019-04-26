package model;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.Collection;

public interface Drawer {

	public abstract void draw(int x, int y, float scale, 
			Graphics g, Style style, ImageObserver observer, SlideItem slideItem);
	
	
}
