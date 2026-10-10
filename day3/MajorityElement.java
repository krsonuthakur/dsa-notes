package day3;

import java.util.HashMap;
import java.util.Map;

//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
// #169
public class MajorityElement {

    //    this is good
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numberCountMap = new HashMap<>();
        int highestCount = -1;
        int majorityNumber = -1;

        for (int num : nums) {
            numberCountMap.merge(num, 1, Integer::sum);
            if (highestCount < numberCountMap.get(num)) {
                highestCount = numberCountMap.get(num);
                majorityNumber = num;
            }
        }

        return majorityNumber;
    }

    //Best is Boyer moore
    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();

        System.out.println(element.majorityElement(new int[]{3, 2, 3}));
        System.out.println(element.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(element.majorityElement(new int[]{2, 3, 1, 1, 1, 2, 2}));//goes wrong here


    }
}
