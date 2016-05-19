package hu.unideb.inf.lali123.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import hu.unideb.inf.lali123.model.Game;
import hu.unideb.inf.lali123.model.HighScore;
import hu.unideb.inf.lali123.model.HighScoreDAOIml;
import hu.unideb.inf.lali123.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ResultController implements Initializable {
    @FXML
    public Label winnerLabel;
    @FXML
    public Label rowBonusLabel;
    @FXML
    public Label spaceBonusLabel;
    @FXML
    public Label totalScoreLabel;

    Game game;
    Player winner;

    public void initData(Player winner, Game game) {
        this.winner = winner;
        this.game = game;
        winnerLabel.setText(winner.getName());
        rowBonusLabel.setText(game.getRowBonusScore() + "");
        spaceBonusLabel.setText(game.getSpaceBonusScore() + "");
        totalScoreLabel.setText(game.getPlayerScore() + "");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);
        
        HighScore highScore = new HighScore(winner.getName(), game.getPlayerScore()+"", formattedDateTime);
        HighScoreDAOIml higshScoreDAO = new HighScoreDAOIml();
        higshScoreDAO.addHighScore(highScore);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
