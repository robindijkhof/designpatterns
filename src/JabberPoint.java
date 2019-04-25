import javax.swing.JOptionPane;
import java.io.IOException;
import model.*;

import utils.Accessor;
import utils.AppState;
import utils.XMLAccessor;
import utils.themefactory.ThemeFactory;
import view.SlideViewerFrame;
import controller.PresentationController;
import controller.MenuController;
import controller.KeyController;

/** JabberPoint Main Programma
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint {
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	private PresentationController presentationController;
	private MenuController menuController;
	private KeyController keyController;


	public JabberPoint(String argv[]) {
		//Init the first theme
		AppState.$theme.next(ThemeFactory.getTheme(0));

		presentationController = new PresentationController();
		
		//To factories: //TODO: do these in a factory!
		presentationController.setPresentation(loadPresentation(argv));

		keyController = new KeyController(presentationController);
		menuController  = new MenuController(presentationController);

		//setup the controllers
		SlideViewerFrame slideViewerFrame = this.presentationController.GetPresentationView().GetSlideViewerFrame();
		slideViewerFrame.addKeyListener(new KeyController(presentationController));
		slideViewerFrame.setMenuBar(new MenuController(presentationController));


		//addKeyListener(new KeyController(presentation)); // een controller toevoegen
		//setMenuBar(new MenuController(this, presentation));	// nog een controller toevoegen
	}


	//TODO: needs to be done in factory
	private Presentation loadPresentation(String argv[]) {
		Presentation presentation = new Presentation();

		try {
			if (argv.length == 0) { // een demo presentatie
				Accessor.getDemoAccessor().loadFile(presentation, "");
			} else {
				new XMLAccessor().loadFile(presentation, argv[0]);
			}
			//presentation.setSlideNumber(0);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,
					IOERR + ex, JABERR,
					JOptionPane.ERROR_MESSAGE);
		}
		return presentation;
	}


	/** Het Main Programma */
	public static void main(String argv[]) {
		JabberPoint jabberPoint = new JabberPoint(argv);

		//this.presentationController = new PresentationController();

		//Style.createStyles();
		// Presentation presentation = new Presentation();
		//new SlideViewerFrame(JABVERSION, presentation);
		/*
		try {
			if (argv.length == 0) { // een demo presentatie
				Accessor.getDemoAccessor().loadFile(presentation, "");
			} else {
				new XMLAccessor().loadFile(presentation, argv[0]);
			}
			presentation.setSlideNumber(0);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,
					IOERR + ex, JABERR,
					JOptionPane.ERROR_MESSAGE);
		}*/
	}



}
