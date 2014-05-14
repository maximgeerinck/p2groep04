/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import agenda.AgendaWeekSkin;
import entity.Campus;
import entity.Location;
import entity.Planning;
import entity.Presentation;
import entity.Promotor;
import entity.ResearchDomain;
import entity.Student;
import entity.TimeFrame;
import exceptions.DuplicateEntryException;
import exceptions.PersonHasPresentationException;
import gui.controls.DatePickerControl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import agenda.Agenda;
import agenda.Agenda.AppointmentImpl;
import model.CampusRepository;
import model.LocationRepository;
import model.PresentationRepository;
import model.ResearchDomainRepository;
import model.TimeFrameRepository;
import model.UserRepository;
import org.controlsfx.control.BreadCrumbBar;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author Maxim
 */
public class ViewPlanningController {

    @FXML
    private Button btnSavePlanning;

    @FXML
    private ComboBox cbPeriode;

    @FXML
    private Button btnAddPresentation;

    @FXML
    private BreadCrumbBar breadcrumb;

    @FXML
    private Agenda agenda;

    @FXML
    private DatePickerControl dpAgendaRange;

    @FXML
    private ComboBox cbStudent;

    @FXML
    private ComboBox cbLocation;

    @FXML
    private ComboBox cbCampus;

    @FXML
    private DatePickerControl date;

    @FXML
    private Button btnSaveSettings;

    

    /* PLANNING VISIBILITY */
    @FXML
    private CheckBox cbVisible;

    @FXML
    private DatePickerControl dpVisibleStart;

    @FXML
    private DatePickerControl dpVisibleEnd;

    @FXML
    private Button btnMakeVisible;

    /* FILTER */
    @FXML
    private ComboBox cbFilterPromotor;

    @FXML
    private ComboBox cbFilterCoPromotor;

    @FXML
    private ComboBox cbFilterResearchDomain;
    
    @FXML
    private Button btnFilterReset;

    private Planning planning;
    private final PlanningController planningController = new PlanningController();
    private final PresentationRepository presentationRepository = new PresentationRepository();
    private final TimeFrameRepository timeFrameRepository = new TimeFrameRepository();
    private final UserRepository userRepository = new UserRepository();
    private final CampusRepository campusRepository = new CampusRepository();
    private final LocationRepository locationRepository = new LocationRepository();
    private final ResearchDomainRepository researchDomainRepository = new ResearchDomainRepository();
    
    private ObservableList<TimeFrame> timeframes = FXCollections.observableArrayList();
    private ObservableList<Student> students = FXCollections.observableArrayList();
    private ObservableList<Campus> campuses = FXCollections.observableArrayList();
    private ObservableList<Promotor> promotors = FXCollections.observableArrayList();
    
    private AppointmentImpl[] cacheAllPresentations;        
    
    public void loadControls() {
                
        //load periodes
        timeframes.setAll(timeFrameRepository.findAll());
        students.setAll(userRepository.findAllStudents());
        campuses.setAll(campusRepository.findAll());
        promotors.setAll(userRepository.findAllPromotors());
        
        cbPeriode.getItems().setAll(timeframes);
        cbStudent.getItems().setAll(students);
        cbCampus.getItems().setAll(campuses);
        cbFilterPromotor.setItems(promotors);
        cbFilterCoPromotor.setItems(promotors);
        cbFilterResearchDomain.setItems(FXCollections.observableArrayList(researchDomainRepository.findAll()));                

        cbCampus.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Campus>() {

            @Override
            public void changed(ObservableValue<? extends Campus> ov, Campus cOld, Campus cNew) {
                final ObservableList<Location> locations = FXCollections.observableArrayList(locationRepository.findByCampus(cNew));
                cbLocation.getItems().setAll(locations);
                cbLocation.setPromptText("Choose a location please");
                if (locations.size() == 0) {
                    cbLocation.setPromptText("No locations found");
                }
            }
        });

        cbLocation.disableProperty().bind(cbCampus.getSelectionModel().selectedItemProperty().isNull());
        cbLocation.setPromptText("Please choose a campus first");
        
