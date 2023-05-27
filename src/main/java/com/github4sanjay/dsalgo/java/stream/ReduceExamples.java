package com.github4sanjay.dsalgo.java.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceExamples {

  public static void main(String[] args) {}

  public void example1() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int result = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element); // 21
  }

  public void example2() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int result = numbers.stream().reduce(0, Integer::sum); // 21
  }

  public void example3() {
    List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
    String result =
        letters.stream().reduce("", (partialString, element) -> partialString + element); // abcde
  }

  public void example4() {
    List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
    String result =
        letters.stream()
            .reduce(
                "",
                (partialString, element) ->
                    partialString.toUpperCase() + element.toUpperCase()); // ABCDE
  }
}
