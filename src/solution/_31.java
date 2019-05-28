package solution;

import java.util.Arrays;

public class _31 {

    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int i = nums.length - 2;
        
        while (i >= 0) {
            if (nums[i] < nums[i+1]) {
                int j = i+1;
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                while (j < nums.length) {
                    if (nums[j] < min && nums[j] > nums[i]) {
                        min = nums[j];
                        minIndex = j;
                    }
                    j++;
                }
                min = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = min;
                break;
            }
            i--;
        }

        Arrays.sort(nums, i+1, nums.length);
    }
}
