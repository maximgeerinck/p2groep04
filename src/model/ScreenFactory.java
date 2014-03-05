/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gui.screens.PresentatieToevoegenScreen;
import javafx.scene.Scene;
import javafx.stage.Screen;

/**
 *
 * @author Maxim
 */
public class ScreenFactory 
{
    public static final String SCREEN_PRESENTATIE_TOEVOEGEN = "ScreenPresentatieToevoegen";
    
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
