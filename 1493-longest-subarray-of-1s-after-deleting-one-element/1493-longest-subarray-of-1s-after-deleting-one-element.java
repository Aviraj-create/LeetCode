class Solution {
    Integer[][] dp;
    public int longestSubarray(int[] nums) {
        dp=new Integer[nums.length+1][2];
        
        int max=f(0,nums,1);
        if(max==nums.length)return max-1;
        else
        {
            return max;
        }
    }
    
    public int f(int idx,int[]nums,int canDel)
    {
        if(idx>=nums.length)return 0;
        
        // if(dp[idx][canDel]!=null)return dp[idx][canDel];
        int count=0;
        int skip=0;
        while(idx<nums.length && nums[idx]==1)
        {
            count++;
            idx++;
        }
        if(canDel==1)
        {
            count+=f(idx+1,nums,0);
            skip=f(idx+1,nums,1);
        }
        return dp[idx][canDel]=Math.max(skip,count);
    }
}