class Solution {
    public long maximumTripletValue(int[] nums) {
//         long ans=0;
//         for(int i=0;i<nums.length-2;i++)
//         {
//             for(int j=i+1;j<nums.length-1;j++)
//             {
//                 for(int k=j+1;k<nums.length;k++)
//                 {
                    
//                     long currScore = (long)(nums[i] - nums[j]) * nums[k];
//                     ans = Math.max(ans, currScore);
//                 }
//             }
//         }
//         return ans;
        
        long score=0;
        int n=nums.length;
        int[] maxLeft=new int[n];
        int[] maxRight=new int[n];
        maxLeft[0]=nums[0];
        maxRight[n-1]=nums[n-1];
        for(int i=1;i<n;i++) maxLeft[i]=Math.max(maxLeft[i-1],nums[i]);
        for(int i=n-2;i>=0;i--) maxRight[i]=Math.max(maxRight[i+1],nums[i]);
        for(int i=1;i<n-1;i++)
        {
            long currScore = (long)(maxLeft[i-1]-nums[i])*maxRight[i+1];
            score = Math.max(score, currScore);
        }
        return score;
        
    }
}