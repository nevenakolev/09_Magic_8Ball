package signUp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.LoginModel;
import login.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpController implements Initializable {
    //attributes
    private Stage stage;
    //.fxml elements
    @FXML private Label lbl_title = new Label();
    @FXML private Label lbl_userName = new Label();
    @FXML private Label lbl_password = new Label();
    @FXML private TextField txtf_newUsernameInput = new TextField();
    @FXML private PasswordField pswf_password = new PasswordField();
    @FXML private Button btn_done = new Button();

    //getter and setter
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    public static void showStage(Stage stage) {
        try {
            //loads the .fxml file that is associated to this controller
            FXMLLoader fxmlLoader = new FXMLLoader(SignUpController.class.getResource("signUp.fxml"));
            //gets the anchorPane from the .fxml which will be displayed in a stage
            Parent root = fxmlLoader.load();

            //get the controller that is connected to this fxml file and sets its stage
            SignUpController ctrl = fxmlLoader.getController();
            //sets this stage to the controller LoginController
            ctrl.setStage(stage);

            //sets stage settings
            stage.setTitle("Sign up");
            //sets a new scene with the content of parent 'root'
            stage.setScene(new Scene(root));
            //displays this stage
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Something wrong with signUp.fxml!");
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }

    @FXML
    private void confirmSignUp() {
        //gets entered data
        String userName = txtf_newUsernameInput.getText();
        String password = pswf_password.getText();

        //adds user to the database with this data
        LoginModel.signUp(new User(userName, password));

        //closes the signUp stage
        this.stage.close();
    }
}
