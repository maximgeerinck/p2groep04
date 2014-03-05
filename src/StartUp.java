
import gui.GraphicApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
    private GraphicApplication application = new GraphicApplication();
    
    public static void main(String[] args) 
    {
         launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {                
        primaryStage.setTitle("Planning overzicht");
        
        StackPane root = new StackPane();
        root.getChildren().add(application.getAgenda());
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
}
