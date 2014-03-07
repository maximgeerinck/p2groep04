package model;

import gui.screens.PresentatieToevoegenScreen;

/**
 * @author Maxim
 */
public class ScreenFactory {

    public static final String SCREEN_PRESENTATIE_TOEVOEGEN = "ScreenPresentatieToevoegen";

    /**
     * 
     * @param screenName
     */
    public static IScreen createScreen(String screenName) 
    {
       switch(screenName)
       {
           case SCREEN_PRESENTATIE_TOEVOEGEN:
               return new PresentatieToevoegenScreen();
       }
        return null;
    }

}