class Solution {
    int mod=(int)1e9+7;
    int[][][]dp=new int[102][102][102];
    
    public int f(int k,int i,int j,int minProfit,int[]group,int[]profit,int n)
    {
        if(k==profit.length)
        {
            if(j>=minProfit && n>=i)return 1;
            return 0;
        }
        if(n<i)return 0;
        
        if(dp[k][i][j]!=-1)return dp[k][i][j];
        int include=0,notinclude=0;
        notinclude=f(k+1,i,j,minProfit,group,profit,n);
        include=f(k+1,i+group[k],Math.min(j+profit[k],minProfit),minProfit,group,profit,n);
        
        return dp[k][i][j]=(include + notinclude)%mod;
        
        
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        for(int i = 0; i < dp.length; i++) {
    for(int j = 0; j < dp[i].length; j++) {
        Arrays.fill(dp[i][j], -1);
    }
    }
        return f(0,0,0,minProfit,group,profit,n);
        
        
       
        
        
        
    }
}