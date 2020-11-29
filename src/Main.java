import javafx.application.Application;
import javafx.stage.Stage;
import login.LoginController;

/**
 * @author Nevena Kolev
 * @version 1.0, 27.11.20
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //opens the login window
        LoginController.showStage(primaryStage);
    }

    public static void main(String[] args) {
        //launches the JavaFX Application
        launch(args);
    }
}