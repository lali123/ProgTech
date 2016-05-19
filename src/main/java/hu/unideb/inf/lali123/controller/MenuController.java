package hu.unideb.inf.lali123.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Lajos
 *
 */
public class MenuController {
    @FXML
    Button startButton;
    @FXML
    Button optionsButton;
    @FXML
    Button exitButton;

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    private void exitGame(ActionEvent event) throws IOException {
        Platform.exit();
    }

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    private void openGameBoard(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        root = FXMLLoader.load(getClass().getResource(
                "/hu/unideb/inf/lali123/Board.fxml"));
        stage = (Stage) startButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    private void openOptions(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        root = FXMLLoader.load(getClass().getResource(
                "/hu/unideb/inf/lali123/Options.fxml"));
        stage = (Stage) optionsButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    /**
     * @param event
     * @throws IOException
     */
    @FXML
    private void openHighScore(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        root = FXMLLoader.load(getClass().getResource(
                "/hu/unideb/inf/lali123/HighScore.fxml"));
        stage = (Stage) optionsButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
