package controller;
import model.Presentation;
import view.AboutBox;
import view.PresentationView;

/** <p>Verantwoordelijk voor aansturen van de presentatie. Beheert de presentation en de presentationView </p>
 * 
 */

public class PresentationController {
	private Presentation presentation;
	private PresentationView presentationView;
	
	int currentSlideNumber = 0;
	
	
	
	public int getSlideNumber() {
		return currentSlideNumber;
	}
	
	public void showAboutBox() {
		//AboutBox.show(parent);
		presentationView.showAboutBox();
	}
	
	public void clear() {
		this.presentation.clear();
	}
	
	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
		//this.presentationView.drawPresentation(presentation); //setup the current presentation
		this.presentationView = new PresentationView(presentation);
	}
	
	public Presentation GetPresentation() {
		return presentation;
	}
	
	
	public PresentationView GetPresentationView() {
		return this.presentationView;
	}

	// verander het huidige-slide-nummer en laat het aan het window weten.
	public void setSlideNumber(int number) {
		currentSlideNumber = number;
		
		/*
		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}*/
		this.presentationView.drawSlide(currentSlideNumber);
	}

	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public void prevSlide() {
		if (currentSlideNumber > 0) {
			setSlideNumber(currentSlideNumber - 1);
	    }
	}

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public void nextSlide() {
		if (currentSlideNumber < (presentation.getSize()-1)) {
			setSlideNumber(currentSlideNumber + 1);
		}
	}
	
	public void exit(int n) {
		System.exit(n);
	}
}
