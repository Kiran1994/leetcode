package solution;

public class _38 {

    private String countAndSay(String x) {
        StringBuilder ret = new StringBuilder();

        int count = 1;
        char prev = x.charAt(0);
        for (int i = 1; i < x.length(); i++) {
            if (x.charAt(i) != prev) {
                ret.append(count).append(prev);
                prev = x.charAt(i);
                count = 1;
            }
            else {
                count++;
            }
        }

        ret.append(count).append(x.charAt(x.length()-1));
        return ret.toString();
    }

    public String countAndSay(int n) {
        return countAndSay("1");
    }
}
