class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int[] ans=new int[nums.length];
        
        int n=nums.length;
         long sum=0;
        int div=2*k+1;
        
        
        Arrays.fill(ans,-1);
        
       
        if(n<div)return ans;
        
        
        for(int i=0;i<n;i++)
        {
           sum+=nums[i];
           
            if(i>=div)
            {
                sum-=nums[i-div];
            }
            if(i>=div-1)
            {
                ans[i-k]=(int)(sum/div);
            }
        }
        return ans;
    }
}