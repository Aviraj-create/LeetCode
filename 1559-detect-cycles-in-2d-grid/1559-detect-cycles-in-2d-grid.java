class Solution {
    public boolean containsCycle(char[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        
        boolean visited[][]=new boolean[n][m];
        
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++)
           {
               if(!visited[i][j] && dfs(i,j,grid[i][j],grid,visited))
               {return true;}
           }   
       }
        return false;
    }
    
    public boolean dfs(int i,int j,char target,char[][]grid,boolean[][]visited)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=target)
        {return false;}
        
        if(visited[i][j])
        {
            return true;
        }
        
        visited[i][j]=true;
        grid[i][j]='#';
        
        boolean found=dfs(i+1,j,target,grid,visited) || dfs(i,j+1,target,grid,visited) || dfs(i-1,j,target,grid,visited) || dfs(i,j-1,target,grid,visited);
        
        grid[i][j]=target;
        return found;
    }
}