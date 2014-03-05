/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.screens;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jfxtras.scene.control.CalendarTextField;
import model.IScreen;

/**
 *
 * @author Maxim
 */
public class PresentatieToevoegenScreen implements IScreen
{  

    public Scene showScreen() 
    {
        javafx.scene.layout.GridPane root = new javafx.scene.layout.GridPane();        
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25 ,25 ,25));

        root.addRow(0, new Label("Start tijd"), new CalendarTextField());
        root.addRow(1, new Label("Eind tijd"), new CalendarTextField());
        
        ObservableList<String> options = 
        FXCollections.observableArrayList(
            "Campus Schoonmeersen",
            "Campus Aalst"           
        );
        final ComboBox cbCampus = new ComboBox(options);
        root.addRow(2, new Label("Campus"), cbCampus);
        
        ObservableList<String> optLokalen = 
        FXCollections.observableArrayList(
            "B4001",
            "B4002",           
            "B4003"
        );
        final ComboBox cbLokalen = new ComboBox(optLokalen);
        root.addRow(3, new Label("Lokaal"), cbLokalen);
        
        ObservableList<String> optPromotoren = 
        FXCollections.observableArrayList(
            "Ikke",
            "Iemand anders",           
            "..."
        );
        final ComboBox cnPromotoren = new ComboBox(optPromotoren);
        root.addRow(4, new Label("Promotor"), cnPromotoren);
        
        ObservableList<String> optCoPromotoren = 
        FXCollections.observableArrayList(
            "Ikke",
            "Iemand anders",           
            "..."          
        );
        final ComboBox cbCoPromotoren = new ComboBox(optCoPromotoren);
        root.addRow(5, new Label("Co-Promotor"), cbCoPromotoren);
        
        ObservableList<String> optPresentatoren = 
        FXCollections.observableArrayList(
            "Ikke",
            "Iemand anders",           
            "..."          
        );
        final ComboBox cbPresentatoren = new ComboBox(optPresentatoren);
        root.addRow(6, new Label("Presentator"), cbPresentatoren);
        root.addRow(7, new Label("Onderwerp"), new TextField());
        root.addRow(8, new Label("Tijdstip"), new TextField());
        
        Button btnAdd = new Button("Toevoegen");
        root.addRow(9, btnAdd);

        return new Scene(root, 600, 600);
    }

}
