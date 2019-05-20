package solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import solution.common.StringUtils;

public class _9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        return StringUtils.isPalindrome(s);
    }
    
    @Test
    public void test() {
        assertEquals(isPalindrome(123), false);
        assertEquals(isPalindrome(121), true);
        assertEquals(isPalindrome(-121), false);
    }
}
