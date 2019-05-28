package solution;

import org.junit.Test;

public class _33 {

    private int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low+high)/2;
        if (target == nums[mid]) {
            return mid;
        }
        else if (target > nums[mid]) {
            return binarySearch(nums, mid+1, high, target);
        }
        else {
            return binarySearch(nums, low, mid-1, target);
        }
    }
    
    private int findPivot(int[] nums, int low, int high) {
        if (low >= high) {
            return low;
        }

        if (nums[low] <= nums[high]) {
            return low;
        }

        int n = nums.length;
        int mid = (low+high)/2;
        int prev = (mid + n - 1)%n;
        int next = (mid + 1)%n;

        if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
            return mid;
        }

        if (nums[mid] <= nums[high]) {
            return findPivot(nums, low, mid-1);
        }

        return findPivot(nums, mid+1, high);
    }

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length-1);
        System.out.println(pivot);
        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (nums[pivot] == target) {
            return pivot;
        }

        if (nums[0] <= target) {
            return binarySearch(nums, 0, pivot - 1, target);
        }
        
        return binarySearch(nums, pivot+1, nums.length - 1, target);
    }
    
    @Test
    public void test() {
        int[] nums = {4,5,6,7,0,1,2};
        int t = 5;
        search(nums, t);
    }
}
