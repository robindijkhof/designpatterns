package model;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.Collection;

/** <p>De abstracte klasse voor een item op een Slide<p>
 * <p>Alle SlideItems hebben tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public abstract class SlideItem {
	private int level = 0; // het level van het slideitem
	
	private Drawer drawer;

	public SlideItem(int lev, Drawer drawer) {
		this.drawer = drawer;
		level = lev;
		//CreateDrawer(); //call factory method
	}

	public SlideItem(Drawer drawer) {
		this(0, drawer);
	}

// Geef het level
	public int getLevel() {
		return level;
	}


// Geef de bounding box
	public abstract Rectangle getBoundingBox(Graphics g, 
			ImageObserver observer, float scale, Style style);

	
// teken het item
	public void draw(int x, int y, float scale, 
			Graphics g, Style style, ImageObserver observer) {
		this.drawer.draw(x, y, scale, g, style, observer, this);
	}
	
	/*
	//factory method
	protected abstract void CreateDrawer();
	*/
}
