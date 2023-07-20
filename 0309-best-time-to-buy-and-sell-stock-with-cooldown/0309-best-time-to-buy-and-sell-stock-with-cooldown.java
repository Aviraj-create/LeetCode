class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp=new Integer[prices.length+1][2];
        return f(0,prices,0,dp);
    }
    public int f(int idx,int[] prices,int status,Integer[][] dp)
    {
        if(idx>=prices.length)
        {
            return 0;
        }
        
        if(dp[idx][status]!=null)return dp[idx][status];
        
        if(status==0)
        {
            //can buy(status==0)
             
            //buys
            int buys=-prices[idx]+f(idx+1,prices,1,dp);
            //not buys
            int notbuys=0+f(idx+1,prices,0,dp);
            //max of it
            return dp[idx][status]=Math.max(buys,notbuys);
        }
        else
        {
            //can sell
            
            int sells=prices[idx]+f(idx+2,prices,0,dp);
            
            int notsells=0+f(idx+1,prices,1,dp);
            
            return dp[idx][status]= Math.max(sells,notsells);
        }
    }
    
    
}