        /* FILTER */
        cbFilterPromotor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Promotor>(){

            @Override
            public void changed(ObservableValue<? extends Promotor> ov, Promotor pOld, Promotor pNew) 
            {
                List<Presentation> presentations = presentationRepository.findAllByPlanningPromotor(planning, pNew);
                agenda.appointments().setAll(planningController.retrievePresentations(presentations));
            }
            
        });
        
        cbFilterCoPromotor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Promotor>(){

            @Override
            public void changed(ObservableValue<? extends Promotor> ov, Promotor pOld, Promotor pNew) 
            {
                List<Presentation> presentations = presentationRepository.findAllByPlanningPromotor(planning, pNew);
                agenda.appointments().setAll(planningController.retrievePresentations(presentations));
            }
            
        });
        
        cbFilterResearchDomain.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ResearchDomain>(){

            @Override
            public void changed(ObservableValue<? extends ResearchDomain> ov, ResearchDomain rOld, ResearchDomain rNew) 
            {
                List<Presentation> presentations = presentationRepository.findAllByPlanningResearchdomain(planning, rNew);
                agenda.appointments().setAll(planningController.retrievePresentations(presentations));
            }
            
        });
    }

    @FXML
    void filterResetHandle()
    {
        agenda.appointments().setAll(cacheAllPresentations);
        
        //reset comboboxes

    }
    
    @FXML
    void addPresentationHandle() 
    {
        try {
            planningController.createPresentation(planning, date.getCalendar(), (TimeFrame) cbPeriode.getValue(), (Location) cbLocation.getValue(), (Student) cbStudent.getValue());
        } catch (DuplicateEntryException ex) {
            //Logger.getLogger(ViewPlanningController.class.getName()).log(Level.SEVERE, null, ex);
            org.controlsfx.control.action.Action response = Dialogs.create()
                    .title("Presentations")
                    .masthead(null)
                    .message("Er is al een presentatie gepland op dat tijdstip en die plaats.")
                    .lightweight()
                    .showWarning();
        } catch (PersonHasPresentationException ex) {
            //Logger.getLogger(ViewPlanningController.class.getName()).log(Level.SEVERE, null, ex);
            org.controlsfx.control.action.Action response = Dialogs.create()
                    .title("Presentations")
                    .masthead(null)
                    .message("Deze student heeft al een presentatie.")
                    .lightweight()
                    .showWarning();
        }
        agenda.appointments().clear();
        loadAgenda();
    }

    @FXML
    void makeVisibleHandle() 
    {
        try {
            planningController.changePlanningVisibility(planning, cbVisible.selectedProperty().get());
            planningController.registerVisibilityPeriod(planning, dpVisibleStart.getCalendar(), dpVisibleEnd.getCalendar());

            org.controlsfx.control.action.Action response = Dialogs.create()
                    .title("Planning")
                    .masthead(null)
                    .message("De planning werd zichtbaar gemaakt")
                    .lightweight()
                    .showWarning();
        } catch (Exception ex) {
            org.controlsfx.control.action.Action response = Dialogs.create()
                    .title("Planning")
                    .masthead(null)
                    .message(ex.getMessage())
                    .lightweight()
                    .showWarning();
        }
    }

    public void loadAgenda() {
        if (planning == null) {
            throw new IllegalArgumentException("Planning was null, or not loaded");
        }
        
        // setup appointment groups
        final Map<String, Agenda.AppointmentGroup> lAppointmentGroupMap = new TreeMap<String, Agenda.AppointmentGroup>();

        //APOINTMENT GROUPS ZIJN DE KLEUREN VAN DE KALENDER ITEM
        lAppointmentGroupMap.put("group00", new Agenda.AppointmentGroupImpl().withStyleClass("group0"));
        lAppointmentGroupMap.put("group01", new Agenda.AppointmentGroupImpl().withStyleClass("group1"));
        lAppointmentGroupMap.put("group02", new Agenda.AppointmentGroupImpl().withStyleClass("group2"));
        lAppointmentGroupMap.put("group03", new Agenda.AppointmentGroupImpl().withStyleClass("group3"));
        lAppointmentGroupMap.put("group04", new Agenda.AppointmentGroupImpl().withStyleClass("group4"));
        lAppointmentGroupMap.put("group05", new Agenda.AppointmentGroupImpl().withStyleClass("group5"));
        lAppointmentGroupMap.put("group06", new Agenda.AppointmentGroupImpl().withStyleClass("group6"));
        lAppointmentGroupMap.put("group07", new Agenda.AppointmentGroupImpl().withStyleClass("group7"));
        lAppointmentGroupMap.put("group08", new Agenda.AppointmentGroupImpl().withStyleClass("group8"));
        lAppointmentGroupMap.put("group09", new Agenda.AppointmentGroupImpl().withStyleClass("group9"));
        lAppointmentGroupMap.put("group10", new Agenda.AppointmentGroupImpl().withStyleClass("group10"));
        lAppointmentGroupMap.put("group11", new Agenda.AppointmentGroupImpl().withStyleClass("group11"));
        lAppointmentGroupMap.put("group12", new Agenda.AppointmentGroupImpl().withStyleClass("group12"));
        lAppointmentGroupMap.put("group13", new Agenda.AppointmentGroupImpl().withStyleClass("group13"));
        lAppointmentGroupMap.put("group14", new Agenda.AppointmentGroupImpl().withStyleClass("group14"));
        lAppointmentGroupMap.put("group15", new Agenda.AppointmentGroupImpl().withStyleClass("group15"));
        lAppointmentGroupMap.put("group16", new Agenda.AppointmentGroupImpl().withStyleClass("group16"));
        lAppointmentGroupMap.put("group17", new Agenda.AppointmentGroupImpl().withStyleClass("group17"));
        lAppointmentGroupMap.put("group18", new Agenda.AppointmentGroupImpl().withStyleClass("group18"));
        lAppointmentGroupMap.put("group19", new Agenda.AppointmentGroupImpl().withStyleClass("group19"));
        lAppointmentGroupMap.put("group20", new Agenda.AppointmentGroupImpl().withStyleClass("group20"));
        lAppointmentGroupMap.put("group21", new Agenda.AppointmentGroupImpl().withStyleClass("group21"));
        lAppointmentGroupMap.put("group22", new Agenda.AppointmentGroupImpl().withStyleClass("group22"));
        lAppointmentGroupMap.put("group23", new Agenda.AppointmentGroupImpl().withStyleClass("group23"));

        for (String lId : lAppointmentGroupMap.keySet()) {
            Agenda.AppointmentGroup lAppointmentGroup = lAppointmentGroupMap.get(lId);
            lAppointmentGroup.setDescription(lId);
            agenda.appointmentGroups().add(lAppointmentGroup);
        }

        dpAgendaRange.calendarProperty().bindBidirectional(agenda.displayedCalendar());
        cacheAllPresentations = planningController.retrievePresentations(planning);
        agenda.appointments().addAll(cacheAllPresentations);
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }
}
