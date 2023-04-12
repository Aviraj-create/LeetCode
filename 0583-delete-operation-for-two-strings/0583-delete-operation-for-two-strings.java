class Solution {
    int f(int i,int j,String A,String B,int[][]dp)
    {
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        
        if(A.charAt(i)==B.charAt(j))
            return dp[i][j]=1+f(i-1,j-1,A,B,dp);
        {
            return dp[i][j]=0+Math.max(f(i-1,j,A,B,dp),f(i,j-1,A,B,dp));
        }
        
        
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        
        int [][]dp=new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        int comman=f(n-1,m-1,word1,word2,dp);
        
        return (n-comman)+(m-comman);
    }
}