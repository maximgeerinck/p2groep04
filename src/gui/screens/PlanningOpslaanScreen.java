/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.screens;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import jfxtras.scene.control.CalendarPicker;
import jfxtras.scene.control.CalendarTextField;
import jfxtras.scene.control.CalendarTimeTextField;
import model.IScreen;

/**
 *
 * @author Maxim
 */
public class PlanningOpslaanScreen implements IScreen 
{

    @Override
    public Pane getPane() 
    {
        GridPane root = new GridPane();        
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25 ,25 ,25));
        
        // zichtbaarheids periode
        CalendarTextField c1 = new CalendarTextField();
        CalendarTextField c2 = new CalendarTextField();                
        root.addRow(0, new Label("Start tijd:"), c1);
        root.addRow(1, new Label("Eind tijd:"), c2);
        
        // zichtbaar of niet
        root.addRow(2, new Label("Zichtbaar"), new CheckBox());
        
        // opslaan
        Button btnSave = new Button("Opslaan");
        root.addRow(3, btnSave);
        
        return root;
    }

    @Override
    public Scene showScreen() 
    {
        return new Scene(getPane(), 600, 600);
    }
    
    
    
}
