package com.github4sanjay.dsalgo.java.record;

public class RecordClient {

  public static void main(String[] args) {
    var student = new Student("Sanjay Kumar", "san@foo.com");
    System.out.println(student.name());
  }
}
