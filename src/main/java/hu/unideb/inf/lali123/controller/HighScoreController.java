package hu.unideb.inf.lali123.controller;

import hu.unideb.inf.lali123.model.HighScore;
import hu.unideb.inf.lali123.model.HighScoreDAO;
import hu.unideb.inf.lali123.model.HighScoreDAOIml;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HighScoreController implements Initializable{
    
    @FXML
    Button backButton;
    @FXML
    TableView<HighScore> highScoreTable;
    //@FXML
    //ListView<String> highScoreList;
    
    /**
     * @param event
     * @throws IOException
     */
    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        
        root = FXMLLoader.load(getClass().getResource("/hu/unideb/inf/lali123/Menu.fxml"));
        stage = (Stage) backButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn name = new TableColumn("Name");
        name.setMinWidth(100);
        name.setCellValueFactory(
                new PropertyValueFactory<>("name"));
 
        TableColumn score = new TableColumn("Score");
        score.setMinWidth(50);
        score.setCellValueFactory(
                new PropertyValueFactory<>("score"));
 
        TableColumn date = new TableColumn("Date");
        date.setMinWidth(100);
        date.setCellValueFactory(
                new PropertyValueFactory<>("date"));
        
        
        highScoreTable.getColumns().addAll(name, score, date);
        
        HighScoreDAO hsImpl = new HighScoreDAOIml();
        ArrayList<HighScore> highScoreArrayList = hsImpl.getAllHighScores().getHighScore();
        ObservableList<HighScore> lista = FXCollections.observableArrayList();
        for (HighScore highScore : highScoreArrayList) {
            lista.add(highScore);
        }       
        highScoreTable.setItems(lista);
        //highScoreList.setItems(lista);            
    }
}
