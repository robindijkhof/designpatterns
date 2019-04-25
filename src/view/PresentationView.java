package view;
import model.Presentation;

public class PresentationView {
	private SlideViewerFrame slideViewerFrame;
	private SlideViewerComponent slideViewerComponent;
	Presentation presentation;
	

	public PresentationView(Presentation presentation) {
		this.presentation = presentation;
		this.slideViewerFrame = new SlideViewerFrame(presentation.getTitle(), presentation);
		this.slideViewerComponent = slideViewerFrame.GetSlideViewerComponent();


		drawSlide(0);
	}
	
	
	public SlideViewerFrame GetSlideViewerFrame() {
		return slideViewerFrame;
	}
	
	
	public SlideViewerComponent GetSlideViewerComponent() {
		return slideViewerComponent;
	}
	
	
	public void drawSlide(int slideNr) {
		this.slideViewerComponent.update(presentation.getSlide(slideNr), slideNr, presentation.getSize());
		slideViewerFrame.setTitle(presentation.getTitle());
	}
	
	
	public void showAboutBox() {
		AboutBox.show(slideViewerFrame);
	}
}
