package solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _8 {

    public int myAtoi(String str) {
        long ret = 0;
        boolean digitFound = false;
        boolean isNegative = false;
        
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (Character.isDigit(c)) {
                ret = ret*10 + Character.getNumericValue(c);
                if (ret > Integer.MAX_VALUE) {
                    if (isNegative) {
                        return Integer.MIN_VALUE;
                    };
                    
                    return Integer.MAX_VALUE;
                }

                digitFound = true;
            }
            else if (c.charValue() == '+' && !digitFound) {
                isNegative = false;
                digitFound = true;
            }
            else if (c.charValue() == '-' && !digitFound) {
                isNegative = true;
                digitFound = true;
            }
            else if (c.charValue() == ' ' && !digitFound) {
                continue;
            }
            else {
                break;
            }
        }

        if (isNegative) {
            return (int)(ret * -1);
        }

        return (int)ret;
    }
    
    @Test
    public void test() {
        assertEquals(myAtoi("+123"), 123);
        assertEquals(myAtoi("++123"), 0);
        assertEquals(myAtoi("+-123"), 0);
        assertEquals(myAtoi("--123"), 0);
        assertEquals(myAtoi("-123"), -123);
        assertEquals(myAtoi("+12345678901234"), 2147483647);
        assertEquals(myAtoi("-12345678901234"), -2147483648);
    }
}
