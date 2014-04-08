/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Maxim
 */
public class ViewEntityController 
{
    @FXML
    private Label lblTitle;
    
    @FXML
    private Button btnSave;
    
    @FXML
    private Button btnCancel;

    @FXML
    private GridPane gpView;
    
    private Stage stage;
    
    
    public void btnCancelHandle(ActionEvent t) {
        stage.close();
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    public GridPane getGpView() {
        return gpView;
    }

    public void setGpView(GridPane gpView) {
        this.gpView = gpView;
    }    

    public Button getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }        
}
