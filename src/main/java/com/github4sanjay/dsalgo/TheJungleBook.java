package com.github4sanjay.dsalgo;

/*
   There are a number of animal species in the forest. Each species has one or more predator that may be direct or indirect. Species X is said to be a predator of species Y if at least or of the following is true:

   Species X is a direct predator of species Y
   If species X is a direct predator of species Z, and Z is a direct predator of Y, then spec is an indirect predator of species Y.
   Indirect predation is transitive through any numb of levels. Each species has a maximum of 1 direct predator. No two species will ever be mutual predators, and no species is a predator of itself. Your task is to determine the minimum number of groups that must be formed to so that no species is grouped with its predators, direct or indirect. As an example, consider an array where each position represents a species and each element represents a predator of that species or-1 if there are none. The array is a [-1, 8, 6, 0, 7, 3, 8, 9, -1, 6, 1] and we’ll use zero indexing.

   0              8
    \            / \
     3          1   6
      \        /   / \
       5     10   2   9
                       \
                        7
                         \
                          4
   These are the trees created based on the given array.
   The groups will be: [0,8], [3,1,6], [5,10,2,9], [7], [4]
*/
public class TheJungleBook {

  public static int find(int[] ints) {
    int max = 1;
    int arrLen = ints.length;
    for (var i = 0; i < ints.length; i++) {
      var a = i;
      var counter = 1;
      while (ints[a] > -1 && ints[a] < arrLen && counter < arrLen) {
        a = ints[a];
        counter++;
      }

      if (counter > max) max = counter;
    }
    return max;
  }
}
