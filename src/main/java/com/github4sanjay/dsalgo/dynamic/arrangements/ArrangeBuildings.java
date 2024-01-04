package com.github4sanjay.dsalgo.dynamic.arrangements;

/*
 * Given an input number of sections and each section has 2 plots on either sides of the road.
 * Find all possible ways to construct buildings in the plots such that there is a space between any 2 buildings.
 *
 * Example :
 *
 * N = 1
 * Output = 4
 * Place a building on one side.
 * Place a building on other side
 * Do not place any building.
 * Place a building on both sides.
 *
 * N = 3
 * Output = 25
 * 3 sections, which means possible ways for one side are
 * BSS, BSB, SSS, SBS, SSB where B represents a building
 * and S represents an empty space
 * Total possible ways are 25, because a way to place on
 * one side can correspond to any of 5 ways on other side.
 *
 * N = 4
 * Output = 64
 */
public class ArrangeBuildings {

  public static void main(String[] args) {
    System.out.println(ArrangeBuildings.count(3));
    System.out.println(ArrangeBuildings.count(4));
  }

  private static int count(int n) {
    return (int) Math.pow(CountBinaryStringsWithoutTwoConsecutiveZeroes.tabulation(n), 2);
  }
}
