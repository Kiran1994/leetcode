package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class _39 {

    private void getCombinations(int[] nums, int target, List<List<Integer>> res, List<Integer> curr, 
            int remaining, int start) {

        if (remaining == 0) {
            res.add(curr);
            return;
        }

        if (start >= nums.length) {
            return;
        }

        if (remaining < nums[start]) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            List<Integer> newCurr = new ArrayList<>();
            newCurr.addAll(curr);
            newCurr.add(nums[i]);
            getCombinations(nums, target, res, newCurr, remaining - nums[i], i);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinations(candidates, target, res, new ArrayList<>(), target, 0);
        return res;
    }

    @Test
    public void test() {
        int[] can = {2,3,6,7};
        combinationSum(can, 7);
    }
}
