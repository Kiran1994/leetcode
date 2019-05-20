package solution.common;

public class StringUtils {

    public static boolean isPalindrome(String a) {
        int i = 0;
        int j = a.length() - 1;
        while (i <= j) {
            if (a.charAt(i) != a.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }

    public static String longestCommonSubstring(String a, String b) {
        int[][] d = new int[a.length() + 1][];
        int max = -1, maxI = 0;

        d[0] = new int[b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            d[i+1] = new int[b.length() + 1];
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    d[i+1][j+1] = d[i][j] + 1;
                    if (d[i+1][j+1] > max) {
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

    //TODO: dont create object for every concat
    public static String reverse(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        
        return rev;
    }
}
