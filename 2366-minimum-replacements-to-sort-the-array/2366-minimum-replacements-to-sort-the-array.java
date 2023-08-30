class Solution {
    public long minimumReplacement(int[] nums) {
        long ans=0;
        int n=nums.length;
        int last=nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
           
                int no=nums[i]/last;
                if(nums[i]%last!=0)
                {
                    no++;
                    last=nums[i]/no;
                }
               
            
             ans+=no-1;
        }
        return ans;
    }
}