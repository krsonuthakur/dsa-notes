package day1;

import java.util.HashSet;
import java.util.Set;

//2026-10-05
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!unique.add(nums[i]))
                return true;
        }
        return false;
    }
}
