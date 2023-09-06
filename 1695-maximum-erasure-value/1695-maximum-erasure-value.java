class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int curr=0,max=0;
        Set<Integer> set=new HashSet<>();
        for(int r=0,l=0;r<nums.length;r++)
        {
            while(!set.add(nums[r])){
                
                curr-=nums[l];
                set.remove(nums[l++]);
                
            }
            
            curr+=nums[r];
            max=Math.max(max,curr);
        }
        
        return max;
    }
}