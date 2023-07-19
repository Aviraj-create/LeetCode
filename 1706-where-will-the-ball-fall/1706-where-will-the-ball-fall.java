class Solution {
    public int[] findBall(int[][] grid) {
        
       int[]ans=new int[grid[0].length];
        for(int j=0;j<grid[0].length;j++)
        {
            ans[j]=f(grid,0,j);
        }return ans;
    }
    
    int f(int grid[][],int i,int j)
    {
        if(i==grid.length)return j;
        if(j>=grid[0].length || j<0)return -1;
        
        if(grid[i][j]==1 && j+1<grid[0].length && grid[i][j+1]==1)
        {
            return f(grid,i+1,j+1);
        }
        else if(grid[i][j]==-1 && j-1>=0 && grid[i][j-1]==-1)
        {
            return f(grid,i+1,j-1);
        }
        
        
            return -1;
        
    }
}