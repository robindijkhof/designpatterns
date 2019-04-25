package model;

public class AppTheme {
    Theme presentationTheme = new Theme();
    Theme firstSlideTheme = null;

    public AppTheme(Theme presentationTheme){
        this.presentationTheme = presentationTheme;
    }

    public AppTheme(Theme presentationTheme, Theme firstSlideTheme){
        this.presentationTheme = presentationTheme;
        this.firstSlideTheme = firstSlideTheme;
    }

    public Theme getTheme(int slideNumber){
        if(slideNumber == 0 && firstSlideTheme != null){
            return firstSlideTheme;
        }else{
            return presentationTheme;
        }
    }
}
