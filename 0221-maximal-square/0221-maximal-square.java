class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] m = new int[matrix.length][matrix[0].length];
        int max = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                m[i][j] = matrix[i][j] - '0';
                if (i > 0 && j > 0 && m[i][j] == 1) {
                    m[i][j] = 1 + Math.min(m[i - 1][j], Math.min(m[i][j - 1], m[i - 1][j - 1]));
                }
                max = Math.max(max, m[i][j]);
            }
        }
        
        return max * max;
    }
}
