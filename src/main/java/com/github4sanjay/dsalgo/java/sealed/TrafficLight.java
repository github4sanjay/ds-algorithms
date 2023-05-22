package com.github4sanjay.dsalgo.java.sealed;

public sealed interface TrafficLight {
  public static void main(String[] args) {
    TrafficLight trafficLight = new RedLight();
  }
}

final class RedLight implements TrafficLight {}

final class YellowLight implements TrafficLight {}

final class GreenLight implements TrafficLight {}
