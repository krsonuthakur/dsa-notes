package day3;

import java.util.Arrays;

//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.
// #283
public class MoveZeroes {
    public void moveZeroesBad(int[] nums) {
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 0) {
                    nums[j] = nums[i] + nums[j];
                    nums[i] = nums[j] - nums[i];
                    nums[j] = nums[j] - nums[i];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    //    ChatGPT - best is 2 pointers
    public void moveZeroes(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int insetPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insetPos++] = num;
            }
        }
        while (insetPos < nums.length) {
            nums[insetPos++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();

        moveZeroes.moveZeroesBad(new int[]{0, 1, 0, 3, 12});
        System.out.println();
        moveZeroes.moveZeroesBad(new int[]{0});

        moveZeroes.moveZeroes(new int[]{0, 1, 0, 3, 12});
        System.out.println();
        moveZeroes.moveZeroes(new int[]{0});
    }
}
