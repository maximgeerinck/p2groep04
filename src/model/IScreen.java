/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 *
 * @author Maxim
 */
public interface IScreen 
{
    Scene showScreen();
    Pane getPane();
}
