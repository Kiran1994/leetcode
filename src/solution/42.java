package solution;

public class _42 {

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            leftMax[i] = max;
        }

        int[] rightMax = new int[height.length];
        max = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            rightMax[i] = max;
        }

        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            int cap = Math.min(leftMax[i], rightMax[i]);
            ret += (cap - height[i]);
        }

        return ret;
    }
}
