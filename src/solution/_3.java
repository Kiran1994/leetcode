package solution;

import java.util.HashMap;
import java.util.Map;

public class _3 {

    private int max(int x, int y) {
        if (x > y) {
            return x;
        }
        
        return y;
    }

    public int lengthOfLongestDistinctCharacterSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> posMap = new HashMap<>();
        
        int diff = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            Character charIntRep = s.charAt(j);
            if (posMap.containsKey(charIntRep)) {
                i = max(posMap.get(charIntRep) + 1, i);
            }
            posMap.put(charIntRep, j);
            diff = max(diff, j-i+1);
            j++;
        }
        
        return diff;
    }
}
