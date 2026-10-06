package day1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap();
        indexMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{};
    }
}

// as a review, check the element first before putting in the map, if elements are empty, it will break
