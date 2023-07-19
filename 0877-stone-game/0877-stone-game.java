class Solution {
    public boolean stoneGame(int[] piles) {
        int left=0;
        int right=piles.length-1;
        Boolean[][][] dp=new Boolean[piles.length][piles.length][2];
        
        return f(left,right,piles,0,0,1,dp);
    }
    
    boolean f(int i,int j,int[] piles,int Alice,int Bob,int turn,Boolean[][][] dp)
    {
        if(j-i==1)
        {
            return (Alice>Bob)?true:false;
        }
        if(dp[i][j][turn]!=null)return dp[i][j][turn];
        
        boolean temp;
        if(turn==1)
        {
            temp=f(i+1,j,piles,Alice+piles[i],Bob,0,dp)||f(i,j-1,piles,Alice+piles[j],Bob,0,dp);
        }
        else
        {
            temp= f(i+1,j,piles,Alice,Bob+piles[i],1,dp)||f(i,j-1,piles,Alice,Bob+piles[j],1,dp);
        }
        return dp[i][j][turn]=temp;
    }
}