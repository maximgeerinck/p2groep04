/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Planning;
import entity.ResearchDomain;
import java.io.IOException;
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
import model.PlanningRepository;
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
    private Button btnAssignPromotor;
    
    @FXML
    private Button btnAssignJury;
     
    @FXML
    private GridPane gpPlannings;

    ResearchDomainRepository researchDomainRepository = new ResearchDomainRepository();
    PlanningRepository planningRepository = new PlanningRepository();
    private int gpRSCurrentRow = 0;
    private int gpPlanningCurrentRow = 0;

    public void attachGridviews(final Stage stage) 
    {
        addPlanningsGP();
        addResearchdomainGP();
    }
    
    @FXML
    void assignPromotorHandle(ActionEvent event) throws IOException 
    {
        final Stage newStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/ViewAssignPromotor.fxml"));
        loader.load();

        ViewAssignPromotorController controller = loader.getController();
        if(controller != null) 
        {
            controller.loadControls();  
        }  
                        
        BorderPane root = loader.getRoot();
        Scene scene = new Scene(root, 600, 400);       

        newStage.setTitle("Promotor toekennen");
        newStage.setScene(scene);

        newStage.show();
    }
    
    @FXML
    void assignJuryHandle(ActionEvent event) throws IOException 
    {
        final Stage newStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/ViewAssignJury.fxml"));
        loader.load();

        ViewAssignJuryController controller = loader.getController();
        if(controller != null) 
        {
            controller.loadControls();  
        }  
                        
        BorderPane root = loader.getRoot();
        Scene scene = new Scene(root, 600, 400);       

        newStage.setTitle("Jurylid toekennen");
        newStage.setScene(scene);

        newStage.show();
    }
    
    @FXML
    void grHandle(ActionEvent event) throws IOException
    {
        final Stage newStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/ViewRegisterGuest.fxml"));
        loader.load();

        ViewRegisterGuest controller = loader.getController();
        if(controller != null) 
        {
            controller.loadControls();  
        }  
                        
        BorderPane root = loader.getRoot();
        Scene scene = new Scene(root, 600, 400);       

        newStage.setTitle("Registreer guests");
        newStage.setScene(scene);

        newStage.show();
    }
    

    public void addPlanningsGP() 
    {
        List<Planning> plannings = planningRepository.findAll();
        for(Planning p : plannings) 
        {
            gpPlannings.add(new Label(Long.toString(p.getId())), 0, gpPlanningCurrentRow);

            final Planning planning = p;
            System.out.println(p == null);
            
            Button btnView = new Button("View");
            btnView.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) 
                {
                    try 
                    {
                        final Stage newStage = new Stage();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/ViewPlanning.fxml"));
                        loader.load();

                        ViewPlanningController controller = loader.getController();
                        if(controller != null) {
                            controller.setPlanning(planning);
                            controller.loadAgenda(); 
                            controller.loadControls();
                        }                    

                        BorderPane root = loader.getRoot();
                        Scene scene = new Scene(root, 1500, 900);       
                        scene.getStylesheets().add("resources/agenda/skin/agenda.css");
                        
                        newStage.setTitle("Planning overzicht");
                        newStage.setScene(scene);

                        newStage.show();
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            });

            gpPlannings.add(btnView, 1, gpRSCurrentRow);
            gpPlanningCurrentRow++;
        }
    }
    
    public void addPlanningHandle() throws IOException 
    {
        //create new planning
        Planning planning = planningRepository.create();      
        
        final Stage newStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/ViewPlanning.fxml"));
        loader.load();

        ViewPlanningController controller = loader.getController();
        if(controller != null) 
        {
            controller.loadControls();  
            controller.setPlanning(planning);
        }  
                        
        BorderPane root = loader.getRoot();
        Scene scene = new Scene(root, 1500, 900);       
        scene.getStylesheets().add("resources/agenda/skin/agenda.css");
        
        newStage.setTitle("Planning overzicht");
        newStage.setScene(scene);

        newStage.show();
    }
    
    public void addResearchdomainGP()
    {
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
