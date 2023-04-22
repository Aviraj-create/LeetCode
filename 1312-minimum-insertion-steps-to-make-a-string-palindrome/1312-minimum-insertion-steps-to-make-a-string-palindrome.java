class Solution {
    int[][]dp;
    public int f(int i,int j,String s,String s2,int[][]dp)
    {
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=1+f(i-1,j-1,s,s2,dp);
        }
        else
        {
            return dp[i][j]=Math.max(f(i,j-1,s,s2,dp),f(i-1,j,s,s2,dp));
        }
    }
    public int helper(String s)
    {
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        sb.reverse();
        String s2=sb.toString();
        
        return f(s.length()-1,s.length()-1,s,s2,dp);
    }
    public int minInsertions(String s) {
        dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        return s.length()-helper(s);
        
    }
}