class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();

        for(int i=0;i<l.length;i++)
        {
            int start=l[i];
            int end=r[i];
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=start;j<end+1;j++)
            {
                temp.add(nums[j]);
            }
            ans.add(isArth(temp));
        }
        return ans;
    }
    
    public boolean isArth(ArrayList<Integer> temp)
    {
        if(temp.size()<=2)return true;
        Collections.sort(temp);
        int diff=temp.get(1)-temp.get(0);
        
        for(int i=0;i<temp.size()-1;i++)
        {
            if(temp.get(i+1)-temp.get(i)!=diff)return false;
        }
        return true;
    }
}
