package utils.factory.slideItem;
import model.BitmapItem;
import model.SlideItem;
import model.TextItem;
import view.ImageDrawer;
import view.TextDrawer;

public class SlideItemFactory {
	protected static final String UNKNOWNTYPE = "Unknown Element type";
    public static final String TEXT = "text";
    public static final String IMAGE = "image";

	
	public static SlideItem createSlideItem(String type, int level, String text) {
		SlideItem result = null;
		if (TEXT.equals(type)) {
			TextDrawer textDrawer = new TextDrawer();
			result = new TextItem(level, text, textDrawer);
		}
		else {
			if (IMAGE.equals(type)) {
				ImageDrawer imageDrawer = new ImageDrawer();
				result = new BitmapItem(level, text, imageDrawer);
			}
			else {
				System.err.println(UNKNOWNTYPE);
			}
		}
		return result;
	}
}
