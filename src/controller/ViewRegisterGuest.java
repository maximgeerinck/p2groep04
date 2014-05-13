package controller;

import entity.GuestRequest;
import entity.Presentation;
import entity.Student;
import helpers.MailHelper;
import helpers.TemplateParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;
import model.GuestRequestRepository;
import model.UserRepository;
import org.controlsfx.dialog.Dialogs;

/**
 * 
 * @author Maxim
 */
public class ViewRegisterGuest {

    @FXML
    private ListView<Student> lvGuests;

    @FXML
    private ListView<GuestRequest> lvPresentations;

    @FXML
    private Button btnRegister;
    
    private final GuestRequestRepository guestRequestRepository = new GuestRequestRepository();
    
    private ObservableList<Student> guests = FXCollections.observableArrayList();
    
    public void loadControls() 
    {
        //fill hashmap
        final ObservableMap<Student, ObservableList<GuestRequest>> studentsMap = FXCollections.observableHashMap();
        
        for(GuestRequest g : guestRequestRepository.findAllGuests())
        {
            if(!studentsMap.containsKey(g.getStudent())) {
                studentsMap.put(g.getStudent(), FXCollections.observableList(new ArrayList<GuestRequest>()));
            }
            
            System.out.println(g.getPresentation());
            
            studentsMap.get(g.getStudent()).add(g);
        }
        
        guests = FXCollections.observableArrayList(studentsMap.keySet());

        lvGuests.setItems(guests);
        
        // add checkbox to listview
        Callback<GuestRequest, ObservableValue<Boolean>> getProperty = new Callback<GuestRequest, ObservableValue<Boolean>>() {
            @Override
            public BooleanProperty call(GuestRequest layer) {

                return layer.approvedProperty();

            }
        };
        Callback<ListView<GuestRequest>, ListCell<GuestRequest>> forListView = CheckBoxListCell.forListView(getProperty);
        lvPresentations.setCellFactory(forListView);
                
        lvGuests.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {

            @Override
            public void changed(ObservableValue<? extends Student> ov, Student t, Student t1) 
            {
                lvPresentations.setItems(studentsMap.get(t1));
                
                List<GuestRequest> grs = new ArrayList<>();                
                
            }
        });
  
    }  
    
    @FXML
    void registerHandle(ActionEvent event) 
    {
        String grs = "<ul>";        
        guestRequestRepository.getEm().getTransaction().begin();
        Student guest = null;
        for(GuestRequest gr : lvPresentations.getItems()) 
        {
            if(guest == null) {
                guest = gr.getStudent();
            }
            gr.setApproved(gr.approvedProperty().get());
            
            if(gr.isApproved()) {
                grs += "<li>" + gr.toString() + " tijdslot: " + gr.getPresentation().getTimeFrame() + "</li>";
            }
        }
        grs += "</ul>";
        guestRequestRepository.getEm().getTransaction().commit();
        
        
        Map<String, String> m = new HashMap<>();
        m.put("guestRequests", grs);
        
        MailHelper.sendEmail(guest.getEmail(), "Gasten werden geregistreerd", TemplateParser.parse("EmailRegisterGuest.html", m));
        
        org.controlsfx.control.action.Action response = Dialogs.create()
            .title("Gasten")
            .masthead(null)
            .message("De wijzigingen werden succesvol opgeslagen.")
            .lightweight()
            .showWarning();
    }

}
