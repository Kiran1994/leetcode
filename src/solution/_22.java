package solution;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class _22 {

    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";

    public void generateAllParenthesis(int n, int open, int close, String seed, String curr, List<String> ret) {
        String newCurr = curr + seed;
        
        if (newCurr.length() == 2*n) {
            ret.add(newCurr);
            return;
        }

        if (open > close) {
            generateAllParenthesis(n, open, close + 1, CLOSE_BRACKET, newCurr, ret);
        }

        if (open < n) {
            generateAllParenthesis(n, open + 1, close, OPEN_BRACKET, newCurr, ret);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();

        generateAllParenthesis(n, 1, 0, OPEN_BRACKET, "", ret);
        
        return ret;
    }

    @Test
    public void test() {
        generateParenthesis(3);
    }
}
