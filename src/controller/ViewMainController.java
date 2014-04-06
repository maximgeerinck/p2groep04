/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ResearchDomain;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.ResearchDomainRepository;
import org.controlsfx.control.ButtonBar;

/**
 *
 * @author Maxim
 */
public class ViewMainController {

    @FXML
    private Button btnPlanningAdd;

    @FXML
    private Button btnResearchdomainAdd;

    @FXML
    private GridPane gpResearchdomains;

    @FXML
    private GridPane gpPlannings;

    ResearchDomainRepository researchDomainRepository = new ResearchDomainRepository();
    private int gpRSCurrentRow = 0;

    public void attachGridviews(final Stage stage) {
        List<ResearchDomain> researchdomains = researchDomainRepository.findAll();
        for (ResearchDomain rs : researchdomains) {
            gpResearchdomains.add(new Label(rs.getName()), 0, gpRSCurrentRow);
            final ResearchDomain currentRs = rs;

            ButtonBar buttonBar = new ButtonBar();
            // create button with action
            Button buttonView = new Button("View");
            buttonView.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    btnRsViewHandle(t, currentRs);
                }
            });

            Button buttonAdd = new Button("Add");
            buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    btnRsAddHandle(t);
                }
            });

            buttonBar.getButtons().addAll(buttonView, buttonAdd);
            gpResearchdomains.add(buttonBar, 1, gpRSCurrentRow);
            gpRSCurrentRow++;
        }
    }

    public void btnRsViewHandle(ActionEvent t, final ResearchDomain currentRs) {
        try {
            //create stage
            final Stage newStage = new Stage();

            //load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/ViewEntity.fxml"));
            loader.load();

            //Configure controller
            ViewEntityController controller = loader.getController();
            controller.setTitle("View researchdomain");
            controller.setStage(newStage);
            GridPane gp = controller.getGpView();

            // Form
            gp.add(new Label("Name: "), 0, 0);
            final TextField txtName = new TextField(currentRs.getName());
            gp.add(txtName, 1, 0);

            // Action
            controller.getBtnSave().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    currentRs.setName(txtName.getText());
                    researchDomainRepository.update(currentRs);
                    newStage.close();
                }
            });
            BorderPane root = loader.getRoot();
            Scene stageScene = new Scene(root, 600, 400);

            newStage.setScene(stageScene);
            newStage.setTitle("View researchdomain");
            newStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void btnRsAddHandle(ActionEvent t) {
        try {
            //create stage
            final Stage newStage = new Stage();

            //load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/ViewEntity.fxml"));
            loader.load();

            //Configure controller
            ViewEntityController controller = loader.getController();
            controller.setTitle("Add researchdomain");
            controller.setStage(newStage);
            GridPane gp = controller.getGpView();

            // Form
            gp.add(new Label("Name: "), 0, 0);
            final TextField txtName = new TextField();
            gp.add(txtName, 1, 0);

            // Action
            controller.getBtnSave().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    researchDomainRepository.create(txtName.textProperty().get());
                    newStage.close();
                }
            });
            BorderPane root = loader.getRoot();
            Scene stageScene = new Scene(root, 600, 400);

            newStage.setScene(stageScene);
            newStage.setTitle("View researchdomain");
            newStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
