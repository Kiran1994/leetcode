package solution;

public class _28 {

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }

        if (haystack.length () < needle.length()) {
            return -1;
        }

        int i = 0, n = needle.length(), m = haystack.length();
        
        while (i <= m - n) {
            int j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }
            
            if (j == needle.length()) {
                return i;
            }
            i++;
        }
        
        return -1;
    }
}
