class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            ans[i]=dis(queries[i][0],queries[i][1]);
        }
        
        return ans;
    }
    public int dis(int a,int b)
    {
        int count=0;
        while(a!=b)
        {
            if(a>b)a=a/2;
            else b=b/2;
            count++;
        }
        return count+1;
    }
}