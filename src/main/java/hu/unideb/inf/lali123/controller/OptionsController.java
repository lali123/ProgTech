package hu.unideb.inf.lali123.controller;

import hu.unideb.inf.lali123.model.Options;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Lajos
 *
 */
public class OptionsController implements Initializable{

    @FXML
    Button saveOptionsButton;
    @FXML
    TextField player1Name, player2Name;
    @FXML
    ColorPicker player1Color,player2Color;
    @FXML
    CheckBox computerOpponent, easyOpponent, hardOpponent;
    
    /* (non-Javadoc)
     * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        player1Color.setValue(Color.RED);
        player2Color.setValue(Color.YELLOW);
        player1Name.setText("Player1");
        player2Name.setText("Player2");
        
        computerOpponent.setOnAction(e->{
            if (computerOpponent.isSelected()) {
                easyOpponent.setDisable(false);
                hardOpponent.setDisable(false);
            }else {
                easyOpponent.setDisable(true);
                hardOpponent.setDisable(true);                
            }
        });
        
        easyOpponent.setOnAction(e->{
            if (easyOpponent.isSelected()) {
                Options.getInstance().setEasyGame(true);
                hardOpponent.setSelected(false);                
            }else {
                Options.getInstance().setEasyGame(false);
                hardOpponent.setSelected(true);
            }
        });
        
        hardOpponent.setOnAction(e->{
            if (hardOpponent.isSelected()) {
                Options.getInstance().setEasyGame(false);
                easyOpponent.setSelected(false);
            }else {
                Options.getInstance().setEasyGame(true);
                easyOpponent.setSelected(true);   
            }
            
        });
    }
    
    /**
     * @param event
     * @throws IOException
     */
    @FXML
    private void saveOptions(ActionEvent event) throws IOException {
        Options.getInstance().setPlayer1Name(player1Name.getText());
        Options.getInstance().setPlayer2Name(player2Name.getText());
        Options.getInstance().setPlayer1Color(player1Color.getValue());
        Options.getInstance().setPlayer2Color(player2Color.getValue());
        Options.getInstance().setComputerOpponent(computerOpponent.isSelected());
        Options.getInstance().setEasyGame(easyOpponent.isSelected());
        
        Stage stage;
        Parent root;
        
        root = FXMLLoader.load(getClass().getResource("/hu/unideb/inf/lali123/Menu.fxml"));
        stage = (Stage) saveOptionsButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
