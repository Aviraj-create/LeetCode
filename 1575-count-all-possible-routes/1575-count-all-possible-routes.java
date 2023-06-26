class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp=new long[locations.length][fuel+1];
        for(long[]temp:dp)
        {
            Arrays.fill(temp,-1);
        }
       long res = f(locations,start,finish,fuel,dp);
        return (int)res;
        
    }
    
    public long f(int[] arr,int curr,int finish,int fuel,long[][] dp)
    {
        if(fuel<0)return 0;
        if(dp[curr][fuel]!=-1)return dp[curr][fuel];
        long ans=0;
        if(curr==finish)ans=1;
        
        for(int i=0;i<arr.length;i++)
        {
            if(i==curr)continue;
            if(fuel<Math.abs(arr[i]-arr[curr]))continue;
            ans=(ans+(f(arr,i,finish,fuel-Math.abs(arr[i]-arr[curr]),dp)))%1000000007;
        }
        dp[curr][fuel]=ans;
        return ans;
                
        
    }
}