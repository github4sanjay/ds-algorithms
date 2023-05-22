package com.github4sanjay.dsalgo.java.record;

public record Student(String name, String email) {

  public static String SCHOOL_NAME;

  public Student {
    if (name != null && name.length() == 0) {
      throw new RuntimeException("invalid name");
    }

    if (email != null && email.length() == 0) {
      throw new RuntimeException("invalid email");
    }
  }

  // can override getters
  @Override
  public String name() {
    return name;
  }

  // in record can declare static methods
  public static void setSchoolName(String schoolName) {
    SCHOOL_NAME = schoolName;
  }

  // in record can declare instance methods
  public void printName(String schoolName) {
    System.out.println(name);
  }
}
