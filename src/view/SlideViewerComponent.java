package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

import model.*;
import utils.AppState;


/** <p>SlideViewerComponent is een grafische component die Slides kan laten zien.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent {
		
	private Slide slide; // de huidige slide
	private Font labelFont = null; // het font voor labels
	//private Presentation presentation = null; // de presentatie
	//private JFrame frame = null;
	private AppTheme appTheme;
	//private Theme theme;

	private static final long serialVersionUID = 227L;
	
	private static final Color BGCOLOR = Color.white;
	private static final Color COLOR = Color.black;
	private static final String FONTNAME = "Dialog";
	private static final int FONTSTYLE = Font.BOLD;
	private static final int FONTHEIGHT = 10;
	private static final int XPOS = 1100;
	private static final int YPOS = 20;

	private int slideNumberCurrent = 0;
	private int slideNumberMax = 0;

	public SlideViewerComponent() {
		setBackground(BGCOLOR); 
		labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);

		AppState.$appTheme.subscribe(appTheme -> /*this.appTheme = appTheme*/ setAppTheme(appTheme));
		AppState.$presentation.subscribe(presentation -> {
			update(presentation.getSlide(presentation.currentSlide), presentation.currentSlide, presentation.getSize());
		});
	}
	
	
	public void setAppTheme(AppTheme appTheme) {
		this.appTheme = appTheme;
		repaint();
	}

	public Dimension getPreferredSize() {
		return new Dimension(Slide.WIDTH, Slide.HEIGHT);
	}

	public void update(Slide data, int slideNumberCurrent, int slideNumberMax) {
		this.slideNumberCurrent = slideNumberCurrent;
		this.slideNumberMax = slideNumberMax;

		this.slide = data;
		repaint();
	}

// teken de slide
	public void paintComponent(Graphics g) {
		Theme theme = appTheme.getTheme(slideNumberCurrent);
		g.setColor(theme.color);
		g.fillRect(0, 0, getSize().width, getSize().height);

		if(slide == null) {
			return;
		}

		g.setFont(labelFont);
		g.setColor(COLOR);

		if(theme.showPageNumber){
			g.drawString("Slide " + (1 + slideNumberCurrent) + " of " + slideNumberMax, XPOS, YPOS);
		}

		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
		slide.draw(g, area, this, theme);
	}
}
