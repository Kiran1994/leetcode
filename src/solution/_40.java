package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40 {
    
    public void combinationSum2(int[] nums, int target, int start, int remaining, List<Integer> curr, 
            List<List<Integer>> res) {

        if (remaining == 0) {
            res.add(curr);
            return;
        }

        if (start >= nums.length) {
            return;
        }

        if (nums[start] > remaining) {
            return;
        }

        int i = start;
        while (i < nums.length) {
            List<Integer> newCurr = new ArrayList<>();
            newCurr.addAll(curr);
            newCurr.add(nums[i]);
            combinationSum2(nums, target, i+1, remaining - nums[i], newCurr, res);
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] != nums[j]) {
                    break;
                }
                j++;
            }
            i = j;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, target, new ArrayList<>(), res);
        return res;
    }
}
