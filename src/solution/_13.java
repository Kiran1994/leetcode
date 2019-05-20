package solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _13 {

    public int romanToInt(String s) {
        int ret = 0;
        int[] romanNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanAlp = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i = 0;
        while (s.length() != 0) {
            boolean found = false;

            if (s.startsWith(romanAlp[i])) {
                found = true;
            }

            int length = romanAlp[i].length();

            if (!found) {
                i++;
            }
            else {
                ret += romanNum[i];
                s = s.substring(length);
            }
        }

        return ret;
    }

    @Test
    public void test() {
        assertEquals(romanToInt("MMMCMXCIX"), 3999);
        assertEquals(romanToInt("MMCCCXC"), 2390);
    }
}
