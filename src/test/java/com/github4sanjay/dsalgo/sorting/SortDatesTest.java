package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortDatesTest {

  @Test
  @DisplayName("Sorting dates in an array")
  public void testSortDates() {
    String[] arr = {"20012014", "25032010", "03122000", "18112001", "19042015", "09072005"};
    SortDates.sort(arr);
    assertArrayEquals(
        new String[] {"03122000", "18112001", "09072005", "25032010", "20012014", "19042015"}, arr);
  }

  @Test
  @DisplayName("Sorting empty array of dates")
  public void testSortDatesEmptyArray() {
    String[] arr = {};
    SortDates.sort(arr);
    assertArrayEquals(new String[] {}, arr);
  }

  @Test
  @DisplayName("Sorting array with a single date")
  public void testSortDatesSingleElementArray() {
    String[] arr = {"01012020"};
    SortDates.sort(arr);
    assertArrayEquals(new String[] {"01012020"}, arr);
  }

  @Test
  @DisplayName("Sorting array with duplicate dates")
  public void testSortDatesDuplicateDates() {
    String[] arr = {"20012014", "25032010", "20012014", "25032010", "20012014", "25032010"};
    SortDates.sort(arr);
    assertArrayEquals(
        new String[] {"25032010", "25032010", "25032010", "20012014", "20012014", "20012014"}, arr);
  }

  @Test
  @DisplayName("Sorting array with dates in reverse order")
  public void testSortDatesReverseOrder() {
    String[] arr = {"19042015", "20012014", "09072005", "18112001", "03122000", "25032010"};
    SortDates.sort(arr);
    assertArrayEquals(
        new String[] {"03122000", "18112001", "09072005", "25032010", "20012014", "19042015"}, arr);
  }
}
