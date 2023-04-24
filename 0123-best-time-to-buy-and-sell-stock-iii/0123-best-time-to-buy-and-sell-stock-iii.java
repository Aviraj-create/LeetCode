class Solution {
    Integer dp[][][];
    public int maxProfit(int[] prices) {
        dp=new Integer [prices.length][2][3];
        
        return solver(0,prices,1,2);
    }
    
    public int solver(int idx,int[]prices,int buy,int cap)
    {
        if(cap==0)return 0;
        if(idx==prices.length)return 0;
            if(dp[idx][buy][cap]!=null)return dp[idx][buy][cap];
        if(buy==1)
            {
                int yes=-prices[idx]+solver(idx+1,prices,0,cap);
                int no=0+solver(idx+1,prices,1,cap);
            return dp[idx][buy][cap]=Math.max(yes,no);
            }   
        else
        {
            int yess=prices[idx]+solver(idx+1,prices,1,cap-1);
            int nos=0+solver(idx+1,prices,0,cap);
            return dp[idx][buy][cap]=Math.max(yess,nos);
        }
    }
}