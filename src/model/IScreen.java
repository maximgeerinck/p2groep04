package model;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * @author Maxim
 */
public interface IScreen {

	Pane getPane();

	Scene showScreen();

}