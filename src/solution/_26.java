package solution;

public class _26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int i = 0, j = 1;
        while (true) {
            while (j < nums.length && nums[j] == nums[j-1]) {
                j++;
            }

            if (j == nums.length) {
                break;
            }

            i++;
            nums[i] = nums[j];
            j++;
        }

        return i+1;
    }
}
