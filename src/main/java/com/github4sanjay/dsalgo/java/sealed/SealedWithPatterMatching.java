package com.github4sanjay.dsalgo.java.sealed;

// Java 17 preview level for Switch pattern match
public class SealedWithPatterMatching {

  public static void main(String[] args) {
    var shape = new WeirdTriangle();
    System.out.println(getNumberOfSides(shape));
  }

  public static int getNumberOfSides(Shape shape) {
    return switch (shape) {
      case WeirdTriangle t -> t.getNumberOfSides();
      case Circle c -> c.getNumberOfSides();
      case Triangle t -> t.getNumberOfSides();
      case Rectangle r -> r.getNumberOfSides();
      case Square s -> s.getNumberOfSides();
    };
  }
}

sealed interface Shape {
  int getNumberOfSides();
}

final class WeirdTriangle implements Shape {
  @Override
  public int getNumberOfSides() {
    return 2;
  }
}

final class Circle implements Shape {
  @Override
  public int getNumberOfSides() {
    return 0;
  }
}

final class Triangle implements Shape {
  @Override
  public int getNumberOfSides() {
    return 3;
  }
}

final class Rectangle implements Shape {
  @Override
  public int getNumberOfSides() {
    return 4;
  }
}

final class Square implements Shape {
  @Override
  public int getNumberOfSides() {
    return 4;
  }
}
