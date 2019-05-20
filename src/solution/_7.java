package solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _7 {

    public int reverse(int x) {
        long rev = 0;
        boolean isNegative = false;
        
        if (x < 0) {
            isNegative = true;
            x = x * -1;
        }
        
        while (x > 0) {
            rev = rev * 10 + (x%10);
            if (rev > Integer.MAX_VALUE) {
                return 0;
            }
            x = x/10;
        }
        
        if (isNegative) {
            rev *= -1;
        }
        
        return (int)rev;
    }

    @Test
    public void test() {
        assertEquals(reverse(123), 321);
        assertEquals(reverse(-123), -321);
        assertEquals(reverse(120), 21);
        assertEquals(reverse(1234567899), 0);
    }
}
