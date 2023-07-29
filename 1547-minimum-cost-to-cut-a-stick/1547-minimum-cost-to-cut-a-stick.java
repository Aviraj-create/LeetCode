class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
	return f(cuts, new HashMap<>(), 0, n);
    }
    public int f(int[] cuts,Map<String,Integer> map,int l,int r)
    {
        int res=Integer.MAX_VALUE;
        
        String s=l+"-"+r;
        if(map.containsKey(s))return map.get(s);
        for(int i=0;i<cuts.length;i++)
        {   
            if(cuts[i]<=l || cuts[i]>=r)continue;
            int cost=r-l;
            res=Math.min(f(cuts,map,cuts[i],r)+cost+f(cuts,map,l,cuts[i]),res);
        }
        
        res=(res==Integer.MAX_VALUE)?0:res;
        map.put(s,res);
        return res;
        
    }
}