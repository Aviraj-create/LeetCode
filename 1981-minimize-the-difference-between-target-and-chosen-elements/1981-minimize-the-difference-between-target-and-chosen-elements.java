class Solution {
    Integer dp[][];
    public int minimizeTheDifference(int[][] mat, int target) {
        dp=new Integer[71][6000];
        return f(0,mat[0].length,mat,0,target); 
    }
    
    public int f(int idx,int k,int[][]mat,int sum,int target)
    {
        if(idx>=mat.length)
        {
            return Math.abs(target-sum);
        }
        if(dp[idx][sum]!=null)return dp[idx][sum];
        int a=Integer.MAX_VALUE;
        for(int i=0;i<k;i++)
        {
            a=Math.min(f(idx+1,k,mat,sum+mat[idx][i],target),a);
        }
        return dp[idx][sum]=a;
    }
}