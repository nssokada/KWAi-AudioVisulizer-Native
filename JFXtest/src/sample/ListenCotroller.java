package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import processing.core.*;

import java.io.IOException;

public class ListenCotroller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Parent rooter;


    @FXML
    void home(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void userDashboard(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("userdashboard.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    @FXML
    void login(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void creativity(ActionEvent event) throws IOException {
        PApplet.main("creativity");
    }

    @FXML
    void calm(ActionEvent event) throws IOException {
        PApplet.main("Calmer");
    }

    @FXML
    void sleep(ActionEvent event) throws IOException {
        PApplet.main("Sleepy");
    }

    @FXML
    void relax(ActionEvent event) throws IOException {
        PApplet.main("Relaxed");
    }

    @FXML
    void happy(ActionEvent event) throws IOException {
        PApplet.main("Happier");
    }
}
