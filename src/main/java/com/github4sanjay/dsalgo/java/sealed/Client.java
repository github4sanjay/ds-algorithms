package com.github4sanjay.dsalgo.java.sealed;

public class Client {

  public static void main(String[] args) {
    var trafficLight = new RedLight();
  }
}

// does  not allow outside sealed file
/*final class BrokenLight implements TrafficLight {

}*/

// permits lets use outside sealed classes/interfaces
sealed class ElectricCar extends Vehicle permits LithiumBattery {}

final class LithiumBattery extends ElectricCar {}

final class DieselCar extends Vehicle {}

// non-sealed classes or interfaces can have subclass
non-sealed class FlexEngine extends Vehicle {}

class Ethanol extends FlexEngine {}
