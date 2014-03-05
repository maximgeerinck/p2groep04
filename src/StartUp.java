
import gui.GraphicApplication;
import gui.PanelPresentatieToevoegen;
import java.math.BigDecimal;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
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
        
        SplitPane root = new SplitPane();
        StackPane sp1 = new StackPane();
        sp1.getChildren().add(application.getAgenda());
        
        StackPane sp2 = new StackPane();
        Button button = new Button("Nieuwe presentatie");       
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
               Stage stage = new Stage();
               
               stage.setScene(new PanelPresentatieToevoegen().showScreen());
               stage.show();
            }
        });
        sp2.getChildren().add(button);
        //root.getChildren().add(11, new Label(), button);
        
        root.getItems().addAll(sp1, sp2);
        root.setDividerPositions(0.9f, 0.6f, 0.9f);
        primaryStage.setScene(new Scene(root, 1500, 900));
        primaryStage.show();
    }
}
