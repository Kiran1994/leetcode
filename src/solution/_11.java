package solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _11 {

    private int min(int x, int y) {
        if (x < y) {
            return x;
        }
        
        return y;
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        
        int maxVolume = 0;
        while (i < j) {
            int volume = min(height[i], height[j]) * (j-i);
            if (volume > maxVolume) {
                maxVolume = volume;
            }
            
            if (height[i] > height[j]) {
                j--;
            }
            else {
                i++;
            }
        }
        
        return maxVolume;
    }

    @Test
    public void test() {
        int[] a = {1,8,6,2,5,4,8,3,7};
        assertEquals(a, 49);
    }
}
