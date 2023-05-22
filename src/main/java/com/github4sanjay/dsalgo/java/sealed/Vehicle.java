package com.github4sanjay.dsalgo.java.sealed;

public sealed class Vehicle permits Car, Bike, Truck, ElectricCar, DieselCar, FlexEngine {}

final class Car extends Vehicle {}

final class Bike extends Vehicle {}

final class Truck extends Vehicle {}
