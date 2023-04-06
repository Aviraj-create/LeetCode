class Solution {
    public void f(int i,int j,int[][]grid,boolean[][] visited,int n,int m)
    {
       if(i<0 || j<0 ||i>=n || j>=m || visited[i][j]==true || grid[i][j]==1)
       {
           return;
       }
        visited[i][j]=true;
        
        f(i+1,j,grid,visited,n,m);
         f(i,j+1,grid,visited,n,m);
         f(i-1,j,grid,visited,n,m);
         f(i,j-1,grid,visited,n,m);
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][]visited=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((i*j==0 || i==n-1 || j==m-1) && grid[i][j]==0 && visited[i][j]==false)
                {
                    f(i,j,grid,visited,n,m);
                }
                
            }
        }
        
        int result=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0 && visited[i][j]==false)
                {
                    result++;
                    f(i,j,grid,visited,n,m);
                }
                
            }
        }
        
       return result;
    }
}