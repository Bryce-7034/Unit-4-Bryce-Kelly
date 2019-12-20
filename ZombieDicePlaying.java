import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import java.io.File;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.shape.*;

import java.io.IOException;


public class ZombieDicePlaying {
    //all the variables
    private int greenDice = 6;
    private int yellowDice = 4;
    private int redDice = 3;
    private int startGreen = 6;
    private int startYellow = 4;
    private int startRed = 3;
    private int dieTotal;
    private int turnScore;
    private int finalScore1;
    private int finalScore2;
    private ZombieDie die1z = new ZombieDie();
    private ZombieDie die2z = new ZombieDie();
    private ZombieDie die3z = new ZombieDie();
    private int die1Color;
    private int die2Color;
    private int die3Color;
    private int die1Foot;
    private int die2Foot;
    private int die3Foot;
    private int shotNum;
    private Turns turn = new Turns(2);

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
    private Label p2Win;

    @FXML
    private Label p1Win;

    @FXML
    private Rectangle greenThree;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private Label shots;

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
    private Label shotResult;

    @FXML
    private Button pickDie;

    //creates Arrays
    private Rectangle[] GreenArray = new Rectangle[6];//{greenOne, greenTwo, greenThree, greenFour, greenFive, greenSix}
    private Rectangle[] YellowArray = new Rectangle[4];//{yellowOne, yellowTwo, yellowThree, yellowFour};
    private Rectangle[] RedArray = new Rectangle[3];//{redOne, redTwo, redThree};
    private Rectangle[] DiceArray = new Rectangle[3];
    private ImageView[] DieImage = new ImageView[3];
    private ZombieDie[] diez = new ZombieDie[3];
    private int[] DieColor = new int[3];
    private int[] FootColor = new int[3];


    @FXML
    void pickDice(ActionEvent event){
        //sets the green array
        GreenArray[0] = greenOne;
        GreenArray[1] = greenTwo;
        GreenArray[2] = greenThree;
        GreenArray[3] = greenFour;
        GreenArray[4] = greenFive;
        GreenArray[5] = greenSix;

        //sets yellow array
        YellowArray[0] = yellowOne;
        YellowArray[1] = yellowTwo;
        YellowArray[2] = yellowThree;
        YellowArray[3] = yellowFour;

        //sets red array
        RedArray[0] = redOne;
        RedArray[1] = redTwo;
        RedArray[2] = redThree;

        //sets Dice Array
        DiceArray[0] = die1;
        DiceArray[1] = die2;
        DiceArray[2] = die3;

        //sets Image Array
        DieImage[0] = image1;
        DieImage[1] = image2;
        DieImage[2] = image3;

        //sets zombie dice Array
        diez[0] = die1z;
        diez[1] = die2z;
        diez[2] = die3z;

        //sets the Dice Color Array
        DieColor[0] = die1Color;
        DieColor[1] = die2Color;
        DieColor[2] = die3Color;


        //gets the image file
        File file = new File("./Unknown.png");
        Image unknown = new Image(file.toURI().toString());


        //reset the die total for each run
        dieTotal = greenDice+yellowDice+redDice;

        for(int i = 0; i < 3; i++) {
            //create a random number based on total
            int dieColor = (int) (Math.random() * dieTotal + 1);

            //checks the number and will change the die to the according color based on amount of die left
            if (diez[i].isFoot()) {
                diez[i].roll();
                DieColor[i] = FootColor[i];
            } else if (dieColor <= greenDice) {
                greenDice--;
                DiceArray[i].setFill(greenOne.getFill());
                DieColor[i] = 1;
            } else if (dieColor >= greenDice && dieColor <= (greenDice + yellowDice)) {
                yellowDice--;
                DiceArray[i].setFill(yellowOne.getFill());
                DieColor[i] = 2;
            } else if (dieColor >= greenDice + yellowDice && dieColor <= dieTotal) {
                redDice--;
                DiceArray[i].setFill(redOne.getFill());
                DieColor[i] = 3;
            }
            else if (dieTotal <= 0) {
                DiceArray[i].setFill(Color.BLACK);
                DieColor[i] = 4;
            }
            if(!diez[i].isBlack()) {
                DieImage[i].setImage(unknown);
            }
            else if (DieColor[i]==4){
                DieImage[i].setVisible(false);
            }
            //drop the die total because a  die was used
            dieTotal--;
        }

        /*
        All For Tests
        finalResultP1.setText(""+RectangleArray);
        finalResultP2.setText(""+dieColor2);
        turnResult.setText(""+dieColor3);
        shotResultP1.setText(""+dieTotal);
        */

        //sets differences
        int greenDif = startGreen - greenDice;
        int redDif = startRed - redDice;
        int yellowDif = startYellow - yellowDice;
        int a=startGreen-1;

        //hides the used die
        for(int i = 0; i< greenDif; i++){
            GreenArray[a].setFill(Color.TRANSPARENT);
            a--;
        }
        a=startYellow-1;
        for(int i = 0; i< yellowDif; i++){
            YellowArray[a].setFill(Color.TRANSPARENT);
            a--;
        }
        a=startRed-1;
        for(int i = 0; i< redDif; i++){
            RedArray[a].setFill(Color.TRANSPARENT);
            a--;
        }

        //change the buttons to be visible or not as to make the game more clear
        rollDie.setVisible(true);
        pickDie.setVisible(false);
        endTurn.setVisible(false);
    }

