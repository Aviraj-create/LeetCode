class Solution {
    public int RobOrNot(int index,int []nums,int[]dp)
    {
        if(index>=nums.length)
            return 0;
        if(dp[index]!=-1)return dp[index];
        int rob=nums[index]+RobOrNot(index+2,nums,dp);
        int not=RobOrNot(index+1,nums,dp);
        
        return dp[index]=Math.max(rob,not);
    }
    public int rob(int[] nums) {
        int[]dp=new int [101];
        Arrays.fill(dp,-1);
        return RobOrNot(0,nums,dp);
    }
}