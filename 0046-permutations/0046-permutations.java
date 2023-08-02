class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[]taken=new boolean[nums.length];
        List<List<Integer>>lists=new ArrayList<>();
        f(nums,new ArrayList<>(),lists,taken);
        return lists;
    }
    void f(int[] nums,List<Integer> list,List<List<Integer>> lists,boolean[] taken)
    {
        if(list.size()==nums.length)
        {
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(taken[i]!=true)
            {
                taken[i]=true;
                list.add(nums[i]);
                f(nums,list,lists,taken);
                list.remove(list.size()-1);
                taken[i]=false;
            }
        }
    }
}