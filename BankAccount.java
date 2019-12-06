import java.text.DecimalFormat;
public class BankAccount{
  private double moneyIn;
  private double moneyOut;
  private double dept;
  private String accountUsername;
  private String accountPassword;

  private final double INTREST = 1.013;

  DecimalFormat fmt = new DecimalFormat("0.00");
  /*
  creates a new account
  */
  public BankAccount(String newUsername, String newPassword, double startingMoney){
    accountUsername = newUsername;
    accountPassword = newPassword;
    moneyIn = ((int)(startingMoney*100))/100.0;;
  }


  public void setmoneyOut(double setMoney){
    moneyOut = setMoney;
  }
  public double getmoneyOut(){
    return ((int)(moneyOut*100))/100.0;
  }
  public double getmoneyIn(){
    return ((int)(moneyIn*100))/100.0;
  }
  public String getUsername(){
    return accountUsername;
  }

  public void resetPassword(String newPassword){
    accountPassword = newPassword;
  }
  public void deposit(double addedAmt){
    if (dept > 0){
      if (addedAmt >= dept){
        System.out.println("You Payed Off Your Dept");
        dept = 0;
        addedAmt = addedAmt - dept;
      }
    }
    if (addedAmt <= moneyOut && addedAmt>0){
      moneyIn = moneyIn + addedAmt;
      moneyOut = moneyOut - addedAmt;
    } else if(addedAmt> moneyOut){
      System.out.println("You don't have enough money");
      moneyIn = moneyIn + moneyOut;
      moneyOut = 0;
    } else{
      System.out.println("cannot deposit $0");
    }
  }
  public void withdraw(double withdrawnAmt){
    if (withdrawnAmt <= moneyIn && withdrawnAmt>0){
      moneyIn = moneyIn - withdrawnAmt;
      moneyOut = moneyOut + withdrawnAmt;
    }else if(withdrawnAmt>moneyIn){
      System.out.println("You don't have the money");
      moneyOut = moneyOut + moneyIn;
      moneyIn = 0;
    }else{
      System.out.println("cannot withdraw $0");
    }
  }
  public void pay(double paymentAmount){
    if (moneyOut < paymentAmount){dept = -(moneyOut - paymentAmount);}
    else {moneyOut = (moneyOut - paymentAmount);}
  }
  public void intrest(){
    moneyIn = moneyIn * INTREST;
    dept = dept * INTREST;
  }
  public void hacked(){
    moneyIn = 0;
  }
  public String toString(){
    String result = "";
    result += "Money Withdrawn: "+ fmt.format(moneyOut)+"\n";
    result += "Money Deposited: "+ fmt.format(moneyIn)+"\n";
    result += "Username: "+ accountUsername+"\n";
    return result;
  }
}
