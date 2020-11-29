package login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import main.MainController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController implements Initializable {
    //attributes
    private Stage stage;
    @FXML private Rectangle rect_border = new Rectangle();
    @FXML private Label lbl_logo = new Label();
    @FXML private Label lbl_welcome = new Label();
    @FXML private Label lbl_userName = new Label();
    @FXML private Label lbl_password = new Label();
    @FXML private TextField txtf_userNameInput = new TextField();
    @FXML private TextField txtf_password = new TextField();
    @FXML private Button btn_login = new Button();

    //getter and setter
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public static void showStage(Stage stage) {
        try {
            //loads the .fxml file that is associated to this controller
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("login.fxml"));
            //gets the anchorPane from the .fxml which will be displayed in a stage
            Parent root = fxmlLoader.load();

            //get the controller that is connected to this fxml file and sets its stage
            LoginController ctrl = fxmlLoader.getController();
            //sets this stage to the controller LoginController
            ctrl.setStage(stage);

            //sets stage settings
            stage.setTitle("Login");
            //sets a new scene with the content of parent 'root'
            stage.setScene(new Scene(root));
            //displays this stage
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Something wrong with welcome.fxml!");
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }

    @FXML
    private void confirmLogin() {
        //navigate from login screen to main screen
        System.out.println("Navigation started ...");
        //open a new (main) stage
        MainController.show(new Stage());
        //close the current login stage
        stage.close();
    }
}