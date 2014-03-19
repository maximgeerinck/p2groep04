package gui;

import gui.screens.PlanningOpslaanScreen;
import gui.screens.PresentatieToevoegenScreen;
import gui.screens.ViewPlanningScreen;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jfxtras.scene.layout.VBox;
import model.ScreenFactory;


/**
 * @author Maxim
 */
public class GraphicApplication
{
    private Stage primaryStage;
    
    public GraphicApplication(Stage primaryStage) 
    {
        this.primaryStage = primaryStage;
        
        primaryStage.setTitle("Planning overzicht");
        
        SplitPane root = new SplitPane();
        StackPane sp1 = new StackPane();
        
        ViewPlanningScreen screenViewPlanning = ((ViewPlanningScreen)ScreenFactory.createScreen(ScreenFactory.SCREEN_PLANNING_VIEW, primaryStage));
        Pane screenPlanningViewPane = screenViewPlanning.getPane();
        
        sp1.getChildren().add(screenPlanningViewPane);
        /* SIDEBAR */
        VBox v = new VBox();
        v.setMinWidth(350);

        Accordion a = new Accordion();
        
        // Presentatie toevoegen
        PresentatieToevoegenScreen presentaties = (PresentatieToevoegenScreen)ScreenFactory.createScreen(ScreenFactory.SCREEN_PRESENTATIE_TOEVOEGEN);
        presentaties.addObserver(screenViewPlanning);
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
        
        Scene scene = new Scene(root, 1500, 900);
        scene.getStylesheets().add("gui/screens/ViewPlanningScreen.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}