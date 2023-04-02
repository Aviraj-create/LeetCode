class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
               {
                   map.put(nums[i],1);
               }
               else
               {
                   map.put(nums[i],map.get(nums[i])+1);
               }
         }
        for(int i=0;i<nums.length;i++)
        {
            
       
        ArrayList<Integer> list=new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            
            if(entry.getValue()>0)
            {
                list.add(entry.getKey());
                map.put(entry.getKey(),entry.getValue()-1);
            }
            
        }
            if(list.size()==0)
            {
                continue;
            }
        ans.add(list);
          }   
        
        return ans;
    }
}       