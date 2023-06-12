class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        if(nums.length==1)
        {
              ans.add(nums[0]+"");
            return ans;
        }
          
        
        for(int i=0;i<nums.length;i++)
        {
            int prev=nums[i];
            while(i+1<nums.length && nums[i+1]==nums[i]+1)
            {
                i++;
            }
            if(prev!=nums[i])
            {
                ans.add(prev+"->"+nums[i]);
            }
            else
            {
                ans.add(prev+"");
            }
        }
        return ans;
        
    }
}