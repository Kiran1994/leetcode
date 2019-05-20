package solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _12 {

    public String intToRoman(int num) {
        int[] romanNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanAlp = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String ret = "";
        for (int i = 0; i < romanNum.length; i++) {
            int x = num/romanNum[i];
            while (x > 0) {
                ret += romanAlp[i];
                x--;
            }
            num = num % romanNum[i];
        }

        return ret;
    }

    @Test
    public void test() {
        assertEquals(intToRoman(3999), "MMMCMXCIX");
        assertEquals(intToRoman(2390), "MMCCCXC");
    }
}
