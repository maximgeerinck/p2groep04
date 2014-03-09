package gui.screens;


import controller.PlanningController;
import entity.Campus;
import entity.Location;
import entity.TimeFrame;
import java.util.List;
import java.util.Observable;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import jfxtras.scene.control.CalendarTextField;
import model.IScreen;

/**
 * @author Maxim
 */

public class PresentatieToevoegenScreen extends Observable implements IScreen 
{
    private PlanningController planningController = new PlanningController();
    
    public Pane getPane() 
    {
        GridPane root = new GridPane();        
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25 ,25 ,25));

        root.addRow(0, new Label("Date"), new CalendarTextField());
        
        List<Campus> campuses = planningController.retrieveCampuses();
        final ObservableList<Campus> dataCampus = observableArrayList(campuses.toArray(new Campus[campuses.size()]));
        final ComboBox cbCampus = new ComboBox(dataCampus);
        
/*        List<Location> locations = planningController.retrieveLocations(null);
        final ObservableList<Location> dataLocation = observableArrayList(locations.toArray(new Location[locations.size()]));
        final ComboBox cbLocation = new ComboBox(dataLocation);*/
        
        root.addRow(1, new Label("Campus"), cbCampus, new Label("Locatie"), new ComboBox());        
        
        // location
        root.addRow(2, new Label("Locatie"));
        
        // timeframe
        List<TimeFrame> timeframes = planningController.retrieveTimeFrames();
        final ObservableList<TimeFrame> dataTimeframes = observableArrayList(timeframes.toArray(new TimeFrame[timeframes.size()]));
        final ComboBox cbTimeframe = new ComboBox(dataTimeframes);
        root.addRow(3, new Label("Timeframe"), cbTimeframe);
        
        ObservableList<String> optPromotoren = 
        observableArrayList(
            "Ikke",
            "Iemand anders",           
            "..."
        );
        final ComboBox cnPromotoren = new ComboBox(optPromotoren);
        root.addRow(4, new Label("Promotor"), cnPromotoren);

        ObservableList<String> optCoPromotoren = 
        observableArrayList(
            "Ikke",
            "Iemand anders",           
            "..."          
        );
        final ComboBox cbCoPromotoren = new ComboBox(optCoPromotoren);
        root.addRow(5, new Label("Co-Promotor"), cbCoPromotoren);

        ObservableList<String> optPresentatoren = 
        observableArrayList(
            "Ikke",
            "Iemand anders",           
            "..."          
        );
        final ComboBox cbPresentatoren = new ComboBox(optPresentatoren);
        root.addRow(6, new Label("Presentator"), cbPresentatoren);
        root.addRow(7, new Label("Onderwerp"), new TextField());
        root.addRow(8, new Label("Tijdstip"), new TextField());

        Button btnAdd = new Button("Toevoegen");
        btnAdd.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                //Roep setchanged aan ma das van de fucking klasse der boven -.-
                PresentatieToevoegenScreen.this.setChanged();
                PresentatieToevoegenScreen.this.notifyObservers();
            }

        });
        root.addRow(9, btnAdd);

        return root;
    }

    public Scene showScreen() 
    {
        return new Scene(getPane(), 600, 600);
    }
}