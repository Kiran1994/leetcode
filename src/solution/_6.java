package solution;

public class _6 {

    public String convert(String s, int numRows) {
        if (s.length() == 0) {
            return s;
        }

        if (numRows == 1) {
            return s;
        }

        String[] stringList = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            stringList[i] = "";
        }

        int i = 0;
        int listNumber = 0;
        int minus = 1;
        while (i < s.length()) {
            stringList[listNumber] += String.valueOf(s.charAt(i));
            i++;
            if (listNumber == numRows - 1) {
                minus = -1;
            }
            else if (listNumber == 0) {
                minus = 1;
            }

            listNumber += minus;
        }
        
        String res = "";
        for (i = 0; i < numRows; i++) {
            res += stringList[i];
        }
        
        return res;
    }
}
