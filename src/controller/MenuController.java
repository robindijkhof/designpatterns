package controller;

import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Presentation;
import utils.accessor.Accessor;
import utils.AppState;
import utils.accessor.XMLAccessor;
import utils.factory.appTheme.AppThemeFactory;

/**
 * <p>De controller voor het menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {

    //private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
    //private Presentation presentation; // Er worden commando's gegeven aan de presentatie


    private static final long serialVersionUID = 227L;

    //file menu
    
    protected static final String FILE = "File";
    protected static final String EXIT = "Exit";
    protected static final String OPEN = "Open";
    protected static final String NEW = "New";
    protected static final String SAVE = "Save";
    //view menu
    protected static final String VIEW = "View";
    protected static final String GOTO = "Go to";
    protected static final String NEXT = "Next";
    protected static final String PREV = "Prev";
    //theme menu
    protected static final String THEME = "Theme";
    protected static final String THEME1 = "Theme 1";
    protected static final String THEME2 = "Theme 2";
    protected static final String THEME3 = "Theme 3";
    //help menu
    protected static final String HELP = "Help";
    protected static final String ABOUT = "About";
    
    
    //goto prompt
    protected static final String PAGENR = "Page number?";
    //saving
    protected static final String TESTFILE = "test.xml";
    protected static final String SAVEFILE = "dump.xml";
    //exceptions
    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";


    private PresentationController presentationController;

    public MenuController(/*Frame frame,*/ PresentationController presController) {
        presentationController = presController;
        createFileMenu();
        createViewMenu();
        createThemeMenu();
        createHelpMenu();
    }

    private void createThemeMenu() {
   	 MenuItem menuItem;
   	 Menu themeMenu = new Menu(THEME);
        themeMenu.add(menuItem = mkMenuItem(THEME1));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AppState.$appTheme.next(AppThemeFactory.getTheme(0));
            }
        });
        themeMenu.add(menuItem = mkMenuItem(THEME2));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	AppState.$appTheme.next(AppThemeFactory.getTheme(1));
            }
        });
        themeMenu.add(menuItem = mkMenuItem(THEME3));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	AppState.$appTheme.next(AppThemeFactory.getTheme(2));
            }
        });
        add(themeMenu);
   }


	private void createHelpMenu() {
		MenuItem menuItem;
		Menu helpMenu = new Menu(HELP);
        helpMenu.add(menuItem = mkMenuItem(ABOUT));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //AboutBox.show(parent);
                presentationController.showAboutBox();
            }
        });
        setHelpMenu(helpMenu);        // nodig for portability (Motif, etc.).
	}


	private void createFileMenu() {
		MenuItem menuItem;
		Menu fileMenu = new Menu(FILE);
        fileMenu.add(menuItem = mkMenuItem(OPEN));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                // presentation.clear();
                presentationController.clear();

                Accessor xmlAccessor = new XMLAccessor();
                try {
                    Presentation presentation = xmlAccessor.loadFile(TESTFILE);
                    AppState.$presentation.next(presentation);
                } catch (IOException exc) {
                    System.out.println("TODO: error message is not shown");
					/* JOptionPane.showMessageDialog(parent, IOEX + exc, 
         			LOADERR, JOptionPane.ERROR_MESSAGE); */
                }
                //parent.repaint();

            }
        });
        fileMenu.add(menuItem = mkMenuItem(NEW));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //presentation.clear();
				presentationController.clear();
                //parent.repaint();
            }
        });
        fileMenu.add(menuItem = mkMenuItem(SAVE));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Accessor xmlAccessor = new XMLAccessor();

                AppState.$presentation.subscribe(presentation -> {
                    System.out.println("Do save");
                    try {
                        xmlAccessor.saveFile(presentation, SAVEFILE);
                    } catch (IOException exc) {
                        System.out.println("TODO: error message is not shown");
					/*JOptionPane.showMessageDialog(parent, IOEX + exc,
							SAVEERR, JOptionPane.ERROR_MESSAGE); */
                    }
                }).unsubscribe();


            }
        });
        fileMenu.addSeparator();
        fileMenu.add(menuItem = mkMenuItem(EXIT));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //presentation.exit(0);
                presentationController.exit(0);
            }
        });
        add(fileMenu);
	}
    
	
    private void createViewMenu() {
    	 MenuItem menuItem;
    	 Menu viewMenu = new Menu(VIEW);
         viewMenu.add(menuItem = mkMenuItem(NEXT));
         menuItem.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent actionEvent) {
                 //presentation.nextSlide();
                 presentationController.nextSlide();
             }
         });
         viewMenu.add(menuItem = mkMenuItem(PREV));
         menuItem.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent actionEvent) {
                 //presentation.prevSlide();
                 presentationController.prevSlide();
             }
         });
         viewMenu.add(menuItem = mkMenuItem(GOTO));
         menuItem.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent actionEvent) {
                 String pageNumberStr = JOptionPane.showInputDialog((Object) PAGENR);
                 int pageNumber = Integer.parseInt(pageNumberStr);
                 //presentation.setSlideNumber(pageNumber - 1);
                 presentationController.setSlideNumber(pageNumber - 1);
             }
         });
         add(viewMenu);
    }
    
   
    
    // een menu-item aanmaken
    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
