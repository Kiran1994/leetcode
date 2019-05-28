package solution;

public class _35 {

    public int binarySearch(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                return binarySearch(nums, target, low, mid-1);
            }
            else {
                return binarySearch(nums, target, mid+1, high);
            }
        }
        
        return low;
    }

    public int searchInsert(int[] nums, int target) {
        int searchRes = binarySearch(nums, target, 0, nums.length - 1);
        return searchRes;
    }
}
