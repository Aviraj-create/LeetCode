class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(k!=0)
            {
                sum%=k;
            }
            
            
            Integer temp=map.get(sum);
            if(temp!=null)
            {
                if(i-temp>1)return true;
            }
            else 
                map.put(sum,i);
        }
        return false;
    }
}