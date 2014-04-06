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
        
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/ViewPlanning.fxml"));
        
        Scene scene = new Scene(loadMain());   
        
        primaryStage.setTitle("p2groep04");
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
       /* System.out.println("started");
        ViewPlanningController controller = loader.getController();
        controller.loadAgenda();
        
        BorderPane root = loader.getRoot();
        Scene scene = new Scene(root);       
        
        primaryStage.setTitle("Planning overzicht");
        primaryStage.setScene(scene);
        
        primaryStage.show();*/
        
        /*SplitPane root = new SplitPane();
        StackPane sp1 = new StackPane();
        
        ViewPlanningScreen screenViewPlanning = ((ViewPlanningScreen)ScreenFactory.createScreen(ScreenFactory.SCREEN_PLANNING_VIEW, primaryStage));
        Pane screenPlanningViewPane = screenViewPlanning.getPane();
        
        sp1.getChildren().add(screenPlanningViewPane);
        /* SIDEBAR */
       /* VBox v = new VBox();
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
        primaryStage.show();*/
    }
}