class Solution {
    int ans=0;
    public int minSubArrayLen(int target, int[] nums) {
     int start=0;
        int sum=0;
        int end=0;
        while(end<nums.length && sum<target)
        {
            sum+=nums[end];
            end++;
        }
        f(0,end-1,nums,target,sum);
        return ans;
    }
    
    public void f(int start,int end,int[]nums,int target,int currSum)
    {
        if(currSum>=target)
        {
            ans=(end-start)+1;
            f(start+1,end,nums,target,currSum-nums[start]);
        }
        else if(end<nums.length-1)
        {
            f(start+1,end+1,nums,target,currSum-nums[start]+nums[end+1]);
        }
    }
}