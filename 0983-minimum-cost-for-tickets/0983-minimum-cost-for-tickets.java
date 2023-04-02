class Solution {
    public int solveMem(int[] days, int[] costs,int index,int[] dp)
    {
        if(index>=days.length)
        {
            return 0;
        }
        
        if(dp[index]!=-1)return dp[index];
        
        int option1=costs[0]+solveMem(days,costs,index+1,dp);
        
        int i;
        for(i=index;i<days.length&&days[i]<days[index]+7;i++);
        int option2=costs[1]+solveMem(days,costs,i,dp);
        
        for(i=index;i<days.length&&days[i]<days[index]+30;i++);
        int option3=costs[2]+solveMem(days,costs,i,dp);
        
        return dp[index]=Math.min(option1,Math.min(option2,option3));
        
    }
    
     public int solveTab(int[] days, int[] costs)
    {
         int n=days.length;
        int[]dp=new int[n+1];
         Arrays.fill(dp,Integer.MAX_VALUE);
         dp[n]=0;
         
         for(int k=n-1;k>=0;k--)
         {
             int option1=costs[0]+dp[k+1];
        
             int i;
             for(i=k;i<days.length&&days[i]<days[k]+7;i++);
             int option2=costs[1]+dp[i];
             
             for(i=k;i<days.length&&days[i]<days[k]+30;i++);
             int option3=costs[2]+dp[i];
             
             dp[k]=Math.min(option1,Math.min(option2,option3));
         }
         return dp[0];
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[]dp=new int[days.length];
        Arrays.fill(dp,-1);
        // return solveMem(days,costs,0,dp);
        return solveTab(days,costs);
    }
}