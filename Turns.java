public class Turns {
    private int playerTurn;
    private int numPlayers;

    public Turns(int players){
        numPlayers = players;
        playerTurn = 1;
    }
    public int getPlayerCount(){
        return numPlayers;
    }
    public int getPlayerTurn(){
        return playerTurn;
    }
    public void nextTurn(){
        playerTurn++;
        if (playerTurn > numPlayers){
            playerTurn = 1;
        }
    }
}