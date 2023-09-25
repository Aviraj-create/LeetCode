import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public boolean isSubsequence(String s, String t) {
        HashMap<String, Boolean> memo = new HashMap<>();
        return f(0, 0, s, t, memo);
    }

    public boolean f(int i, int j, String s, String t, HashMap<String, Boolean> memo) {
        if (j >= t.length()) {
            String key = i + "," + j;
            if (!memo.containsKey(key)) {
                String p = s.substring(0, i);
                memo.put(key, p.equals(s));
            }
            return memo.get(key);
        }

        String key = i + "," + j;
        if (!memo.containsKey(key)) {
            boolean result = false;

            if (i < s.length() && s.charAt(i) == t.charAt(j)) {
                result = f(i + 1, j + 1, s, t, memo);
            }

            result = result || f(i, j + 1, s, t, memo);
            memo.put(key, result);
        }

        return memo.get(key);
    }
}
