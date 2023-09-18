class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        boolean[] seen_row=new boolean[n];
        boolean[] seen_col=new boolean[n];
        int row_seen=0;
        int col_seen=0;
        long sum=0;
        for(int q=queries.length-1;q>=0;q--)
        {
            int type=queries[q][0],index=queries[q][1],val=queries[q][2];
            
            if(type==0 && !seen_row[index])
            {
                seen_row[index]=true;
                row_seen++;
                sum+=(n-col_seen)*val;
            }
            if(type==1 && !seen_col[index])
            {
                seen_col[index]=true;
                col_seen++;
                sum+=(n-row_seen)*val;
            }
        }
        return sum;
        
    }
}