package solution;

import org.junit.Test;

public class _34 {
    
    private int binarySearchLeftShift(int[] nums, int low, int high, int target) {
        if (low >= high) {
            return low;
        }

        int mid = (low + high)/2;
        if (nums[mid] >= target) {
            return binarySearchLeftShift(nums, low, mid, target);
        }
        else {
            return binarySearchLeftShift(nums, mid+1, high, target);
        }
    }
    
    private int binarySearchRightShift(int[] nums, int low, int high, int target) {
        if (low >= high) {
            return low;
        }

        int mid = (low + high)/2;
        if (nums[mid] <= target) {
            return binarySearchRightShift(nums, mid+1, high, target);
        }
        else {
            return binarySearchRightShift(nums, low, mid, target);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int left = binarySearchLeftShift(nums, 0, nums.length, target);
        int[] res = {left, -1};

        if (left != -1) {
            res[1] = binarySearchRightShift(nums, 0, nums.length, target);
        }
        
        return res;
    }
            
    @Test
    public void test() {
        int[] nums = {5,7,7,8,8,10};
        searchRange(nums, 0);
    }
}
