class Solution {
    public int jump(int[] nums) {
//         int n=nums.length;
//         int dp[]=new int[nums.length];
//         Arrays.fill(dp,Integer.MAX_VALUE);
//         dp[n-1]=0;
//         for(int i=n-2;i>=0;i--)
//         {
//             int min=Integer.MAX_VALUE;
//             for(int j=i+1;j<=Math.min(n-1,i+nums[i]);j++)
//             {
//                 min=Math.min(dp[j],min);
//             }
            
//             if(min!=Integer.MAX_VALUE)
//               { dp[i]=min+1;}
//         }
        
//         return dp[0];
        int jmp=0;
        int possibleMax=0;
        int currMax=0;
        for(int i=0;i<nums.length-1;i++)
        {
            possibleMax=Math.max(possibleMax,i+nums[i]);
            
            if(i==currMax)
            {
                jmp++;
                currMax=possibleMax;
            }
        }
        
        return jmp;
    }
    
}