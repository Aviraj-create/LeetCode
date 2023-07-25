class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp=new Integer[coins.length+1][5001];
        return f(0,coins,amount);
    }
    int f(int idx,int[] coins,int amount)
    {
        if(amount==0)
        {
            return 1;
        }
        if(idx>=coins.length)return 0;
        
        if(dp[idx][amount]!=null)return dp[idx][amount];
        
        int nottake=f(idx+1,coins,amount);
        int take=0;
        if(amount>=coins[idx])
        {
            take=f(idx,coins,amount-coins[idx]);
        }
        return dp[idx][amount]=(take+nottake);
    }
}