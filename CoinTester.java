/*
Creates instances of the coin class and tests their attributes and behaviors
*/
public class CoinTester{
  public static void main(String[]args){
    Coin myCoin = new Coin();
    Coin yourCoin = new Coin();
    Coin aCoin;
    double heads = 0;
    double tails = 0;

    System.out.println("My Coin = " + myCoin.toString());
    System.out.println("Your Coin = " + yourCoin.toString());

    for (int i = 1; i <= 10; i++){
      aCoin = new Coin();
      System.out.println("Coin "+i+")   "+aCoin);
      if (aCoin.isHead()){
        heads++;
      }else{
        tails++;
      }
    }
    double percentage = (heads/(heads+tails)) * 100;
    System.out.print("In those flips, "+ percentage+"% were heads\n");
    System.out.print(heads+"-heads:"+tails+"-tails");
  }
}
