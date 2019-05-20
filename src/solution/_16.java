package solution;

import java.util.Arrays;

public class _16 {

    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int res = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            
            while (j < k) {
                int threeSum = nums[i] + nums[j] + nums[k];
                int diff = target - threeSum;

                if (diff == 0) {
                    return threeSum;
                }
                else {
                    int diffAbsoluteValue = (diff < 0) ? diff * -1 : diff;
                    if (diffAbsoluteValue < minDiff) {
                        minDiff = diffAbsoluteValue;
                        res = threeSum;
                    }
                    
                    if (diff > 0) {
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }
        
        return res;
    }
}
