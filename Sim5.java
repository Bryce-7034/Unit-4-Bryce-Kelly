import java.util.Scanner;

public class Sim5{
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    boolean play = true;
    boolean drive = false;
    Car Car = new Car("---", "---", 0, 0);
    while (play){
      System.out.print("What would you like to do\n"
      +"please type out one of the numbers of the actions:\n"
      +"Get Car -- 1\n"
      +"Drive -- 2\n");
      int action = scan.nextInt();
      while (action == 1 && (Car.getModel().equals("---") || Car.getModel() != Car.getOrigModel())){
        System.out.println("What make do you want");
        String make = scan2.nextLine();
        System.out.println("What model do you want");
        String model = scan2.nextLine();
        double fuelCap = (Math.random()*51+.1);
        double mpg = (Math.random()*30+15);
        Car = new Car(make, model, mpg, fuelCap);
        System.out.println("Your Car: "+ make+", "+model);
        action = 0;
      }
      while (action == 2){}
    }
  }
}
