import java.util.Scanner;

public class Sim5{
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    boolean play = true;
    boolean drive = false;
    double miles;
    String make;
    String model;
    double fuelCap = 0.0;
    double mpg;
    int crash = 0;
    int haveCar = 0;
    Car Car = new Car("---", "---", 0, 0);
    while (play){
      System.out.print("What would you like to do\n"
      +"please type out one of the numbers of the actions:\n"
      +"Get Car -- 1\n"
      +"Drive -- 2\n"
      +"Get Gas -- 3\n"
      +"Repair -- 4\n"
      +"End -- 10\n");
      int action = scan.nextInt();
      scan.nextLine();
      if(action == 2 && haveCar == 0){System.out.println("you can't drive, you have no car");}
      if(action == 3 && haveCar == 0){System.out.println("you can't get gas, you have no car");}
      if(action == 4 && haveCar == 0){System.out.println("you can't repair what you dont have");}
      while (action == 1 && (Car.getModel().equals("---") || crash == 1)){
        haveCar = 0;
        System.out.println("What make do you want");
        make = scan2.nextLine();
        scan2.nextLine();
        System.out.println("What model do you want");
        model = scan2.nextLine();
        scan2.nextLine();
        fuelCap = (int)(Math.random()*15+1);
        mpg = (Math.random()*25.5+.5);
        Car = new Car(make, model, mpg, fuelCap);
        System.out.println(Car.toString());
        haveCar++;
        action = 0;
      }
      while (action == 2 && haveCar == 1){
        System.out.print("please state which way you want to drive\n"
        +"Right -- 1"
        +"Left -- 2"
        +"Up -- 3"
        +"Down -- 4");
        int direction = scan2.nextInt();
        scan2.nextLine();
        System.out.println("How many miles do you want to drive");
        miles = scan2.nextDouble();
        scan2.nextLine();
        if (direction == 1){Car.driveRight(miles);}
        if (direction == 2){Car.driveLeft(miles);}
        if (direction == 3){Car.driveUp(miles);}
        if (direction == 4){Car.driveDown(miles);}
        crash = (int)(Math.random()*77+1);
        if (crash == 1){Car.crash();}
      }
      while (action == 3 && haveCar == 1){
        System.out.println("Current fuel: "+Car.getFuel());
        System.out.println("Max fuel: "+ fuelCap);
        System.out.println("How much gas do you want");
        double fuelAdd = scan2.nextDouble();
        scan2.nextLine();
        Car.addFuel(fuelAdd);
      }
      while (action == 4){
        Car.repair();
        crash = 0;
      }
      while (action == 10){
        play = false;
        action = 0;
      }
    }
  }
}
