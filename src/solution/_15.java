package solution;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class _15 {

    private int binarySearch(int[] nums, int low, int high, int key) {
        if (low <= high) {
            int mid = (low+high)/2;
            if (key == nums[mid]) {
                return mid;
            }
            else if (key < nums[mid]) {
                return binarySearch(nums, low, mid-1, key);
            }
            else {
                return binarySearch(nums, mid+1, high, key);
            }
        }

        return -1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            int target = 0 - nums[i];
            
            while (j < k) {
                if (target == nums[j] + nums[k]) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(target);

                    ret.add(triplet);
                    
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
                else if (target > nums[j] + nums[k]) {
                    j++;
                }
                else {
                    k--;
                }
            }
            
            i++;
        }

        return ret;
    }

    @Test
    public void test() {
        int[] a = {-1,0,1,2,-1,-4};
        threeSum(a);
    }
}
