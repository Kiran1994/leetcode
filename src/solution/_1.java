package solution;

import java.util.HashMap;
import java.util.Map;

public class _1 {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[] res = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            Integer index = indexMap.get(diff);
            if (index != null) {
                res[0] = index.intValue();
                res[1] = i;
                break;
            }
            indexMap.put(nums[i], i);
        }
        
        return res;
    }
}
