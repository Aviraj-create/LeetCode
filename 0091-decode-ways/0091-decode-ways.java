class Solution {
    int[]dp;
    public int numDecodings(String s) {
        dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(s,0);
    }
    
    private int helper(String s,int idx)
    {
        if(dp[idx]!=-1)return dp[idx];
        if(idx>=s.length())return 1;
        if(s.charAt(idx)=='0')return 0;
        int ways=helper(s,idx+1);
        if(idx+2<=s.length() && Integer.parseInt(s.substring(idx,idx+2))<=26)
            ways+=helper(s,idx+2);
        
        return dp[idx]=ways;
    }
    
   
}