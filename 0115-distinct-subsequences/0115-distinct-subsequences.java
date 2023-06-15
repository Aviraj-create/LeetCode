class Solution {
    int [][]dp;
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        dp=new int[n][m];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return f(s,t,n-1,m-1);
    }
    
    public int f(String s,String t,int i,int j)
    {
        if(j<0)return 1;
        if(i<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
        {
            return dp[i][j]=f(s,t,i-1,j-1)+f(s,t,i-1,j);
        }
        else
        {
            return dp[i][j]=f(s,t,i-1,j);
        }
    }
    
}