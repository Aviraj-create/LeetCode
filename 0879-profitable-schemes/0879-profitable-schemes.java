// class Solution {
//     int mod=(int)1e9+7;
//     int[][][]dp=new int[102][102][102];
    
//     public int f(int k,int i,int j,int minProfit,int[]group,int[]profit,int n)
//     {
//         if(k==profit.length)
//         {
//             if(j>=minProfit && n>=i)return 1;
//             return 0;
//         }
//         if(n<i)return 0;
        
//         if(dp[k][i][j]!=-1)return dp[k][i][j];
//         int include=0,notinclude=0;
//         notinclude=f(k+1,i,j,minProfit,group,profit,n);
//         include=f(k+1,i+group[k],Math.min(j+profit[k],minProfit),minProfit,group,profit,n);
        
//         return dp[k][i][j]=(include%mod + notinclude%mod)%mod;
        
        
//     }
//     public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
//         for(int i = 0; i < dp.length; i++) {
//     for(int j = 0; j < dp[i].length; j++) {
//         Arrays.fill(dp[i][j], -1);
//     }
//     }
//         return f(0,0,0,minProfit,group,profit,n);        
//     }
// }


class Solution {
    int mod=(int)1e9+7;
   
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
         int[][][]dp=new int[group.length+1][n+1][minProfit+1];
        dp[0][0][0]=1;
        for(int k=1;k<=group.length;k++)
        {
            int groupMem=group[k-1];
            int prof=profit[k-1];
            
            for(int i=0;i<=n;i++)
            {
                for(int j=0;j<=minProfit;j++)
                {
                    //not include
                    dp[k][i][j]=dp[k-1][i][j];
                    if(i>=groupMem)
                    {
                        dp[k][i][j]=(dp[k][i][j]+dp[k-1][i-groupMem][Math.max((j-prof),0)])%mod;
                    }
                }
            }
        }
        
        int sum=0;
        for(int i=0;i<=n;i++)
        {
            sum=(sum+dp[group.length][i][minProfit])%mod;
        }
        return sum;
    }
}