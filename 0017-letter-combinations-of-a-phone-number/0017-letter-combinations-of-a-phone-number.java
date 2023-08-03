class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return ans;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        f(0, digits, map, new StringBuilder());
        return ans;
    }

    void f(int i, String digits, Map<Character, String> map, StringBuilder s) {
        if (s.length() == digits.length()) {
            ans.add(s.toString());
            return;
        }

        String temp = map.get(digits.charAt(i));
        for (int j = 0; j < temp.length(); j++) {
            s.append(temp.charAt(j));
            f(i + 1, digits, map, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
