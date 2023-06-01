class Solution {
    int[][] dp;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows][cols];
        int max = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, f(i, j, matrix));
            }
        }
        
        return max;
    }
    
    public int f(int i, int j, int[][] matrix) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        
        int maxP = 1;
        
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                    && matrix[x][y] > matrix[i][j]) {
                maxP = Math.max(maxP, 1 + f(x, y, matrix));
            }
        }
        
        dp[i][j] = maxP;
        return maxP;
    }
}
