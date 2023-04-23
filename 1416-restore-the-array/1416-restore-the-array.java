class Solution {
    public int numberOfArrays(String s, int k) {
        int[]dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return f(0,s,k,dp);
    }
    
    public int f(int idx,String s, int k,int[]dp)
    {
        if(idx==s.length())return 1;
        if(s.charAt(idx)=='0')return 0;
        if(dp[idx]!=-1)return dp[idx];
        int sum=0;
        long num=0;
        
        for(int j=idx;j<s.length();j++)
        {
            num=num*10+(s.charAt(j)-'0');
            if(num>k)break;
            
            sum+=f(j+1,s,k,dp);
            sum=sum%(int)(1e9+7);
        }
        
        return dp[idx]=sum;
    }
}