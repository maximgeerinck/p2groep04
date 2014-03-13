package gui.screens;


import controller.CampusController;
import controller.LocationController;
import controller.PlanningController;
import controller.UserController;
import entity.Campus;
import entity.Location;
import entity.TimeFrame;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import jfxtras.scene.control.CalendarTextField;
import model.IScreen;

/**
 * @author Maxim
 */

public class PresentatieToevoegenScreen extends Observable implements IScreen 
{
    private PlanningController planningController   = new PlanningController();
    private UserController userController           = new UserController();
    private LocationController locationController   = new LocationController();
    private CampusController campusController       = new CampusController();
    
    private ComboBox cbLocations = new ComboBox();
    private ComboBox cbCoPromotors = new ComboBox();
    private CalendarTextField ctfCalendar = new CalendarTextField();
    
    public Pane getPane() 
    {
        GridPane root = new GridPane();        
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25 ,25 ,25));
        
        //Datum
        ctfCalendar.setPromptText("Kies een datum");
        root.addRow(0, new Label("Datum :"), ctfCalendar);
        
        // timeframe
        List<TimeFrame> timeframes = planningController.retrieveTimeFrames();
        final ObservableList<TimeFrame> dataTimeframes = observableArrayList(timeframes.toArray(new TimeFrame[timeframes.size()]));
        final ComboBox cbTimeframe = new ComboBox(dataTimeframes);
        cbTimeframe.setPromptText("Kies een periode");
        root.addRow(1, new Label("Periode :"), cbTimeframe);
        
        // students
        List<User> students = userController.retrieveStudents();
        final ObservableList<User> dataStudents = observableArrayList(students.toArray(new User[students.size()]));
        final ComboBox cbStudents = new ComboBox(dataStudents);
        cbStudents.setPromptText("Kies een student");
        cbStudents.setEditable(true);
        root.addRow(2, new Label("Student :"), cbStudents);        

        //Co-Promotors
        cbCoPromotors.setPromptText("Kies een co-promotor");
        cbCoPromotors.setEditable(true);
        root.addRow(4, new Label("Co-Promotor :"), cbCoPromotors);
        
        //Campuses
        List<Campus> campuses = planningController.retrieveCampuses();
        final ObservableList<Campus> dataCampus = observableArrayList(campuses.toArray(new Campus[campuses.size()]));
        final ComboBox cbCampus = new ComboBox(dataCampus);
        cbCampus.setPromptText("Kies een campus");
        cbCampus.valueProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<? extends Object> ov, Object t, Object t1) {
                List<Location> locations = locationController.retrieveLocations((Campus)t1);
                cbLocations.getItems().setAll(locations);    
                if(locations.size() == 0) {
                    cbLocations.setPromptText("No locations found.");
                } else {
                    cbLocations.setPromptText("Please pick a location.");
                }
            }
        });
        root.addRow(5, new Label("Campus :"), cbCampus);        
        
        // location
        List<Location> locations = locationController.retrieveLocations(null);
        final ObservableList<Location> dataLocations = observableArrayList(locations.toArray(new Location[locations.size()]));
        cbLocations = new ComboBox(dataLocations);
        root.addRow(6, new Label("Locatie :"), cbLocations);
        
        // promotors
        List<User> promotors = userController.retrievePromotors();
        final ObservableList<User> dataPromotors = observableArrayList(promotors.toArray(new User[promotors.size()]));
        final ComboBox cbPromotor = new ComboBox(dataPromotors);
        cbPromotor.setPromptText("Please pick a promotor");
        root.addRow(3, new Label("Promotor :"), cbPromotor);
        cbPromotor.valueProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<? extends Object> ov, Object t, Object t1) {
                // co-promotor
                List<User> coPromotors = new ArrayList<>();
                // get already picked promotor if any
                User currentPromotor = ((User)(cbPromotor.getSelectionModel().getSelectedItem()));
                if(currentPromotor != null) {
                   for(User u : (List<User>)cbPromotor.getItems()) 
                   {
                       if(u.getId() != currentPromotor.getId()) {
                           coPromotors.add(u);
                       }
                   } 
                }
                final ObservableList<User> dataCoPromotors = observableArrayList(coPromotors.toArray(new User[coPromotors.size()]));
                cbCoPromotors.getItems().setAll(dataCoPromotors);
                cbCoPromotors.setPromptText("Please choose a co-promotor");
            }
        });

        
        
        
        //Button Toevoegen
        Button btnAdd = new Button("Toevoegen");
        btnAdd.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                PresentatieToevoegenScreen.this.setChanged();
                PresentatieToevoegenScreen.this.notifyObservers();
            }

        });
        root.addRow(7, btnAdd);
        
        return root;
    }

    public Scene showScreen() 
    {
        return new Scene(getPane(), 600, 600);
    }
}
