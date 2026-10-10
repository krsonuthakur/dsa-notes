package day3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
// #268
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Map<Integer, Boolean> presentNumbers = new HashMap<>();

        for (int i : nums) {
            presentNumbers.put(i, true);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (null == presentNumbers.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumberSet(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int i : nums) {
            numbers.add(i);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!numbers.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    //    Chat GPT says use XOR - best solution
    public int missingNumberXOR(int[] nums) {
        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();

        System.out.println(missingNumber.missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber.missingNumber(new int[]{0, 1}));
        System.out.println(missingNumber.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));

        System.out.println(missingNumber.missingNumberSet(new int[]{3, 0, 1}));
        System.out.println(missingNumber.missingNumberSet(new int[]{0, 1}));
        System.out.println(missingNumber.missingNumberSet(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));

        System.out.println(missingNumber.missingNumberXOR(new int[]{3, 0, 1}));
        System.out.println(missingNumber.missingNumberXOR(new int[]{0, 1}));
        System.out.println(missingNumber.missingNumberXOR(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
