class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        if(grid == null || grid.length == 0) return -1;
        
        int[][] dir=new int[][]{{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0}};
        if(grid[0][0]!=0 || grid[n-1][m-1]!=0)
        {
            return -1;
        }
        
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,0});
        while(!q.isEmpty())
        {
            int curr[]=q.poll();
            if(curr[0]==n-1 && curr[1]==m-1)return curr[2]+1;
            
            for(int[]temp:dir)
            {
                int X=curr[0]+temp[0];
                int Y=curr[1]+temp[1];
                if(X<0 || Y<0 ||X>=n || Y>=m || grid[X][Y]!=0 )continue;
                
                grid[X][Y]=-1;
                q.add(new int[]{X,Y,curr[2]+1});
            }
        }
        
        return -1;
        
    }
}