import java.util.Scanner;

public class Sim5{
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    Car Car = new Car("---", "---", 0, 0);
    BankAccount account;
    boolean play = true;
    boolean drive = true;
    double miles;
    String make;
    String model;
    String username;
    String password;
    double fuelCap = 0.0;
    double mpg;
    int crash = 0;
    int haveCar = 0;
    double gasx = (int)(Math.random()*100-50);
    double gasy = (int)(Math.random()*100-50);
    int bankAccount = 0;
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
        account = new BankAccount(username, password, 0);
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
          if (direction == 1){Car.driveRight(miles);scan.nextLine();}
          if (direction == 2){Car.driveLeft(miles);scan.nextLine();}
          if (direction == 3){Car.driveUp(miles);scan.nextLine();}
          if (direction == 4){Car.driveDown(miles);scan.nextLine();}
          crash = (int)(Math.random()*77+1);
          if (crash == 1 && (direction == 1 || direction == 2 || direction == 3 || direction == 4)){Car.crash();}
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
      while (action == 10){
        play = false;
        action = 0;
      }
    }
  }
}
