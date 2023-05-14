class Solution {
    int dp[][];
    public int f(int i,int j,int[][]grid,int prev)
    {
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j]<=prev)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        prev=grid[i][j];
        int ans=1+Math.max(f(i+1,j+1,grid,prev),Math.max(f(i-1,j+1,grid,prev),f(i,j+1,grid,prev)));
        dp[i][j]=ans;
        return ans;
    }
    public int maxMoves(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        
        dp=new int[n][m];
        for(int[] k:dp)
            Arrays.fill(k,-1);
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,f(i,0,grid,Integer.MIN_VALUE));
        }
        if(ans!=0)
            return ans-1;
        return ans;
    }
}