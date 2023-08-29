class Solution {
    int n;
    Integer dp[][];
    public int minFlipsMonoIncr(String s) {
        n=s.length();
        dp=new Integer[100001][2];
        return f(0,s,0);
    }
    
    public int f(int idx,String s,int prev)
    {
        if(idx>=n)return 0;
        
        if(dp[idx][prev]!=null)return dp[idx][prev];
        
        
        int flip=Integer.MAX_VALUE;
        int not_flip=Integer.MAX_VALUE;
        
        if(s.charAt(idx)=='0')
        {
            if(prev==0)
            {
                flip=1+f(idx+1,s,1);
                not_flip=f(idx+1,s,0);
            }
            else
            {
                flip=1+f(idx+1,s,1);
            }
        }
        else
        {
            if(prev==0)
            {
                flip=1+f(idx+1,s,0);
                not_flip=f(idx+1,s,1);
            }
            else
            {
                not_flip=f(idx+1,s,1);
            }
        }
        
        return dp[idx][prev]=Math.min(flip,not_flip);
    }
}