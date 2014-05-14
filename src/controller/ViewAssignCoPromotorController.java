package controller;

import entity.Campus;
import entity.Location;
import entity.Promotor;
import entity.Student;
import exceptions.CapacityReachedException;
import exceptions.InvalidJuryMemberException;
import exceptions.InvalidPromotorException;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import model.UserRepository;
import org.controlsfx.dialog.Dialogs;

/**
 * 
 * @author Maxim
 */
public class ViewAssignCoPromotorController {

    @FXML
    private ListView<Student> lvStudents;

    @FXML
    private ListView<Student> lvPromotorStudents;

    @FXML
    private Button btnAssign;

    @FXML
    private Button btnRemove;

    @FXML
    private ComboBox<Promotor> cbPromotor;
    
    private final UserRepository userRepository = new UserRepository();
    
    private ObservableList<Student> assignedStudents = FXCollections.observableArrayList();
    private ObservableList<Student> nonAssignedStudents = FXCollections.observableArrayList();
    
    @FXML
    void addHandle(ActionEvent event) throws CapacityReachedException, InvalidPromotorException
    {
        if(cbPromotor.getValue() == null || !(cbPromotor.getValue() instanceof Promotor)) {
            throw new IllegalArgumentException();
        }
        
        Student selected = (Student)lvStudents.getSelectionModel().getSelectedItem();
        Promotor promotor = (Promotor)cbPromotor.getValue();
        
        if(promotor.getStudents().size() >= 20) {
            throw new CapacityReachedException("Promotor heeft al 20 studenten");
        }
        
         if(selected.getPromotor() == null){
            org.controlsfx.control.action.Action response = Dialogs.create()
                    .title("Copromotor toekennen")
                    .masthead(null)
                    .message("Deze student heeft nog geen promotor.")
                    .lightweight()
                    .showWarning();
        }
        
        if(selected.getPromotor().equals(promotor))
        {
            
            org.controlsfx.control.action.Action response = Dialogs.create()
                    .title("Copromotor toekennen")
                    .masthead(null)
                    .message("Deze Copromotor is al de promotor van de student.")
                    .lightweight()
                    .showWarning();
           throw new InvalidPromotorException("Deze Copromotor is de promotor van de student.");
        }
        
        if(selected != null) {
            lvStudents.getSelectionModel().clearSelection();
            
            assignedStudents.add(selected);
            userRepository.assignStudentCopromotor(selected, cbPromotor.getValue());
            
            nonAssignedStudents.remove(selected);            
        }
    }

    @FXML
    void removeHandle(ActionEvent event) 
    {
        Student selected = (Student)lvPromotorStudents.getSelectionModel().getSelectedItem();
        if(cbPromotor.getValue() == null || !(cbPromotor.getValue() instanceof Promotor)) {
            throw new IllegalArgumentException();
        }
        if(selected != null) {
            lvStudents.getSelectionModel().clearSelection();
            nonAssignedStudents.add(selected);               
            assignedStudents.remove(selected);  
            userRepository.unassignStudentCopromotor(selected, cbPromotor.getValue());
        }
    }

    public void loadControls() 
    {
        //list views vullen
        nonAssignedStudents = FXCollections.observableArrayList(userRepository.findAllNonAssignedStudentsCop());

        lvStudents.setItems(nonAssignedStudents);
        lvPromotorStudents.setItems(assignedStudents);
        
        lvStudents.disableProperty().bind(cbPromotor.getSelectionModel().selectedItemProperty().isNull());
        btnAssign.disableProperty().bind(lvPromotorStudents.getSelectionModel().selectedItemProperty().isNotNull());
        btnRemove.disableProperty().bind(lvStudents.getSelectionModel().selectedItemProperty().isNotNull());
        
        //combobox vullen
        cbPromotor.setItems(FXCollections.observableArrayList(userRepository.findAllPromotors()));
        cbPromotor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Promotor>(){

            @Override
            public void changed(ObservableValue<? extends Promotor> ov, Promotor pOld, Promotor pNew) 
            {
                if(pNew != null) {
                    //load this promotor his assigned students
                    assignedStudents.setAll(userRepository.findStudentByPromotor(pNew));
                }                
            }        
        });   
    }  
}
