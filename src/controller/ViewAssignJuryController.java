package controller;

import entity.Presentation;
import entity.Promotor;
import entity.Student;
import exceptions.InvalidJuryMemberException;
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
import model.PresentationRepository;
import model.UserRepository;
import org.controlsfx.dialog.Dialogs;

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
        
        Presentation presentatie = presentationRepository.findPresentationByStudent(selected);
        
        if(selected.getPromotor() == null){
            org.controlsfx.control.action.Action response = Dialogs.create()
                    .title("Jury toekennen")
                    .masthead(null)
                    .message("Deze student heeft nog geen promotor.")
                    .lightweight()
                    .showWarning();
        }
        
        if(selected.getPromotor().equals(jury))
        {
            // || selected.getCoPromotor().equals(jury)
            org.controlsfx.control.action.Action response = Dialogs.create()
                    .title("Assign Jury")
                    .masthead(null)
                    .message("Dit jurylid is de promotor of copromotor van de student, kies een ander jurylid.")
                    .lightweight()
                    .showWarning();
            throw new InvalidJuryMemberException("De geselecteerde promotor kan geen jurylid zijn voor de student.");
            
        }
        List<Presentation> presentationsAttending = selected.getPromotor().getPresentationsAttending();
        
        for(Presentation p: presentationsAttending){
            if(p.getDate().equals(selected.getPresentation().getDate()) && p.getTimeFrame().equals(selected.getPresentation().getTimeFrame()))
            {
                org.controlsfx.control.action.Action response = Dialogs.create()
                    .title("Assign Jury")
                    .masthead(null)
                    .message("Dit jurylid heeft al een presentatie op dat moment.")
                    .lightweight()
                    .showWarning();
            }
        }
        
        if(selected != null) {
            lvPresentation.getSelectionModel().clearSelection();
            
            assignedPresentations.add(selected);

            planningController.attachJury(jury, presentationRepository.findPresentationByStudent(selected));
            
            nonAssignedPresentations.remove(selected);            
        }
    }

    @FXML
    void removeHandle(ActionEvent event) 
    {
        Student selected = (Student)lvPresentation.getSelectionModel().getSelectedItem();
        Promotor jury = (Promotor)cbPromotor.getValue();
        if(cbPromotor.getValue() == null || !(cbPromotor.getValue() instanceof Promotor)) {
            throw new IllegalArgumentException();
        }
        if(selected != null) {
            
            lvPresentation.getSelectionModel().clearSelection();
            nonAssignedPresentations.add(selected);               
            assignedPresentations.remove(selected);  
            
            planningController.removeJury(jury, presentationRepository.findPresentationByStudent(selected));
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
                     
                }                
            }        
        });   
    }  
}
