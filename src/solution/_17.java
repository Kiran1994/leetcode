package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17 {
    
    public void allCombo(String s, int i, Map<Character, char[]> charsetMap, String formedString, 
            List<String> combo) {

        if (i == s.length()) {
            if (formedString.length() != 0) {
                combo.add(formedString);
            }
            return;
        }

        char key = s.charAt(i);
        char[] charset = charsetMap.get(key);

        if (charset.length == 0) {
            allCombo(s, i+1, charsetMap, formedString, combo);
        }

        for (int j = 0; j < charset.length; j++) {
            String newString = formedString + charset[j];
            allCombo(s, i+1, charsetMap, newString, combo);
        }
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> phoneDigitToAlphaMap = new HashMap<>();
        
        char[] two = {'a', 'b', 'c'};
        char[] three = {'d', 'e', 'f'};
        char[] four = {'g', 'h', 'i'};
        char[] five = {'j', 'k', 'l'};
        char[] six = {'m', 'n', 'o'};
        char[] seven = {'p', 'q', 'r', 's'};
        char[] eight = {'t', 'u', 'v'};
        char[] nine = {'w', 'x', 'y', 'z'};

        phoneDigitToAlphaMap.put('2', two);
        phoneDigitToAlphaMap.put('3', three);
        phoneDigitToAlphaMap.put('4', four);
        phoneDigitToAlphaMap.put('5', five);
        phoneDigitToAlphaMap.put('6', six);
        phoneDigitToAlphaMap.put('7', seven);
        phoneDigitToAlphaMap.put('8', eight);
        phoneDigitToAlphaMap.put('9', nine);

        List<String> combo = new ArrayList<>();

        allCombo(digits, 0, phoneDigitToAlphaMap, "", combo);
        
        return combo;
    }
}
