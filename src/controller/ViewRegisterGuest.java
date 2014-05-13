package controller;

import entity.Campus;
import entity.GuestRequest;
import entity.Location;
import entity.Presentation;
import entity.Promotor;
import entity.Student;
import exceptions.CapacityReachedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import model.GuestRequestRepository;
import model.UserRepository;

/**
 * 
 * @author Maxim
 */
public class ViewRegisterGuest {

    @FXML
    private ListView<Student> lvGuests;

    @FXML
    private ListView<Presentation> lvPresentations;

    @FXML
    private ComboBox<Promotor> cbPromotor;
    
    private final UserRepository userRepository = new UserRepository();
    private final GuestRequestRepository guestRequestRepository = new GuestRequestRepository();
    
    private ObservableList<Student> guests = FXCollections.observableArrayList();
    private ObservableList<Student> presentations = FXCollections.observableArrayList();

    public void loadControls() 
    {
        //fill hashmap
        final ObservableMap<Student, ObservableList<Presentation>> studentsMap = FXCollections.observableHashMap();
        
        for(GuestRequest g : guestRequestRepository.findAllGuests())
        {
            if(!studentsMap.containsKey(g.getStudent())) {
                studentsMap.put(g.getStudent(), FXCollections.observableList(new ArrayList<Presentation>()));
            }
            
            studentsMap.get(g.getStudent()).add(g.getPresentation());
        }
        
        guests = FXCollections.observableArrayList(studentsMap.keySet());

        lvGuests.setItems(guests);
        
        
        lvGuests.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {

            @Override
            public void changed(ObservableValue<? extends Student> ov, Student t, Student t1) 
            {
                lvPresentations.setItems(studentsMap.get(t1));
            }
        });
        
    }  
}
