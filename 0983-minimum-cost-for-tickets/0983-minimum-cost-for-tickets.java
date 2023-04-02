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
    public int mincostTickets(int[] days, int[] costs) {
        int[]dp=new int[days.length];
        Arrays.fill(dp,-1);
        return solveMem(days,costs,0,dp);
    }
}