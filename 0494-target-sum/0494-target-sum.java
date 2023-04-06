class Solution {
    int[]dp;
    public void f(int index,int[]nums,int target,int curr,int[]count)
    {
        if(index==nums.length)
        {
            if(curr==target)
            {
                count[0]++;
            }
            else
            {
                return;
            }
        }
        else
        {
            if(curr+dp[index]<target)return;
            int temp=curr;
            f(index+1,nums,target,curr+nums[index],count);
            f(index+1,nums,target,temp-nums[index],count);
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        int[] count=new int[1];
        dp = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = nums[i] + dp[i + 1];
        }
        f(0,nums,target,0,count);
        return count[0];
        
    }
}