class Solution {
    int[][] dp;
    int MOD= 1_000_000_007;
    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        dp = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = (count+dfs(i, j, grid, Integer.MIN_VALUE))%MOD;
            }
        }
        
        return count;
    }
    
    public int dfs(int i, int j, int[][] grid, int prev) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || prev >= grid[i][j]) {
            return 0;
        }
        
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        
        int count = 1;
        
        count = (count+dfs(i + 1, j, grid, grid[i][j]))%MOD;
        count = (count+dfs(i - 1, j, grid, grid[i][j]))%MOD;
        count = (count+dfs(i, j + 1, grid, grid[i][j]))%MOD;
        count = (count+dfs(i, j - 1, grid, grid[i][j]))%MOD;
        
        dp[i][j] = count;
        
        return count;
    }
}
