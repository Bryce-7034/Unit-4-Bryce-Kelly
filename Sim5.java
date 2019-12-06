import java.util.Scanner;

public class Sim5{
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    Car Car = new Car();
    BankAccount account = new BankAccount("","",0);
    boolean play = true;
    boolean drive = true;
    double miles;
    String make;
    String model;
    String username = "mnbvfghjk12345678jhyujhgfrtyuiki876tgni876yujki87ytr43edfcvcdswertyutcgtruchdyrefdfgguritfytidurs7aexucgvpgutju765rfghjijhg";
    String password = "yyhjmnbvcxdertyuytredcvbnbvbnmjuy12345678trertyuijmnjkioplkjkigyfvuytrdsgmdaijijqwsxcvfrertyuikjhjmnbju6546789oijhy65rfdser";
    double fuelCap = 0.0;
    double mpg;
    int crash = 0;
    int haveCar = 0;
    double gasx = (int)(Math.random()*100-50);
    double gasy = (int)(Math.random()*100-50);
    int bankAccount = 0;
    double startMoney;
    while (play){
      //System.out.println(Car.getx()+", "+Car.gety());
      //System.out.println(gasx+", "+gasy);
      System.out.print("What would you like to do\n"
      +"please type out one of the numbers of the actions:\n"
      +"Get Car -- 1\n"
      +"Open Bank Account -- 2\n"
      +"Drive -- 3\n"
      +"Get Gas -- 4\n"
      +"Repair -- 5\n"
      +"Manage Bank -- 6\n"
      +"Gamble -- 7\n"
      +"End -- 10\n");
      int action = 0;
      if (scan.hasNextInt()){action = scan.nextInt();}
      scan.nextLine();
      if(action == 1 && haveCar == 1){System.out.println("You already have a car");scan.nextLine();}
      if(action == 3 && haveCar == 0){System.out.println("you can't drive, you have no car");scan.nextLine();}
      if(action == 4 && haveCar == 0){System.out.println("you can't get gas, you have no car");scan.nextLine();}
      if(action == 5 && haveCar == 0){System.out.println("you can't repair what you dont have");scan.nextLine();}
      if(action == 2 && bankAccount == 1){System.out.println("You already have an account");scan.nextLine();}
      while (action == 1 && (Car.getModel().equals("---") || crash == 1)){
        haveCar = 0;
        System.out.println("What make do you want");
        make = scan2.nextLine();
        System.out.println("What model do you want");
        model = scan2.nextLine();
        fuelCap = (int)(Math.random()*25+10);
        mpg = ((int)((Math.random()*20.5+5.5)*100))/100.0;
        Car = new Car(make, model, mpg, fuelCap);
        System.out.println(Car.toString());
        scan.nextLine();
        haveCar++;
        action = 0;
      }
      while (action == 2 && bankAccount != 1){
        bankAccount++;
        System.out.println("What is your Username");
        username = scan.nextLine();
        System.out.println("What is your password");
        password = scan.nextLine();
        System.out.println("What is your starting money");
        startMoney = scan.nextDouble();
        account = new BankAccount(username, password, startMoney);
        action = 0;
      }
      while (action == 3 && haveCar == 1){
        while (drive){
          System.out.print("please state which way you want to drive\n"
          +"Gas station is");
          if (Car.getx() < (gasx)){System.out.print(" right "+Math.abs(Car.getx()-(gasx))+" miles, ");}
          else if (Car.getx() > (gasx)){System.out.print(" left "+Math.abs(Car.getx()-(gasx))+" miles, ");}
          else if (Car.getx() == (gasx)){System.out.print(" not left or right, ");}
          if (Car.gety() >(gasy)){System.out.print("down "+Math.abs(Car.gety()-(gasy))+" miles");}
          else if (Car.gety() < (gasy)){System.out.print("up "+Math.abs(Car.gety()-(gasy))+" miles");}
          else if (Car.gety() == (gasy)){System.out.print("and not up or down, ");}
          System.out.print("\nRight -- 1\n"
          +"Left -- 2\n"
          +"Up -- 3\n"
          +"Down -- 4\n"
          +"Stop Driving -- 5\n");
          int direction = 0;
          if(scan2.hasNextInt()){direction = scan2.nextInt();}
          scan2.nextLine();
          if (direction == 5){drive = false; break;}
          System.out.println("How many miles do you want to drive");
          miles = scan2.nextDouble();
          scan2.nextLine();
          if (direction == 1){Car.driveRight(miles);scan.nextLine();account.intrest();}
          if (direction == 2){Car.driveLeft(miles);scan.nextLine();account.intrest();}
          if (direction == 3){Car.driveUp(miles);scan.nextLine();account.intrest();}
          if (direction == 4){Car.driveDown(miles);scan.nextLine();account.intrest();}
          crash = (int)(Math.random()*77+1);
          if (crash == 1 && (direction == 1 || direction == 2 || direction == 3 || direction == 4)){Car.crash();account.intrest();}
        }
        action = 0;
      }
      while (action == 4 && haveCar == 1){
        if ((Car.getx() == (gasx+1) || Car.getx() == (gasx-1) || Car.getx() == gasx) && (Car.gety() == (gasy+1) || Car.gety() == (gasy-1) || Car.gety() == gasy)){
          System.out.println("Current fuel: "+Car.getFuel());
          System.out.println("Max fuel: "+ fuelCap);
          System.out.println("How much gas do you want");
          double fuelAdd = scan2.nextDouble();
          scan2.nextLine();
          Car.addFuel(fuelAdd);
          System.out.println("Fuel: "+ Car.getFuel());
        }
        else{System.out.println("You aren't at the station");scan.nextLine();}
        action = 0;
      }
      while (action == 5 && haveCar == 1){
        Car.repair();
        crash = 0;
        action = 0;
      }
      while (action == 6 && bankAccount == 1){
        boolean banker = true;
        System.out.print("What is the username\n");
        String inputUsername = scan.nextLine();
        System.out.print("What is the password\n");
        String inputPassword = scan.nextLine();
        while(inputPassword.equals(password) && inputUsername.equals(username) && banker){
          System.out.print("What would you like to do"
          +"Deposit money -- 1"
          +"Withdraw money -- 2"
          +"Check Status -- 3"
          +"Log out -- 4");
          int bankact = scan.nextInt();
          if (bankact == 1){
            System.out.println("How much do you want to deposit");
            double depositamt = scan.nextDouble();
            account.deposit(depositamt);
            account.intrest();
          }
          if (bankact == 2){
            System.out.println("How much do you want to withdraw");
            double withdrawamt = scan.nextDouble();
            account.withdraw(withdrawamt);
            account.intrest();
          }
          if (bankact == 3){System.out.println(account.toString());}
          if (bankact == 4){banker = false;}
        }
        action = 0;
      }
      while (action == 7){
        if(bankAccount == 1) {
          System.out.print("How much do you want to Gamble");
          double gambleamt;
          if (scan.hasNextDouble()) {
            gambleamt = scan.nextDouble();
          } else {
            System.out.println("Needs to be int");
            continue;
          }
          System.out.print("What form of Gambling would you like to do?\n"
                  + "Dice -- 1\n"
                  + "Coin -- 2\n");
          int gambleAct = scan.nextInt();
          while (gambleAct == 1) {
            System.out.print("You need doubles to win, Chance: 16.7%");
            Die dice1 = new Die();
            Die dice2 = new Die();
            if (dice1.getFace() == dice2.getFace()) {
              System.out.println("Congrats, You Won!  You got: " + gambleamt);
              account.deposit(gambleamt);
            } else if (dice1.getFace() != dice2.getFace()) {
              System.out.println("Sorry you lost");
              account.pay(gambleamt);
            }
            gambleAct = 0;
          }
          while (gambleAct == 2) {
            System.out.println("You need three heads to win, Chance: 16.6%");
            Coin coin = new Coin();
            Coin coin2 = new Coin();
            Coin coin3 = new Coin();
            if (coin.isHead() && coin2.isHead() && coin3.isHead()) {
              System.out.println("Congrats, You Won!  You got: " + gambleamt);
              account.deposit(gambleamt);
            } else if (!coin.isHead()) {
              System.out.println("Sorry you lost");
              account.pay(gambleamt);
            }
            gambleAct = 0;
          }
        }
        else{
          System.out.println("You need a Bank Account to Gamble");
        }
        action = 0;
      }
      if (action == 10){
        play = false;
      }
    }
  }
}
