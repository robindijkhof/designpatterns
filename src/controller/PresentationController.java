package controller;
import model.Presentation;
import utils.AppState;
import view.AboutBox;
import view.PresentationViewerFrame;

/** <p>Verantwoordelijk voor aansturen van de presentatie. Beheert de presentation en de presentationView </p>
 * 
 */

public class PresentationController {
	private Presentation presentation;
	private PresentationViewerFrame presentationViewerFrame;
	

	public PresentationController(){
		this.presentationViewerFrame = new PresentationViewerFrame();
		AppState.$presentation.subscribe(presentation -> this.presentation = presentation);
	}
	

	public void showAboutBox() {
		AboutBox.show(presentationViewerFrame);
	}
	
	public void clear() {
		AppState.$presentation.next(new Presentation());
	}


	
	public PresentationViewerFrame GetPresentationView() {
		return this.presentationViewerFrame;
	}

	// verander het huidige-slide-nummer en laat het aan het window weten.
	public void setSlideNumber(int number) {
		presentation.currentSlide = number;
		AppState.$presentation.next(presentation);
	}

	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public void prevSlide() {
		if (presentation.currentSlide > 0) {
			presentation.currentSlide -= 1;
			AppState.$presentation.next(presentation);
		}
	}

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public void nextSlide() {
		if (presentation.currentSlide < (presentation.getSize()-1)) {
			presentation.currentSlide += 1;
			AppState.$presentation.next(presentation);
		}
	}
	
	public void exit(int n) {
		System.exit(n);
	}
}
