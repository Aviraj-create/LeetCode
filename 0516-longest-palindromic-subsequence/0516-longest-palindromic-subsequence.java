class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        sb.reverse();
        String s1=sb.toString();
        
        int n=s.length();
        
        int[][] dp=new int[n][n];
        for(int[] temp:dp)
        {
            Arrays.fill(temp,-1);
        }
        
        return f(n-1,n-1,s,s1,dp);
    }
    
    public int f(int i,int j,String s,String s1,int[][] dp)
    {
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==s1.charAt(j))
        {
            return dp[i][j]=1+f(i-1,j-1,s,s1,dp);
        }
        else
        {
            return dp[i][j]=0+Math.max(f(i-1,j,s,s1,dp),f(i,j-1,s,s1,dp));
        }
    }
}