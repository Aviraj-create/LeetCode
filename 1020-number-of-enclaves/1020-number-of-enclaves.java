class Solution {
    
    public void dfs(int i,int j,int[][]grid)
    {
        if(i<0 || j<0 ||i>=grid.length ||j>=grid[0].length || grid[i][j]==0)
        {
            return;
        }
        
        grid[i][j]=0;
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
        
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int enclaves=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i*j==0 ||i==n-1 || j==m-1)
                {
                    if(grid[i][j]==1)
                    {
                        dfs(i,j,grid);
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    enclaves++;
                }
            }
        }
         return enclaves;
    }
    
    
}