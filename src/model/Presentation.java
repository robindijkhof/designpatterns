package model;
import java.util.ArrayList;
import view.SlideViewerComponent;

/**
 * <p>Presentation houdt de slides in de presentatie bij.</p>
 * <p>Er is slechts ��n instantie van deze klasse aanwezig.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation {
	public int currentSlide = 0;
	private String showTitle; // de titel van de presentatie
	private ArrayList<Slide> showList = new ArrayList<>(); // een ArrayList met de Slides


	public int getSize() {
		return showList.size();
	}

	public String getTitle() {
		return showTitle;
	}

	public void setTitle(String nt) {
		showTitle = nt;
	}


	// Voeg een slide toe aan de presentatie
	public void append(Slide slide) {
		showList.add(slide);
	}

	// Geef een slide met een bepaald slidenummer
	public Slide getSlide(int number) {
		if (number < 0 || number >= getSize()){
			return null;
	    }
			return (Slide)showList.get(number);
	}

}
