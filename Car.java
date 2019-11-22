public class Car{
  private double fuel;
  private double fuelCap;
  private double mpg;  //miles per gallon'
  private double x;
  private double y;
  private String make;
  private String model;
  private double origFuel;
  private double origFuelCap;
  private double origMpg;  //miles per gallon
  private String origMake;
  private String origModel;

  public Car(String carMake, String carModel, double carMpg, double carFuelCap){
    make = carMake;
    model = carModel;
    mpg = carMpg;
    fuelCap = carFuelCap;
    fuel = carFuelCap;
    origMake = carMake;
    origModel = carModel;
    origMpg = carMpg;
    origFuelCap = carFuelCap;
    origFuel = carFuelCap;
    if (make.equals("Honda") && model.equals("Civic")){
      make = "Lawn";
      model = "Mower";
    }
  }


  public String getMake(){
    return make;
  }
  public String getModel(){
    return model;
  }
  public double getMpg(){
    return mpg;
  }
  public double getFuel(){
    return fuel;
  }
  public double getFuelCap(){
    return fuelCap;
  }
  public String getOrigModel(){
    return origModel;
  }
  public double getx(){
    return x;
  }
  public double gety(){
    return y;
  }


  public void setFuel(double newFuel){
    fuel = newFuel;
  }



  public void driveLeft(double miles){
    if (fuel - (miles/mpg) > 0){
      fuel = fuel - (miles/mpg);
      x = x - miles;
      System.out.println("x: "+x+", y: "+y);
      System.out.println("fuel remaining: "+ fuel);
    }else if (fuel - (miles/mpg) <= 0){
      x = x-(fuel*mpg);
      fuel = 0;
      System.out.println("You ran out of gas");
    }
  }
  public void driveRight(double miles){
    if (fuel - (miles/mpg) > 0){
      fuel = fuel - (miles/mpg);
      x = x + miles;
      System.out.println(x+", "+y);
      System.out.println("fuel remaining: "+ fuel);
    }else if (fuel - (miles/mpg) <= 0){
      x = x+(fuel*mpg);
      fuel = 0;
      System.out.println("You ran out of gas");
    }
  }
  public void driveUp(double miles){
    if (fuel - (miles/mpg) > 0){
      fuel = fuel - (miles/mpg);
      y = y + miles;
      System.out.println(x+", "+y);
      System.out.println("fuel remaining: "+ fuel);
    }else if (fuel - (miles/mpg) <= 0){
      y = y+(fuel*mpg);
      fuel = 0;
      System.out.println("You ran out of gas");
    }
  }
  public void driveDown(double miles){
    if (fuel - (miles/mpg) > 0){
      fuel = fuel - (miles/mpg);
      y = y - miles;
      System.out.println(x+", "+y);
      System.out.println("fuel remaining: "+ fuel);
    }else if (fuel - (miles/mpg) <= 0){
      y = y-(fuel*mpg);
      fuel = 0;
      System.out.println("You ran out of gas");
    }
  }
  public void addFuel(double addedFuel){
    if (fuel + addedFuel <= fuelCap){
      fuel = fuel + addedFuel;
    } else{
      fuel = fuelCap;
      System.out.println("You tried to add too much fuel");
    }
  }

  public void crash(){
    System.out.println("You crashed your car");
    model = model+"-broken-";
    mpg = (mpg/1.5);
    fuel = 0;
    fuelCap = fuelCap / 2;
  }
  public void repair(){
    if (fuelCap == origFuelCap/2){
      System.out.println("You fixed your car");
      model = origModel;
      mpg = origMpg;
      fuel = origFuelCap;
      fuelCap = origFuelCap;
    } else{
      System.out.println("There is nothing to fix");
    }
  }
  public String toString(){
    String result = "";
    result += "Make: "+ make;
    result += " Model: "+ model +"\n";
    result += "MPG: "+ mpg +"\n";
    result += "Tank Size: "+ fuelCap +"\n";
    result += "Current fuel in Tank " + fuel +"\n";
    result += "x: "+ x +", y: "+y+"\n";
    return result;
  }
}
