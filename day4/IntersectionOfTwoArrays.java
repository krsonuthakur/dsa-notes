package day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Leetcode #349
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        Set<Integer> numbers = new HashSet<>();
        for (int num : nums1) {
            numbers.add(num);
        }

        Set<Integer> intersectingNumbers = new HashSet<>();
        for (int num : nums2) {
            if (numbers.remove(num)) {
                intersectingNumbers.add(num);
            }
        }

        return intersectingNumbers.stream().mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();

        System.out.println(Arrays.toString(intersection.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
