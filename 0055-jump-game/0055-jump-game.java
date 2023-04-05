class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int[]dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return f(0,n,nums,dp);
        
    }
    
    public boolean f(int index,int n,int[]nums,int[]dp)
    {
        if(index<n && dp[index]!=-1)
        {
            if(dp[index]==0)return false;
            if(dp[index]==1)return true;
        }
        
        if(index==n-1)return true;
        if(index>n-1)return false;
        
        for(int i=nums[index];i>0;i--)
        {
            boolean a=f(index+i,n,nums,dp);
            if(a==true)
            {
                dp[index]=1;
                return true;
            }
        }
        dp[index]=0;
        return false;
    }
}





