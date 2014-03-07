import javafx.application.*;
import gui.*;
import gui.screens.PresentatieToevoegenScreen;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import jfxtras.scene.layout.VBox;
import model.ScreenFactory;

/**
 * @author Maxim
 */
public class StartUp extends Application {

	private GraphicApplication application = new GraphicApplication();

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
        {
            launch(args);
	}

	/**
	 * 
	 * @param primaryStage
	 */
	@Override
	public void start(javafx.stage.Stage primaryStage) {
            primaryStage.setTitle("Planning overzicht");

            SplitPane root = new SplitPane();
            StackPane sp1 = new StackPane();
            sp1.getChildren().add(application.getAgenda());

            /* SIDEBAR */
            VBox v = new VBox();
            v.setMinWidth(350);

            Accordion a = new Accordion();

            // Presentatie toevoegen
            PresentatieToevoegenScreen presentaties = (PresentatieToevoegenScreen)ScreenFactory.createScreen(ScreenFactory.SCREEN_PRESENTATIE_TOEVOEGEN);
            presentaties.addObserver(application);
            TitledPane tpPresentaties = new TitledPane("Presentatie toevoegen", presentaties.getPane());
            a.getPanes().add(tpPresentaties);
            a.setExpandedPane(tpPresentaties);        
            v.add(a);

            root.getItems().addAll(sp1, v);
            root.setDividerPositions(0.9f, 0.6f, 0.9f);
            primaryStage.setScene(new Scene(root, 1500, 900));
            primaryStage.show();
	}

}