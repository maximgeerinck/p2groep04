import gui.GraphicApplication;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Maxim
 */
public class StartUp extends Application 
{
    
    public static void main(String[] args) 
    {
         Application.launch(StartUp.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException 
    {                
        new GraphicApplication(primaryStage);
    }
    
}