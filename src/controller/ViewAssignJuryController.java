package controller;

import entity.Promotor;
import entity.Student;
import exceptions.InvalidJuryMemberException;
import java.util.ArrayList;
import java.util.Collection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import model.PresentationRepository;
import model.UserRepository;

/**
 * 
 * @author Maxim
 */
public class ViewAssignJuryController {

    @FXML
    private ListView<Student> lvPresentation;

    @FXML
    private ListView<Student> lvJuryPresentation;

    @FXML
    private Button btnAssign;

    @FXML
    private Button btnRemove;

    @FXML
    private ComboBox<Promotor> cbPromotor;
    
    
    private final UserRepository userRepository = new UserRepository();
    private final PresentationRepository presentationRepository = new PresentationRepository();
    private PlanningController planningController = new PlanningController();
    
    private ObservableList<Student> assignedPresentations = FXCollections.observableArrayList();
    private ObservableList<Student> nonAssignedPresentations = FXCollections.observableArrayList();
    
    
    @FXML
    void addHandle(ActionEvent event) throws InvalidJuryMemberException
    {
        if(cbPromotor.getValue() == null || !(cbPromotor.getValue() instanceof Promotor)) {
            throw new IllegalArgumentException();
        }
        
        Student selected = (Student)lvPresentation.getSelectionModel().getSelectedItem();
        Promotor jury = (Promotor)cbPromotor.getValue();
        
        
        if(selected.getPresentation().getPromotor().equals(jury) || selected.getPresentation().getCoPromotor().equals(jury))
        {
            throw new InvalidJuryMemberException("The selected promotor can't be a jurymember for this student.");
        }
        
        if(selected != null) {
            lvPresentation.getSelectionModel().clearSelection();
            
            assignedPresentations.add(selected);
            
            planningController.attachJury(selected.getPresentation().getPromotor(), selected.getPresentation().getCoPromotor(), jury, selected.getPresentation());
            
            nonAssignedPresentations.remove(selected);            
        }
    }

    @FXML
    void removeHandle(ActionEvent event) 
    {
        Student selected = (Student)lvPresentation.getSelectionModel().getSelectedItem();
        if(cbPromotor.getValue() == null || !(cbPromotor.getValue() instanceof Promotor)) {
            throw new IllegalArgumentException();
        }
        if(selected != null) {
            lvPresentation.getSelectionModel().clearSelection();
            nonAssignedPresentations.add(selected);               
            assignedPresentations.remove(selected);  
            
            selected.getPresentation().setJuryLid(null);
        }
    }

    public void loadControls() 
    {
        //list views vullen
        nonAssignedPresentations = FXCollections.observableArrayList(userRepository.findAllNonAssignedStudentsJury());

        lvPresentation.setItems(nonAssignedPresentations);
        lvJuryPresentation.setItems(assignedPresentations);
        
        
        lvPresentation.disableProperty().bind(cbPromotor.getSelectionModel().selectedItemProperty().isNull());
        btnAssign.disableProperty().bind(lvJuryPresentation.getSelectionModel().selectedItemProperty().isNotNull());
        btnRemove.disableProperty().bind(lvPresentation.getSelectionModel().selectedItemProperty().isNotNull());
        
        //combobox vullen
        cbPromotor.setItems(FXCollections.observableArrayList(userRepository.findAllPromotors()));
        cbPromotor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Promotor>(){

            @Override
            public void changed(ObservableValue<? extends Promotor> ov, Promotor pOld, Promotor pNew) 
            {
                if(pNew != null) {
                    //load this promotor his assigned students
                    assignedPresentations.setAll(userRepository.findAssignedStudentsJury(pNew));
                     //assignedPresentations.setAll(userRepository.findStudentByPromotor(pNew));
                }                
            }        
        });   
    }  
}
