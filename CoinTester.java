/*
Creates instances of the coin class and tests their attributes and behaviors
*/
public class CoinTester{
  public static void main(String[]args){
    Coin myCoin = new Coin();
    Coin yourCoin = new Coin();
    Coin aCoin;

    System.out.println("My Coin = " + myCoin.toString());
    System.out.println("Your Coin = " + yourCoin.toString());

    for (int i = 1; i <= 10; i++){
      aCoin = new Coin();
      System.out.println("Coin "+i+")   "+aCoin);
    }
  }
}
