class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        dp=new int[prices.length+1][2][3];
        
        for(int i=prices.length-1;i>=0;i--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int cap=1;cap<=2;cap++)
                {
                   if(buy==0){// We can buy the stock
                    dp[i][buy][cap] = Math.max(0+dp[i+1][0][cap], 
                                -prices[i] + dp[i+1][1][cap]);
                 }
    
                if(buy==1){// We can sell the stock
                    dp[i][buy][cap] = Math.max(0+dp[i+1][1][cap],
                                prices[i] + dp[i+1][0][cap-1]);
                }
                }
            }
        }
        return dp[0][0][2];
    }
    
    
}