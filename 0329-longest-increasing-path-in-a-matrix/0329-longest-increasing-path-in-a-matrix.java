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
        int maxPathLength = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxPathLength = Math.max(maxPathLength, f(i, j, matrix));
            }
        }
        
        return maxPathLength;
    }
    
    public int f(int i, int j, int[][] matrix) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        
        int maxPath = 1;
        
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[i][j]) {
                maxPath = Math.max(maxPath, 1 + f(newRow, newCol, matrix));
            }
        }
        
        dp[i][j] = maxPath;
        return maxPath;
    }
}
