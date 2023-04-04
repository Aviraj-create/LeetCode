class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int sum=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            maxi=Math.max(maxi,sum);
            if(sum<0)sum=0;
        }
        sum=0;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            mini=Math.min(sum,mini);
            if(sum>0)sum=0;
        }
        
        return Math.max(Math.abs(mini),Math.abs(maxi));
        
        
    }
}