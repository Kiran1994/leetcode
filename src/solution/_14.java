package solution;

public class _14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs.length < minLength) {
                minLength = strs.length;
            }
        }

        String longestCommonPrefix = "";
        String compare = strs[0].substring(0, minLength);
        while (minLength != 0) {
            boolean allContains = true;
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(compare)) {
                    allContains = false;
                    break;
                }
            }

            if (allContains) {
                return compare;
            }
            else {
                compare = compare.substring(0, minLength - 1);
                minLength--;
            }
        }

        return longestCommonPrefix;
    }
}
