class Solution {
    public int countVowelStrings(int n) {
        int[][] dp=new int[n+1][5];
        for(int[] iarr : dp){
			Arrays.fill(iarr, -1);
		}
        return f(n,0,dp);
    }
    int f(int n,int idx,int[][] dp)
    {
        if(idx>=5)return 0;
        if(n==0)return 1;
        if(dp[n][idx]!=-1)return dp[n][idx];
        int take=f(n-1,idx,dp);
        int not=f(n,idx+1,dp);
        
        return dp[n][idx]=take+not;
    }
    
}



// public int countVowelStrings(int n) {
// 		int[][] dp = new int[n+1][5];
// 		for(int[] iarr : dp){
// 			Arrays.fill(iarr, -1);
// 		}
// 		return func(0, n, dp);
// 	}

// int func(int index, int n, int[][] dp){
//     if(index>=5){
//         return 0;
//     }
//     if(n == 0){
//         return 1;
//     }
//     if(dp[n][index] != -1){
//         return dp[n][index];
//     }
//     int pick = func(index, n - 1, dp);
//     int notPick = func(index+1, n, dp);
//     return  dp[n][index] = pick + notPick;
// }