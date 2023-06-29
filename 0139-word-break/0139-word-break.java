class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        // Set<String> word=new HashSet<String>(wordDict);
        dp=new Boolean[s.length() +1];
        return f(0,s,wordDict);
    }
    
    public boolean f(int i,String s,List<String>wordDict)
    {
        int n=s.length();
        if(i==n)return true;
        if(dp[i]!=null)return dp[i];
        for(int j=i+1;j<=n;j++)
        {
            if(wordDict.contains(s.substring(i,j)) && f(j,s,wordDict))
            {
                return dp[i]=true;
            }
        }
        return dp[i]=false;
    }
}