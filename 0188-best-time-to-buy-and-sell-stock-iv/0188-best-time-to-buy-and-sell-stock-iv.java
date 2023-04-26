class Solution {
    Integer dp[][][];
    public int f(int idx,int[]prices,int buy,int cap,int n)
    {
        if(idx >= n || cap==0)
        {
            return 0;
        }
        // if(cap==0) return 0;
        if(dp[idx][buy][cap]!=null)return dp[idx][buy][cap];
        if(buy==1)
        {
            return dp[idx][buy][cap]=Math.max(-prices[idx]+f(idx+1,prices,0,cap,n),0+f(idx+1,prices,1,cap,n));
        }
        else
        {
            return dp[idx][buy][cap]=Math.max(prices[idx]+f(idx+1,prices,1,cap-1,n),0+f(idx+1,prices,0,cap,n));
        }
        
    }
    public int maxProfit(int k, int[] prices) {
        dp=new Integer[prices.length+1][2][k+1];
        return f(0,prices,1,k,prices.length);
    }
    
}
