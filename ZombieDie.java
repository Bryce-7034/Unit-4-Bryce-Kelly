public class ZombieDie {
    private int face;
    private int color;

    public ZombieDie(){
        face = 0;
    }
    public ZombieDie(int inColor){
        color = inColor;
        if (color == 1){
            rollGreen();
        }
        if (color == 2){
            rollYellow();
        }
        if (color == 3){
            rollRed();
        }
        if (color == 4){
            isBlack();
        }
    }
    public int getFace() {
        return face;
    }
    public int getColor(){return color;}
    public boolean isBrain(){return face == 1;}
    public boolean isFoot(){return face == 2;}
    public boolean isShot(){return face == 3;}
    public boolean isBlack(){return color == 4;}
    public void rollGreen(){
        int chance = (int)(Math.random()*6+1);
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
        int chance = (int)(Math.random()*6+1);
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
        int chance = (int)(Math.random()*6+1);
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
    public void roll(){
        if(color==1){
            int chance = (int)(Math.random()*6+1);
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
        if(color==2){
            int chance = (int)(Math.random()*6+1);
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
        if(color==3){
            int chance = (int)(Math.random()*6+1);
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
}
