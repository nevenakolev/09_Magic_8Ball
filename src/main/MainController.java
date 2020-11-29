package main;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {
    //attributes
    @FXML private Rectangle rect_border = new Rectangle();
    @FXML private Rectangle rect_answerBubbleBorder = new Rectangle();
    @FXML private Line line_answerBubble = new Line();
    @FXML private Label lbl_logo = new Label();
    @FXML private Label lbl_answer = new Label();
    @FXML private Label lbl_askMeSomething = new Label();
    @FXML private TextArea txta_questionInput = new TextArea();
    @FXML private Button btn_done = new Button();
    MainModel mainModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainModel = new MainModel();
    }

    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("main.fxml"));
            Parent root = fxmlLoader.load();

            //create the main stage
            stage.setTitle("Magic 8 Ball");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Something wrong with main.fxml!");
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }

    @FXML
    public void ask() {
        String question = txta_questionInput.getText();
        String answer = mainModel.getRandomAnswer(question);
        lbl_answer.setText(answer);
        System.out.println("Test");
    }
}