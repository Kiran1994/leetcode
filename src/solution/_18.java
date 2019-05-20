package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class _18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length - 3) {
            if (i != 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }

            int j = i + 1;

            while (j < nums.length - 2) {
                if (j != i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }

                int twoSum = nums[i] + nums[j];
                
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    int fourSum = twoSum + nums[k] + nums[l];
                    if (fourSum == target) {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[k]);
                        quad.add(nums[l]);

                        ret.add(quad);

                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k-1]) {
                            k++;
                        }
                        
                        while (k < l && nums[l] == nums[l+1]) {
                            l--;
                        }
                    }
                    else if (fourSum > target) {
                        l--;
                    }
                    else {
                        k++;
                    }
                }
                
                j++;
            }
            i++;
        }

        return ret;
    }

    @Test
    public void test() {
        int[] q = {1,0,-1,0,-2,2};
        fourSum(q, 0);
    }
}
