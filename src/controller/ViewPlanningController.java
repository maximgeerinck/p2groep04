/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Promotor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import jfxtras.scene.control.agenda.Agenda;
import model.PresentationProperty;
import org.controlsfx.control.BreadCrumbBar;

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
    
    private PlanningController planningController = new PlanningController();
    
    public void loadAgenda() {
        agenda = new Agenda();

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

        agenda.appointments().addAll(planningController.retrievePresentations());
    }
}
