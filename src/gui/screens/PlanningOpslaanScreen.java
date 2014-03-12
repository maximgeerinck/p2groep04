/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.screens;

import controller.PlanningController;
import entity.Planning;
import java.sql.Timestamp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import jfxtras.scene.control.CalendarTextField;
import model.IScreen;

/**
 *
 * @author Maxim
 */
public class PlanningOpslaanScreen implements IScreen 
{
    
    private PlanningController planningController = new PlanningController();
    private CalendarTextField ctEndTime;
    private CalendarTextField ctStartTime;
    private CheckBox cbVisibility;
    
    @Override
    public Pane getPane() 
    {
        GridPane root = new GridPane();        
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25 ,25 ,25));
        
        // zichtbaar of niet
        cbVisibility = new CheckBox();
        cbVisibility.setSelected(true);
        root.addRow(0, new Label("Zichtbaar :"), cbVisibility);
        
        // zichtbaarheids periode
        ctEndTime = new CalendarTextField();
        ctStartTime = new CalendarTextField();                
        root.addRow(1, new Label("Vanaf :"), ctEndTime);
        root.addRow(2, new Label("Tot :"), ctStartTime);
        
        // opslaan
        Button btnSave = new Button("Opslaan");
        btnSave.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                
                Planning planning = planningController.retrievePlanning(1);
                
                // registreer visibility
                Timestamp t1 = new Timestamp(PlanningOpslaanScreen.this.getCtStartTime().getCalendar().getTimeInMillis());
                Timestamp t2 = new Timestamp(PlanningOpslaanScreen.this.getCtEndTime().getCalendar().getTimeInMillis());
                planningController.registerVisibilityPeriod(planning, t1, t2);
                
                // registreer enabled of niet 
                planningController.changePlanningVisibility(planning, !PlanningOpslaanScreen.this.getCbVisibility().isIndeterminate());                
            }
            
        });
        root.addRow(3, btnSave);
        
        return root;
    }

    @Override
    public Scene showScreen() 
    {
        return new Scene(getPane(), 600, 600);
    }

    public CalendarTextField getCtEndTime() {
        return ctEndTime;
    }

    public void setCtEndTime(CalendarTextField ctEndTime) {
        this.ctEndTime = ctEndTime;
    }

    public CalendarTextField getCtStartTime() {
        return ctStartTime;
    }

    public void setCtStartTime(CalendarTextField ctStartTime) {
        this.ctStartTime = ctStartTime;
    }  

    public CheckBox getCbVisibility() {
        return cbVisibility;
    }

    public void setCbVisibility(CheckBox cbVisibility) {
        this.cbVisibility = cbVisibility;
    }    
}
