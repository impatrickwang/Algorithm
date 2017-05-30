import java.util.Map;
import java.util.HashMap;
/**
 * 1. two layers for loops, O(N^2)
 * 2. single layer loop, O(N)
 */
public class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

}
