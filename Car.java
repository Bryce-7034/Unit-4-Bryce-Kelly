public class Car{
  private double fuel;
  private double fuelCap;
  private double mpg;  //miles per gallon
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


  public void setFuel(double newFuel){
    fuel = newFuel;
  }



  public void drive(int miles){
    if (fuel - (miles/mpg) > 0){
      fuel = fuel - (miles/mpg);
    }else if (fuel - (miles/mpg) <= 0){
      fuel = 0;
    }
  }
  public void addFuel(double addedFuel){
    if (fuel + addedFuel <= fuelCap){
      fuel = fuel + addedFuel;
    } else{
      fuel = fuelCap;
    }
  }

  public void crash(){
    model = model+"-broken-";
    mpg = (mpg*1.5);
    fuel = 0;
    fuelCap = fuelCap / 2;
  }
  public void repair(){
    if (fuelCap == origFuelCap/2){
      model = origModel;
      mpg = origMpg;
      fuel = origFuelCap;
      fuelCap = origFuelCap;
    }
  }
  public String toString(){
    String result = "";
    result += "Make: "+ make;
    result += "Model: "+ model +"\n";
    result += "MPG: "+ mpg +"\n";
    result += "Tank Size: "+ fuelCap +"\n";
    result += "Current fuel in Tank " + fuel;
    return result;
  }
}
