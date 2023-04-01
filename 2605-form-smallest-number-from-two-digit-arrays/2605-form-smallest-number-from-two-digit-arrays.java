class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
        int min=10*nums1[0]+nums2[0];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++)
            {
                min=Math.min(min,10*nums1[i]+nums2[j]);
            }
        }
        
        for(int i=0;i<nums2.length;i++){
            for(int j=0;j<nums1.length;j++)
            {
                min=Math.min(min,10*nums2[i]+nums1[j]);
            }
        }
        
        for(int i=0;i<nums2.length;i++){
            for(int j=0;j<nums1.length;j++)
            {
               if(nums2[i]==nums1[j])
               {
                   min=Math.min(min,nums2[i]);
               }
            }
        }
        
        
        
        return min;
        
    }
}