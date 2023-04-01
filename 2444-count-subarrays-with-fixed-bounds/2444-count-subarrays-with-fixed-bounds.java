class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long res=0;
        int start=-0;
        int minIndex=-0;
        int maxIndex=-0;
        boolean minFound=false;
        boolean maxFound=false;
        
        for(int i=0;i<nums.length;i++)
        {
            int num=nums[i];
            
            if(num>maxK || num<minK)
            {
                minFound=false;
                maxFound=false;
                start=i+1;
            }
            if(num==minK)
            {
                minFound=true;
                minIndex=i;
            }
            if(num==maxK)
            {
                maxFound=true;
                maxIndex=i;
            }
            
            if(maxFound && minFound)
            {
                res+=Math.min(maxIndex,minIndex)-start+1;
            }
        }
        return res;
        
    }
}