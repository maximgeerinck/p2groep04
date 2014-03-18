
import gui.GraphicApplication;
import gui.screens.PlanningOpslaanScreen;
import gui.screens.PresentatieToevoegenScreen;
import gui.screens.ViewPlanningScreen;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jfxtras.scene.layout.VBox;
import model.ScreenFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxim
 */
public class StartUp extends Application 
{
    
    public static void main(String[] args) 
    {
         launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {                
        new GraphicApplication(primaryStage);
        
    }
}