import javax.swing.JOptionPane;
import java.io.IOException;
import model.*;

import utils.accessor.Accessor;
import utils.AppState;
import utils.accessor.XMLAccessor;
import utils.factory.appTheme.AppThemeFactory;
import view.PresentationViewerFrame;
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


	public JabberPoint(String[] argv) {
		//Init the first theme
		AppState.$appTheme.next(AppThemeFactory.getTheme(0));
		AppState.$presentation.next(loadPresentation(argv));

		PresentationController presentationController = new PresentationController();
		KeyController keyController = new KeyController(presentationController);
		MenuController menuController  = new MenuController(presentationController);

		//setup the controllers
		PresentationViewerFrame presentationViewerFrame = presentationController.GetPresentationView();
		presentationViewerFrame.addKeyListener(new KeyController(presentationController));
		presentationViewerFrame.setMenuBar(new MenuController(presentationController));

	}


	private Presentation loadPresentation(String[] argv) {
		Presentation presentation = new Presentation();
		try {
			if (argv.length == 0) { // een demo presentatie
				presentation = Accessor.getDemoAccessor().loadFile("");
			} else {
				presentation = new XMLAccessor().loadFile(argv[0]);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,
					IOERR + ex, JABERR,
					JOptionPane.ERROR_MESSAGE);
		}
		return presentation;
	}


	/** Het Main Programma */
	public static void main(String[] argv) {
		new JabberPoint(argv);
	}



}
