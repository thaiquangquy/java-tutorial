package org.example.code_challenges.hackerrank;

import java.util.*;

public class LonelyItem {
    public static void main(String[] args) {
        System.out.println("Hello");
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
        List<Integer> anotherList = List.of(1, 2, 3, 4, 3, 2, 1);

        System.out.println(lonelyInteger(arr));
        System.out.println(lonelyInteger(anotherList));
        System.out.println(lonelyIntegerOptimal(anotherList));
        System.out.println(lonelyIntegerXor(anotherList));
    }

    private static Integer lonelyInteger(List<Integer> arr) {
        Integer lonelyInt = 0;
        Map<Integer, Integer> itemAppearance = new HashMap<>();
        for (Integer item : arr) {
            if (itemAppearance.getOrDefault(item, 0) == 0) {
                itemAppearance.put(item, 1);
            } else {
                int count = itemAppearance.get(item);
                itemAppearance.put(item, ++count);
            }
        }
        for (Integer key : itemAppearance.keySet()) {
            if (itemAppearance.get(key) == 1) {
                lonelyInt = key;
            }
        }

        return lonelyInt;
    }

    private static Integer lonelyIntegerOptimal(List<Integer> arr) {
        Map<Integer, Integer> itemAppearance = new HashMap<>();
        for (Integer item : arr) {
            itemAppearance.put(item, itemAppearance.getOrDefault(item, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : itemAppearance.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null; // Return null if no lonely integer is found
    }

    private static int lonelyIntegerXor(List<Integer> arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}
