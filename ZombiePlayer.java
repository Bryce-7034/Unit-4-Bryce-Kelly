public class ZombiePlayer {
    private int roundScore;
    private int totalScore;
    public ZombiePlayer(){
        roundScore = 0;
        totalScore = 0;
    }

    public void addRound(int score){
        roundScore += score;
    }
    public void addTotal(){
        totalScore += roundScore;
        roundScore = 0;
    }
    public void rollPlayer(){}
}
