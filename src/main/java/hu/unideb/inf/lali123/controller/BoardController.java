package hu.unideb.inf.lali123.controller;

import hu.unideb.inf.lali123.model.AI;
import hu.unideb.inf.lali123.model.Board;
import hu.unideb.inf.lali123.model.Disc;
import hu.unideb.inf.lali123.model.Game;
import hu.unideb.inf.lali123.model.Options;
import hu.unideb.inf.lali123.model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Lajos
 *
 */
public class BoardController implements Initializable {
    @FXML
    GridPane gridPane;
    @FXML
    BorderPane root;
    @FXML
    Label p1NameLabel, p2NameLabel, p1Score, p2Score;
    @FXML
    Button backButton;

    private SimpleObjectProperty<Color> playerColorProperty;
    private Game ConnectFourGame;
    private Player player1, player2;
    private AI ConnectFourAI;

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        root = FXMLLoader.load(getClass().getResource(
                "/hu/unideb/inf/lali123/Menu.fxml"));
        stage = (Stage) backButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    // throw a disk to table programmatically
    /**
     * @param column
     * @param row
     */
    private void buttonPressing(int column, int row) {
        Disc disk = null;
        // Search for the chosen disk
        for (Node gridNode : gridPane.getChildren()) {
            if (gridNode instanceof StackPane) {
                for (Node node : ((StackPane) gridNode).getChildren()) {
                    if (node instanceof Disc) {
                        if (((Disc) node).getcolumn() == column
                                && ((Disc) node).getRow() == row) {
                            disk = (Disc) node;
                        }
                    }
                }
            }
        }
        try {
            // fire the mouse click event
            Event.fireEvent(disk, new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
                    0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
                    true, true, true, true, true, true, null));
        } catch (Exception ex) {
        }
        ;
    }

    // Create the GAME table
    /**
     * @param gridPane
     */
    private void createGrids(GridPane gridPane) {
        gridPane.getChildren().clear();

        for (int row = 0; row < gridPane.getRowConstraints().size(); row++) {
            for (int column = 0; column < gridPane.getColumnConstraints()
                    .size(); column++) {

                Rectangle rect = new Rectangle(80, 80);
                Disc circ = new Disc(38, column, row);
                circ.centerXProperty().set(40);
                circ.centerYProperty().set(40);
                Shape cell = Path.subtract(rect, circ);
                cell.setFill(Color.BLUE);
                cell.setStroke(Color.BLUE);
                cell.setOpacity(.8);

                Disc disk = new Disc(40, column, row);
                disk.fillProperty().bind(playerColorProperty);
                disk.setTranslateY(-(80 * (row + 1)));

                final TranslateTransition translateTranstion = new TranslateTransition(
                        Duration.millis(300), disk);

                disk.setOnMouseClicked((event) -> {
                    discOnMouseClicked(translateTranstion, disk);
                });

                StackPane stack = new StackPane();
                stack.getChildren().addAll(cell, disk);
                gridPane.add(stack, column, row);
            }
        }

    }

    // display on disc throwing on GUI
    /**
     * @param translateTranstion
     * @param disk
     */
    private void discOnMouseClicked(TranslateTransition translateTranstion,
            Disc disk) {
        if (disk.getTranslateY() != 0) {
            translateTranstion.setToY(0);
            translateTranstion.play();
            if (playerColorProperty.get() == Options.getInstance().getPlayer1Color()) {
                playerColorProperty.set(Options.getInstance().getPlayer2Color());
                disk.fillProperty().bind(new SimpleObjectProperty<Color>(Options.getInstance()
                                                                                .getPlayer1Color()));
                ConnectFourGame.getTable().takeDisk(disk.getcolumn(), 1);

                if (Options.getInstance().isComputerOpponent()) {
                    Board b = ConnectFourGame.getTable();
                    int col = ConnectFourAI.getAIMove(b, 2);
                    int row = ConnectFourGame.getTable().getThrownRow(col);
                    ConnectFourGame.getTable().printTable();
                    
                    int winner = ConnectFourGame.getTable().checkWinner();
                    if (winner == 1) {
                        evaluateResult(winner);                        
                    }else {
                        buttonPressing(col, row);  
                        evaluateResult(winner);                       
                    }
                }

            } else {
                playerColorProperty.set(Options.getInstance().getPlayer1Color());
                disk.fillProperty()
                    .bind(new SimpleObjectProperty<Color>(Options.getInstance()
                                                                 .getPlayer2Color()));
                ConnectFourGame.getTable().takeDisk(disk.getcolumn(), 2);
            }
            
            
            if (!Options.getInstance().isComputerOpponent()) {
                evaluateResult(ConnectFourGame.getTable().checkWinner());
            }

        }
    }

    // Check who is the winner.
    /**
     * @param checkWinner
     */
    private void evaluateResult(int checkWinner) {
        switch (checkWinner) {
        case 1:
            showResult(ConnectFourGame.getPlayer1());
            break;
        case 2:
            showResult(ConnectFourGame.getPlayer2());
            break;
        case 3:
            showResult(new Player("Drawn Game", Color.WHITE, false, 0));
            break;
        default:
            break;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see javafx.fxml.Initializable#initialize(java.net.URL,
     * java.util.ResourceBundle)
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p1NameLabel.setText(Options.getInstance().Player1Name().get());
        p2NameLabel.setText(Options.getInstance().Player2Name().get());

        player1 = new Player(Options.getInstance().getPlayer1Name(), Options
                .getInstance().getPlayer1Color(), true, 0);

        player2 = new Player(Options.getInstance().getPlayer2Name(), Options
                .getInstance().getPlayer2Color(), true, 0);

        ConnectFourGame = new Game(player1, player2, new Board(6, 7));
        ConnectFourAI = new AI();

        playerColorProperty = new SimpleObjectProperty<Color>(
                player1.getColor());

        gridPane.setTranslateY(20);
        gridPane.setAlignment(Pos.CENTER);

        // Add row constraints to grid
        for (int row = 0; row < ConnectFourGame.getTable().getROW(); row++) {
            gridPane.getRowConstraints().add(
                    new RowConstraints(80, 80, Double.MAX_VALUE));
        }

        // Add column constrains to grid
        for (int column = 0; column < ConnectFourGame.getTable().getCOLUMN(); column++) {
            gridPane.getColumnConstraints().addAll(
                    new ColumnConstraints(80, 80, Double.MAX_VALUE));
        }

        createGrids(gridPane);

    }

    /**
     * @param winner
     */
    private void setPlayerScores(Player winner) {
        if (winner.equals(ConnectFourGame.getPlayer1())) {
            ConnectFourGame.getPlayer1().addScore();
            p1Score.setText(ConnectFourGame.getPlayer1().getScore() + "");
        } else {
            ConnectFourGame.getPlayer2().addScore();
            p2Score.setText(ConnectFourGame.getPlayer2().getScore() + "");
        }

        ConnectFourGame.getTable().emptyTable();
        createGrids(gridPane);
    }

    /**
     * @param winner
     */
    public void showResult(Player winner) {
        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/hu/unideb/inf/lali123/GameResult.fxml"));

            Parent root = loader.load();
            loader.<ResultController> getController().initData(winner,
                    ConnectFourGame);

            Scene scene = new Scene(root);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest((event) -> {
                setPlayerScores(winner);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
