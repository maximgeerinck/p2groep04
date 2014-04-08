package gui;

import controller.ViewMainController;
import controller.ViewPlanningController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * @author Maxim
 */
public class GraphicApplication
{
    private Stage primaryStage;
    private FXMLLoader loader;
    
    public Pane loadMain() throws IOException {
        
        loader = new FXMLLoader(getClass().getResource("/resources/ViewMain.fxml"));
        
        loader.load();
        
        ViewMainController controller = loader.getController();
        controller.attachGridviews(primaryStage);
        
        BorderPane root = loader.getRoot();
        return root;
    }
    
    public GraphicApplication(Stage primaryStage) throws IOException 
    {
        this.primaryStage = primaryStage;
        
        Scene scene = new Scene(loadMain());   
        
        primaryStage.setTitle("p2groep04");
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
}