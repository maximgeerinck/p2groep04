package model;

import gui.screens.*;

/**
 * @author Maxim
 */
public class ScreenFactory {

    public static final String SCREEN_PRESENTATIE_TOEVOEGEN = "ScreenPresentatieToevoegen";
    public static final String SCREEN_PLANNING_OPSLAAN = "PlanningOpslaan";
    public static final String SCREEN_PLANNING_VIEW = "PlanningTonen";

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
           case SCREEN_PLANNING_OPSLAAN:
               return new PlanningOpslaanScreen();
           case SCREEN_PLANNING_VIEW:
               return new ViewPlanningScreen();
       }
        return null;
    }

}