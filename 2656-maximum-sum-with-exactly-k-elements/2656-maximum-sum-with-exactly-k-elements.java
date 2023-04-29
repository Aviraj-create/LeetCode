class Solution {
    public int maximizeSum(int[] nums, int k) {
       Arrays.sort(nums);
        int max=nums[nums.length-1];
        int score=0;
        while(k!=0)
        {
            score+=max;
            max++;
            k--;
        }
        return score;
    }
}