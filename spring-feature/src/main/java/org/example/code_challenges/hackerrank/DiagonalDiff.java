package org.example.code_challenges.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDiff {
    public static void main(String[] args) {

    }

    private static int diagonalDifference(List<List<Integer>> arr) {
        int left2RightCount = 0;
        int right2LeftCount = 0;
        int length = arr.size();
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (i == j) {
                    left2RightCount += arr.get(i).get(j);
                } else if (i + j == length - 1) {
                    right2LeftCount += arr.get(i).get(j);
                }
            }
        }
        return Math.abs(left2RightCount - right2LeftCount);
    }

    private static int diagonalDifferenceOptimal(List<List<Integer>> arr) {
        int left2RightCount = 0;
        int right2LeftCount = 0;
        int length = arr.size();
        for (int i = 0; i < length; i++) {
            left2RightCount += arr.get(i).get(i);
            right2LeftCount += arr.get(i).get(length - 1 - i);
        }
        return Math.abs(left2RightCount - right2LeftCount);
    }
}
