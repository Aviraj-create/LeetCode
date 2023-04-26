class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>>lists=new ArrayList<>();
        f(lists,new ArrayList<>(),k,n,1);
        return lists;
    }
    
    public void f( List<List<Integer>>lists,List<Integer>comb,int k,int n,int curr)
    {
        if(comb.size()==k && n==0)
        {
            List<Integer> temp=new ArrayList<>(comb);
            lists.add(temp);
            return;
        }
        for(int i=curr;i<=9;i++)
        {
            comb.add(i);
            f(lists,comb,k,n-i,i+1);
            comb.remove(comb.size()-1);
        }
    }
    
    
}