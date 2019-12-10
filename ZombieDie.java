public class ZombieDie {
    private int face;
    private int color;

    public ZombieDie(int color){
        if (color == 1){
            rollGreen();
        }
        if (color == 2){
            rollYellow();
        }
        if (color == 3){
            rollRed();
        }
    }
    public int getFace() {
        return face;
    }
    public int getColor(){return color;}
    public void rollGreen(){
        int chance = (int)Math.random()*6+1;
        if(chance == 1||chance==2||chance == 3){
            face = 1; // brain
        }
        else if(chance == 4 || chance == 5){
            face = 2; //foot
        }
        else{
            face = 3; // shot
        }
        color = 1;
    }
    public void rollYellow(){
        int chance = (int)Math.random()*6+1;
        if(chance == 1||chance==2){
            face = 1;
        }
        else if(chance == 3 || chance == 4){
            face = 2;
        }
        else{
            face = 3;
        }
        color = 2;
    }
    public void rollRed(){
        int chance = (int)Math.random()*6+1;
        if(chance == 1){
            face = 1;
        }
        else if(chance == 2 || chance == 3){
            face = 2;
        }
        else{
            face = 3;
        }
        color = 3;
    }
}
