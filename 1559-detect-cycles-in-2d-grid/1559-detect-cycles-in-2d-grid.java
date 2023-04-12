class Solution {
    public boolean containsCycle(char[][] grid) {
        
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid[0].length;j++)
                    {
                        if(!visited[i][j] && dfs(i,j,grid,visited,grid[i][j]))
                        {
                            return true;
                        }
                    }
            }
            
            return false;
                    
    }
    
    private boolean dfs(int i,int j,char[][]grid,boolean[][] visited,char target)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=target )
        {
            return false;
        }
        
        if(visited[i][j])return true;
        visited[i][j]=true;
        grid[i][j]='#';
        
        boolean found=dfs(i+1,j,grid,visited,target)
            ||dfs(i,j+1,grid,visited,target)
            || dfs(i-1,j,grid,visited,target)
            ||dfs(i,j-1,grid,visited,target);
        
        grid[i][j]=target;
        return found;
    }
}