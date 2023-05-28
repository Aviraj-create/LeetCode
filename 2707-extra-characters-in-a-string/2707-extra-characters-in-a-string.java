class Solution {
    int dp[];
    Set<String> set;
    public int function(int idx,String s,Set<String> set,int dp[])
    {
        if(idx==s.length())
        {
            return 0;
        }
        if(dp[idx]!=-1)
            return dp[idx];
        
        int res=Integer.MAX_VALUE;
        for(int i=idx;i<s.length();++i)
        {
            String str=s.substring(idx,i+1);
            if(set.contains(str))
                res=Math.min(res,0+function(i+1,s,set,dp));
            else
                res=Math.min(res,i-idx+1+function(i+1,s,set,dp));
        }
        
        return dp[idx]=res;
    }
    public int minExtraChar(String s, String[] dictionary) {
        set=new HashSet<>();
        dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        for(String st:dictionary)
        {
            set.add(st);
        }
        
        return function(0,s,set,dp);
    }
}