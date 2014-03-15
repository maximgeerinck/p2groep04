
import gui.GraphicApplication;
import gui.screens.PlanningOpslaanScreen;
import gui.screens.PresentatieToevoegenScreen;
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
        
        /* SIDEBAR */
        VBox v = new VBox();
        v.setMinWidth(350);

        Accordion a = new Accordion();
        
        // Presentatie toevoegen
        PresentatieToevoegenScreen presentaties = (PresentatieToevoegenScreen)ScreenFactory.createScreen(ScreenFactory.SCREEN_PRESENTATIE_TOEVOEGEN);
        presentaties.addObserver(application);
        TitledPane tpPresentaties = new TitledPane("Presentatie toevoegen", presentaties.getPane());
        a.getPanes().add(tpPresentaties);
        a.setExpandedPane(tpPresentaties);        
        
        // Planning opslaan
        PlanningOpslaanScreen planningOpslaan = (PlanningOpslaanScreen)ScreenFactory.createScreen(ScreenFactory.SCREEN_PLANNING_OPSLAAN);
        TitledPane tpPlanningOpslaan = new TitledPane("Instellingen", planningOpslaan.getPane());
        a.getPanes().add(tpPlanningOpslaan);
        a.setExpandedPane(tpPlanningOpslaan);       
        
        // voeg title panes toe aan accordion
        v.add(a);
        
        root.getItems().addAll(sp1, v);
        root.setDividerPositions(0.9f, 0.6f, 0.9f);
        primaryStage.setScene(new Scene(root, 1500, 900));
        primaryStage.show();
    }
}