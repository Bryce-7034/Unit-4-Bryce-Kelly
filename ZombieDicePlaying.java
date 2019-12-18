import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.shape.*;

import java.io.IOException;


public class ZombieDicePlaying {
    private int greenDice = 6;
    private int yellowDice = 4;
    private int redDice = 3;
    private int dieTotal;
    private int dieNum1;
    private int dieNum2;
    private int dieNum3;
    private int turnScore;
    private int finalScore1;
    private int finalScore2;
    private int result;
    Turns turn = new Turns(2);

    @FXML
    private Label finalResultP2;

    @FXML
    private Label finalResultP1;

    @FXML
    private Button endTurn;

    @FXML
    private Button rollDie;

    @FXML
    private Label turnResult;

    @FXML
    private Button homeButton;

    @FXML
    private Rectangle redOne;

    @FXML
    private Rectangle yellowFour;

    @FXML
    private Rectangle yellowTwo;

    @FXML
    private Rectangle greenOne;

    @FXML
    private Label secondPlayer;

    @FXML
    private Rectangle die3;

    @FXML
    private Rectangle redThree;

    @FXML
    private Rectangle die2;

    @FXML
    private Rectangle die1;

    @FXML
    private ImageView image3;

    @FXML
    private Rectangle greenFour;

    @FXML
    private Rectangle greenSix;

    @FXML
    private Label firstPlayer;

    @FXML
    private Label finalScoreP2;

    @FXML
    private Label finalScoreP1;

    @FXML
    private Rectangle greenThree;

    @FXML
    private ImageView image1;

    @FXML
    private Label shotsP2;

    @FXML
    private ImageView image2;

    @FXML
    private Label shotsP1;

    @FXML
    private Rectangle yellowThree;

    @FXML
    private Rectangle greenTwo;

    @FXML
    private Rectangle greenFive;

    @FXML
    private Rectangle yellowOne;

    @FXML
    private Rectangle redTwo;

    @FXML
    private Label shotResultP1;

    @FXML
    private Label shotResultP2;

    @FXML
    private Button pickDie;

    @FXML
    void pickDice(ActionEvent event){
        dieTotal = greenDice+yellowDice+redDice;
        int dieColor1 = (int)(Math.random()*dieTotal+1);
        if(dieColor1 <= greenDice){greenDice--;die1.setFill(greenOne.getFill());}
        else if(dieColor1 >= greenDice && dieColor1 <= (greenDice + yellowDice)){yellowDice--;die1.setFill(yellowOne.getFill());}
        else if(dieColor1 >= greenDice + yellowDice&&dieColor1<=dieTotal){redDice--;die1.setFill(redOne.getFill());}
        else if(dieTotal<=0){die1.setFill(Color.BLACK);}
        dieTotal--;
        int dieColor2 = (int)(Math.random()*dieTotal+1);
        if(dieColor2 <= greenDice){greenDice--;die2.setFill(greenOne.getFill());}
        else if(dieColor2 >= greenDice && dieColor2 <= (greenDice + yellowDice)){yellowDice--;die2.setFill(yellowOne.getFill());}
        else if(dieColor2 >= greenDice + yellowDice&&dieColor2<=dieTotal){redDice--;die2.setFill(redOne.getFill());}
        if(dieTotal<=0){die2.setFill(Color.BLACK);}
        dieTotal--;
        int dieColor3 = (int)(Math.random()*dieTotal+1);
        if(dieColor3 <= greenDice){greenDice--;die3.setFill(greenOne.getFill());}
        else if(dieColor3 >= greenDice && dieColor3 <= (greenDice + yellowDice)){yellowDice--;die3.setFill(yellowOne.getFill());}
        else if(dieColor3 >= greenDice + yellowDice&&dieColor3<=dieTotal){redDice--;die3.setFill(redOne.getFill());}
        if(dieTotal<=0){die3.setFill(Color.BLACK);}
        dieTotal--;
        if(redDice<0){redDice=0;}
        if(yellowDice<0){yellowDice=0;}
        if(greenDice<0){greenDice=0;}
        finalResultP1.setText(""+dieColor1);
        finalResultP2.setText(""+dieColor2);
        turnResult.setText(""+dieColor3);
        shotResultP1.setText(""+dieTotal);
        rollDie.setVisible(true);
        pickDie.setVisible(false);
        endTurn.setVisible(false);
    }

    @FXML
    void rollDice(ActionEvent event){
        rollDie.setVisible(false);
        pickDie.setVisible(true);
        endTurn.setVisible(true);
    }

    @FXML
    void endPlayerTurn(ActionEvent event) {
        greenDice = 6;
        yellowDice = 4;
        redDice = 3;
        if (turn.getPlayerTurn() == 1){
            finalScore1 += turnScore;
            finalResultP1.setText(""+finalScore1);
        }
        if (turn.getPlayerTurn() == 2){
            finalScore2 += turnScore;
            finalResultP2.setText(""+finalScore2);
        }
        turn.nextTurn();
    }

    @FXML
    void backHome(ActionEvent event) {
        //loads the FXML file for the home screen
    }

}

