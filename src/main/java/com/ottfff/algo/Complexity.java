package com.ottfff.algo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Complexity {
    private static final Logger log = LoggerFactory.getLogger(Complexity.class);

    public static void main(String[] args) {
        int result1 = new Complexity().search(new int[]{1, 5, 2, 6, 7, 3, 45, 2, 24, 234, 76, 2}, 45);
        int result2 = new Complexity().search(new int[]{1, 5, 2, 6, 7, 3, 45, 2, 24, 234, 76, 2}, 53);
        log.info("Result 1: {}", result1);
        log.info("Result 2: {}", result2);
    }

    // O(n)
    public int search(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    // O(n log n) = n logn + logn
    public int search2(int[] arr, int x) {
        Arrays.sort(arr); // n logn
        return binarySearch(arr); // logn
    }

    // O(n)
    public int search(int[] arr, int x, int y) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == y) return i;
        }
        return -1;
    }


    // find x and y that x+y=target. return array with 2 elements: x and y.
    // O(n^2) - time complexity
    // O(1) - memory complexity
    public int[] searchPair(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (arr[i] + arr[j] == target) return new int[]{arr[i], arr[j]};
            }
        }
        return new int[0];
    }

    // find x and y that x+y=target. return array with 2 elements: x and y.
    // O(n^2) - time complexity
    // O(1) - memory complexity
    public int[] searchPair2(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) return new int[]{arr[i], arr[j]};
            }
        }
        return new int[0];
    }

    // find x and y that x+y=target. return array with 2 elements: x and y.
    // O(n) - time complexity
    // 1n=O(n) - memory complexity
    public int[] searchPair3(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(target - arr[i])) return new int[]{arr[i], target - arr[i]};
        }
        return new int[0];
    }

    // find x and y that x+y=target. return array with 2 elements: x and y.
    // O(n) - time complexity
    // 2n=O(n) - memory complexity
    public int[] searchPair4(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : arr) set.add(i);
        for (int i : arr) set2.add(i);
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(target - arr[i])) return new int[]{arr[i], target - arr[i]};
        }
        return new int[0];
    }

    // find x and y that x+y=target. return array with 2 elements: x and y.
    // O(n^2) - time complexity
    // O(n^2) - memory complexity
    public int[] searchPair5(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : arr) set.add(i);
        for (int i : arr) {
            for (int j : arr) {
                list.add(1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(target - arr[i])) return new int[]{arr[i], target - arr[i]};
        }
        return new int[0];
    }

    //log()
    public int binarySearch(int[] arr) {

    }


}


