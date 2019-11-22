public class CarInstances{
  public static void main(String[]args){
    Car car1 = new Car("Honda", "Civic", 30, 20);
    Car car2 = new Car("Honda2", "Cccivikkc", 15, 2);
    Car car3 = new Car("Honda3", "Civivikc", 40, 5);
    System.out.println(car1.getx()+", "+ car1.gety());
    System.out.println(car2.getx()+", "+ car2.gety());
    System.out.println(car3.getx()+", "+ car3.gety());
    car1.driveRight(20);
    car2.driveUp(100);
    car3.driveLeft(50);
    System.out.println(car1.toString());
    System.out.println(car2.toString());
    System.out.println(car3.toString());
  }
}
