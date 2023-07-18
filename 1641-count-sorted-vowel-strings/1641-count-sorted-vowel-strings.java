class Solution {
    int[][]dp;
    public int countVowelStrings(int n) {
        char[] vowel={'a','e','i','o','u'};
        dp=new int[n][5];
        int res=0;
        for(int i=0;i<vowel.length;i++)
        {
            res+=bk(n-1,i,vowel);
        }
        return res;
        
    }
    
    int bk(int n,int idx,char[] vowel)
    {
        if(n==0)return 1;
        else if(dp[n][idx]!=0)return dp[n][idx];
        int res=0;
        for(int i=idx;i<vowel.length;i++)
        {
            res+=bk(n-1,i,vowel);
        }
        return dp[n][idx]=res;
    }
    
}