package com.github4sanjay.dsalgo.dynamic;

import java.util.Arrays;

/*
 *There are N tiles (numbered from 0 to N-1).
 * Each tile is made of two squares that are colored either red (represented by the letter "R") or green (represented by "").
 * A tile is described by a two-character string representing the respective colors of the left and right squares.
 * The tiles cannot be rotated (which means that "RG" and "GR" tiles are different).
 * Two tiles can be placed next to each other if the color of their adjacent squares is the same.
 * What is the length of the longest possible sequence that can be created using the provided tiles?
 * Write a function: class Solution { public int solution (String[] A): }
 * that, given an array A of N strings, representing the tiles, returns the maximum number of tiles that can be arranged
 * in a sequence. Examples:
 * 1. Given A = ["RR", "GR", "RG", "GR", ", "RR"],
 * we can select tiles 0, 2, 3, 4, 5 (underlined in the picture above) and arrange them into the sequence
 * GR - RR - RG - GR - RR: Tes The function should return 5.
 *
 * 2. Given A = ["GG", "GG", "RR", "GG", "RR"],
 * we can select tiles 0, 1, 3 (underlined in the picture above) and arrange them into the sequence GG - GG - GG:
 * Tes The function should return 3.
 */
public class ColoredTiles {

    public int solution(String[] A) {
        int n = A.length;
        int maxSequence = 0;
        boolean[] usedTiles = new boolean[n];
        int[] memo = new int[n];

        Arrays.fill(memo, -1); // Initialize memoization table with -1

        for (int i = 0; i < n; i++) {
            maxSequence = Math.max(maxSequence, findLongestSequence(A, i, usedTiles, memo));
        }

        return maxSequence;
    }

    private int findLongestSequence(String[] A, int currentTile, boolean[] usedTiles, int[] memo) {
        if (memo[currentTile] != -1) {
            //System.out.println("this is a debug message");
            return memo[currentTile];
        }

        int n = A.length;
        int maxLength = 1;
        usedTiles[currentTile] = true;

        for (int i = 0; i < n; i++) {
            // Check if the adjacent tiles have the same color on one side and the tile is not already used
            if (!usedTiles[i] && A[currentTile].charAt(0) == A[i].charAt(1)) {
                // Recursively find the longest sequence starting from the adjacent tile
                maxLength = Math.max(maxLength, 1 + findLongestSequence(A, i, usedTiles, memo));
            }
        }

        // Mark the current tile as unused to allow it to be used in other sequences
        usedTiles[currentTile] = false;

        memo[currentTile] = maxLength; // Memoize the result

        return maxLength;
    }
}
