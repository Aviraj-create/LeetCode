class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(n == 1 || numRows == 1 || numRows >= n) return s;
        StringBuffer res = new StringBuffer("");
        int diff1 = 2*(numRows - 1);
        int diff2 = 0;
        for(int i = 0; i<numRows; i++){
            int curr = i;
            boolean fst = true;
            while(curr < n){
                res.append(s.charAt(curr));
                if(fst && diff1 != 0 || !fst && diff2 == 0){
                    fst = !fst;
                    curr += diff1;
                } else {
                    fst = !fst;
                    curr += diff2;
                }
            }
            diff1 -= 2;
            diff2 += 2;
        }
        return res.toString();
    }
}