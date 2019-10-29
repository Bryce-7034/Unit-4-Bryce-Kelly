/*
  Welcome to the coin class
  this is the plan for making a coin object
*/
public class Coin{
  //Thesse are the declarations for the coin attributes(instance variables)
  private int face;

  private final int HEADS = 0; //constants defining heads and tails
  private final int TAILS = 1;

  /*
  The coin constructor that defins what happens when a coin is made
  When a new coin is made it gets flipped
  */
  public Coin(){
    flip();
  }

  /*
  This is the section of the class that contains methods(behavior) of a coin

  The flip method assigns a randomly chosen value to the face of the coin
  */
  public void flip(){
    face = (int) (Math.random() * 2);
  }

  /*
  The isHead method tells us if the face of the coin is heads
  */
  public boolean isHead(){
    return (face == HEADS);
  }

  /*
  prints info about the state of the coin
  */
  public String toString(){
    String faceName;
    if(face == HEADS){
      faceName = "Heads";
    }
    else{
      faceName = "Tails";
    }
    return faceName;
  }
}