    @FXML
    void rollDice(ActionEvent event){

        die1z = new ZombieDie(DieColor[0]);
        die2z = new ZombieDie(DieColor[1]);
        die3z = new ZombieDie(DieColor[2]);

        //sets die array
        diez[0] = die1z;
        diez[1] = die2z;
        diez[2] = die3z;

        FootColor[0] = die1Foot;
        FootColor[1] = die2Foot;
        FootColor[2] = die3Foot;


        //sets image array
        DieImage[0] = image1;
        DieImage[1] = image2;
        DieImage[2] = image3;
        //sets all the images and changes score based on roll
        for (int i = 0; i<3; i++){
            if(!diez[i].isBlack()&&diez[i].isBrain()){
                turnScore++;
                File file = new File("./Brain.png");
                Image brain = new Image(file.toURI().toString());
                DieImage[i].setImage(brain);
            }
            else if(!diez[i].isBlack()&&diez[i].isShot()){
                shotNum++;
                File file = new File("./Shot.png");
                Image shot = new Image(file.toURI().toString());
                DieImage[i].setImage(shot);
            }
            else if(!diez[i].isBlack()&&diez[i].isFoot()){
                File file = new File("./Footprint.png");
                Image foot = new Image(file.toURI().toString());
                DieImage[i].setImage(foot);
                FootColor[i] = diez[i].getColor();
            }
            else if(diez[i].isBlack()){
                DiceArray[i].setFill(Color.BLACK);
            }
            else{
                DiceArray[i].setFill(Color.PURPLE);
            }
        }
        turnResult.setText(""+turnScore);
        shotResult.setText(""+shotNum);

        //change the button visibility to allow ending a turn
        rollDie.setVisible(false);
        pickDie.setVisible(true);
        endTurn.setVisible(true);

        //if you get three shots, forces you to end Turn and sets point to zero
        if (shotNum >= 3){
            turnScore = 0;
            turnResult.setText(""+turnScore);
            pickDie.setVisible(false);
        }
    }

    @FXML
    void endPlayerTurn(ActionEvent event) {
        //Set the die Totals
        greenDice = 6;
        yellowDice = 4;
        redDice = 3;

        //reset the die Face
        die1z = new ZombieDie();
        die2z = new ZombieDie();
        die3z = new ZombieDie();
        //gives points based on turn number
        if (turn.getPlayerTurn() == 1){
            finalScore1 += turnScore;
            turnScore = 0;
            shotNum = 0;
            finalResultP1.setText(""+finalScore1);
        }
        if (turn.getPlayerTurn() == 2){
            finalScore2 += turnScore;
            turnScore = 0;
            shotNum = 0;
            finalResultP2.setText(""+finalScore2);
        }
        //reset score board
        turnResult.setText(""+turnScore);
        shotResult.setText(""+shotNum);

        //sets visibility
        rollDie.setVisible(false);
        pickDie.setVisible(true);
        endTurn.setVisible(true);
        //resets for next turn
        greenOne.setFill(Color.rgb(41,147,30));
        greenTwo.setFill(greenOne.getFill());
        greenThree.setFill(greenOne.getFill());
        greenFour.setFill(greenOne.getFill());
        greenFive.setFill(greenOne.getFill());
        greenSix.setFill(greenOne.getFill());

        yellowOne.setFill(Color.rgb(228,228,7));
        yellowTwo.setFill(yellowOne.getFill());
        yellowThree.setFill(yellowOne.getFill());
        yellowFour.setFill(yellowOne.getFill());

        redOne.setFill(Color.rgb(255,30,30));
        redTwo.setFill(redOne.getFill());
        redThree.setFill(redOne.getFill());

        die1.setFill(Color.DODGERBLUE);
        die2.setFill(Color.DODGERBLUE);
        die3.setFill(Color.DODGERBLUE);

        File file = new File("./Unknown.png");
        Image unknown = new Image(file.toURI().toString());
        image1.setImage(unknown);
        image2.setImage(unknown);
        image3.setImage(unknown);

        image1.setVisible(true);
        image2.setVisible(true);
        image3.setVisible(true);

        //changes turn
        turn.nextTurn();
        if(finalScore1 == 20 && shotNum<3){
            p1Win.setVisible(true);
            rollDie.setVisible(false);
            pickDie.setVisible(false);
            endTurn.setVisible(false);

        }
        if(finalScore2 >= 20 && shotNum<3){
            p2Win.setVisible(true);
            rollDie.setVisible(false);
            pickDie.setVisible(false);
            endTurn.setVisible(false);

        }
    }

    @FXML
    void backHome(ActionEvent event) throws IOException{
        //loads the FXML file for the home screen
        Parent single = FXMLLoader.load(getClass().getResource("./ZombieDieStartScreen.fxml"));
        homeButton.getScene().setRoot(single);
    }

}

