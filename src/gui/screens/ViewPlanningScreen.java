/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.screens;

import controller.PlanningController;
import controller.ResearchDomainController;
import controller.UserController;
import entity.Promotor;
import entity.ResearchDomain;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import jfxtras.scene.control.CalendarTextField;
import jfxtras.scene.control.agenda.Agenda;
import model.IScreen;

/**
 *
 * @author Maxim
 */
public class ViewPlanningScreen implements IScreen, Observer{

    private Agenda agenda;
    private PlanningController planningController = new PlanningController();
    private UserController userController = new UserController();
    private ResearchDomainController researchDomainController = new ResearchDomainController();
    private Calendar currentCalendar = Calendar.getInstance();

    public Agenda getAgenda() {
        return this.agenda;
    }

    public ViewPlanningScreen() {
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

            // accept new appointments
            /*agenda.createAppointmentCallbackProperty().set(new Callback<Agenda.CalendarRange, Agenda.Appointment>()
         {
         @Override
         public Agenda.Appointment call(Agenda.CalendarRange calendarRange)
         {
         return new Agenda.AppointmentImpl()
         .withStartTime(calendarRange.getStartCalendar())
         .withEndTime(calendarRange.getEndCalendar())
         .withSummary("new")
         .withDescription("new")
         .withAppointmentGroup(lAppointmentGroupMap.get("group01"));
         }
         });*/
        // set the presentations on the calendar
        agenda.appointments().addAll(planningController.retrievePresentations());
    }

    /**
     * get the calendar for the first day of the week
     *
     * @param locale
     * @param c
     */
    private static java.util.Calendar getFirstDayOfWeekCalendar(java.util.Locale locale, java.util.Calendar c) {
        // result
        int lFirstDayOfWeek = Calendar.getInstance(locale).getFirstDayOfWeek();
        int lCurrentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int lDelta = 0;
        if (lFirstDayOfWeek <= lCurrentDayOfWeek) {
            lDelta = -lCurrentDayOfWeek + lFirstDayOfWeek;
        } else {
            lDelta = -lCurrentDayOfWeek - (7 - lFirstDayOfWeek);
        }
        c = ((Calendar) c.clone());
        c.add(Calendar.DATE, lDelta);
        return c;
    }

    /**
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        //Redraw
        agenda.appointments().clear();
        agenda.appointments().addAll(planningController.retrievePresentations());
        System.out.println("Redraw calendar");
    }

    @Override
    public Pane getPane() {
        BorderPane root = new BorderPane();
        
        root.setCenter(agenda);
        
        // show all
        Button btnShowAll = new Button("Show all");
        btnShowAll.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
               
                agenda.appointments().clear();
                agenda.appointments().addAll(planningController.retrievePresentations());
                 
            }
            
        });
        
        // filter promotoren
        List<Promotor> promotors = userController.retrievePromotors();
        final ObservableList<Promotor> dataPromotors = observableArrayList(promotors.toArray(new Promotor[promotors.size()]));
        final ComboBox cbPromotor = new ComboBox(dataPromotors);
        cbPromotor.setPromptText("Please pick a promotor");
        cbPromotor.valueProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<? extends Object> ov, Object t, Object t1) {
                agenda.appointments().clear();
                agenda.appointments().addAll(planningController.retrievePresentationsByPromotor((Promotor)cbPromotor.getValue()));
            }
        });
                
        // filter domein               
        List<ResearchDomain> researchdomains = researchDomainController.findAll();
        final ObservableList<ResearchDomain> dataResearchDomains = observableArrayList(researchdomains.toArray(new ResearchDomain[researchdomains.size()]));
        final ComboBox cbResearchDomains = new ComboBox(dataResearchDomains);
        cbResearchDomains.setPromptText("Please pick a researchdomain");
        cbResearchDomains.valueProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<? extends Object> ov, Object t, Object t1) {
                agenda.appointments().clear();
                agenda.appointments().addAll(planningController.retrievePresentationsByResearchdomain((ResearchDomain)cbResearchDomains.getValue()));
            }
        });
        
        // button: shift calendar + 1 week
        CalendarTextField ctfWeekOf = new CalendarTextField();
        ctfWeekOf.setMinWidth(200);
        ctfWeekOf.calendarProperty().bindBidirectional(agenda.displayedCalendar());
        
        ToolBar toolBar = new ToolBar(
            btnShowAll,
            cbPromotor,
            cbResearchDomains,
            new Separator(Orientation.VERTICAL),
            ctfWeekOf            
        );
        root.setTop(toolBar);
        
        
         
        return root;
    }

    @Override
    public Scene showScreen() {
        return new Scene(getPane(), 600, 600);
    }

}
