class Solution {
    public int longestValidParentheses(String s) {
        int[]dp=new int[s.length()];
        int leftCountPar=0;
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')leftCountPar++;
            else if(leftCountPar>0)
            {
                dp[i]=dp[i-1]+2;
                dp[i]+=(i-dp[i]>=0)?dp[i-dp[i]]:0;
                ans=Math.max(dp[i],ans);
                leftCountPar--;
            }
        }
        
        return ans;
    }
}