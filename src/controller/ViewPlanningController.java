/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Campus;
import entity.Location;
import entity.Planning;
import entity.Promotor;
import entity.Student;
import entity.TimeFrame;
import entity.User;
import gui.controls.DatePickerControl;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import jfxtras.scene.control.agenda.Agenda;
import model.CampusRepository;
import model.LocationRepository;
import model.TimeFrameRepository;
import model.UserRepository;
import org.controlsfx.control.BreadCrumbBar;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author Maxim
 */
public class ViewPlanningController 
{
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
    
    private Planning planning;
    private final PlanningController planningController = new PlanningController();
    private final TimeFrameRepository timeFrameRepository = new TimeFrameRepository();
    private final UserRepository userRepository = new UserRepository();
    private final CampusRepository campusRepository = new CampusRepository();
    private final LocationRepository locationRepository = new LocationRepository();
    
    public void loadControls() 
    {
        //load periodes
        final ObservableList<TimeFrame> timeframes = FXCollections.observableArrayList(timeFrameRepository.findAll());
        cbPeriode.getItems().setAll(timeframes);
        
        //load students
        final ObservableList<Student> students = FXCollections.observableArrayList(userRepository.findAllStudents());
        cbStudent.getItems().setAll(students);
        
        //load campus
        final ObservableList<Campus> campuses = FXCollections.observableArrayList(campusRepository.findAll());
        cbCampus.getItems().setAll(campuses);
        cbCampus.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Campus>(){

            @Override
            public void changed(ObservableValue<? extends Campus> ov, Campus cOld, Campus cNew) 
            {
                final ObservableList<Location> locations = FXCollections.observableArrayList(locationRepository.findByCampus(cNew));
                cbLocation.getItems().setAll(locations);                
                cbLocation.setPromptText("Choose a location please");
                if(locations.size() == 0) {
                    cbLocation.setPromptText("No locations found");
                }
            }        
        });                        
        
        cbLocation.disableProperty().bind(cbCampus.getSelectionModel().selectedItemProperty().isNull());
        cbLocation.setPromptText("Please choose a campus first");    
        
        //button add
        btnAddPresentation.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) 
            {
                planningController.createPresentation(planning, date.getCalendar(), (TimeFrame)cbPeriode.getValue(), (Location)cbLocation.getValue(), (Student)cbStudent.getValue());
                agenda.appointments().clear();
                loadAgenda();
            }
        });
    }
    
    public void loadAgenda() 
    {
        if(planning == null) {
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


        /*final Popup lPopup = new Popup();
        agenda.editAppointmentCallbackProperty().set(new Callback<Agenda.Appointment, Void>() {
            @Override
            public Void call(final Agenda.Appointment appointment) {
                
                //border layour wrapper
                BorderPane borderPane = new BorderPane();
                
                // gridpane -> contains popup view
                GridPane gridPane = new GridPane();
                gridPane.getStyleClass().add(getAgenda().getClass().getSimpleName() + "Popup");
                
                lPopup.setAutoFix(true);
                lPopup.setAutoHide(true);
                lPopup.setHideOnEscape(true);
                lPopup.setOnHidden(new EventHandler<WindowEvent>()
                {
                    @Override
                    public void handle(WindowEvent t) {
                        //todo
                    }
                });

                List<Promotor> promotors = userController.retrievePromotors();
                final ObservableList<Promotor> dataPromotors = observableArrayList(promotors.toArray(new Promotor[promotors.size()]));
                final ComboBox cbPromotor = new ComboBox(dataPromotors);
                cbPromotor.setPromptText("Please pick a promotor");
                gridPane.addRow(1, new Label("Promotor :"), cbPromotor);
                cbPromotor.valueProperty().addListener(new ChangeListener<Object>() {

                    @Override
                    public void changed(ObservableValue<? extends Object> ov, Object t, Object t1) {

                        // co-promotor
                        List<Promotor> coPromotors = new ArrayList<>();
                        // get already picked promotor if any
                        Promotor currentPromotor = ((Promotor)(cbPromotor.getSelectionModel().getSelectedItem()));
                        if(currentPromotor != null) {
                           for(Promotor u : (List<Promotor>)cbPromotor.getItems()) 
                           {
                               if(u.getId() != currentPromotor.getId()) {
                                   coPromotors.add(u);
                               }
                           } 
                        }
                        final ObservableList<Promotor> dataCoPromotors = observableArrayList(coPromotors.toArray(new Promotor[coPromotors.size()]));
                        cbCoPromotors.getItems().setAll(dataCoPromotors);
                        cbCoPromotors.setPromptText("Please choose a co-promotor");
                    }
                });

                //Co-Promotors
                cbCoPromotors.setPromptText("Kies een co-promotor");
                gridPane.addRow(2, new Label("Co-Promotor :"), cbCoPromotors);
                
                // save
                Button btnSave = new Button("Save");
                btnSave.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    public void handle(MouseEvent evt)
                    {
                        userController.attachPromotorToStudent(((PresentationProperty)appointment).getPresentation().getPresentator(), (Promotor)cbPromotor.getValue());
                        System.out.println(((Promotor)cbPromotor.getValue()).getLastName());
                        //userController.attachPromotorToStudent(((PresentationProperty)appointment).getPresentation().getPresentator(), (Promotor)cbCoPromotors.getValue());
                        System.out.println("opslaan");
                    }
                });   
                gridPane.addRow(3, btnSave);

                 //toolbar
                Button btnClose = new Button("X");
                btnClose.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    public void handle(MouseEvent evt)
                    {
                        lPopup.hide();
                    }
                });     
                btnClose.getStyleClass().add("close-icon");
                ToolBar toolbar = new ToolBar(btnClose);
                
                // add to borderpane
                borderPane.setTop(toolbar);
                borderPane.setCenter(gridPane);
                lPopup.getContent().add(borderPane);
                // get mouse cursor
                Point p = MouseInfo.getPointerInfo().getLocation();
                
                lPopup.show(primaryStage, p.x, p.y);
                return null;
            }
          
        });*/
        
        //dpAgendaRange.chronologyProperty().bindBidirectional(agenda.displayedCalendar());    
        dpAgendaRange.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               //t.notify();
            }
        });
        dpAgendaRange.calendarProperty().bindBidirectional(agenda.displayedCalendar());
        Agenda.AppointmentImpl[] presentations = planningController.retrievePresentations(planning);             
        agenda.appointments().addAll(presentations);         
    }
    
    public void setPlanning(Planning planning) 
    {
        this.planning = planning;
    }
}
