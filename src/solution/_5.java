package solution;

import solution.common.StringUtils;

public class _5 {

    private String longestCommonSubstring(String a, String b) {
        int[][] d = new int[a.length() + 1][];
        int max = -1, maxI = 0;

        d[0] = new int[b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            d[i+1] = new int[b.length() + 1];
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    d[i+1][j+1] = d[i][j] + 1;
                    if (d[i+1][j+1] > max && StringUtils.isPalindrome(a.substring(i+1 - d[i+1][j+1], i+1))) {
                        max = d[i+1][j+1];
                        maxI = i+1;
                    }
                }
            }
        }
        
        if (max > -1) {
            return a.substring(maxI - max, maxI);
        }
        
        return null;
    }

    public String longestPalindromicSubstring(String s) {
        if (s.length() == 0) {
            return s;
        }

        String rev = StringUtils.reverse(s);
        String ans = longestCommonSubstring(s, rev);
        
        return ans;
    }
}
