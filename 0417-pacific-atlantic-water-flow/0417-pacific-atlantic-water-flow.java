class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // DFS from top and bottom borders
        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights, Integer.MIN_VALUE, pacific);
            dfs(i, m - 1, heights, Integer.MIN_VALUE, atlantic);
        }

        // DFS from left and right borders
        for (int j = 0; j < m; j++) {
            dfs(0, j, heights, Integer.MIN_VALUE, pacific);
            dfs(n - 1, j, heights, Integer.MIN_VALUE, atlantic);
        }

        // Find cells that can flow to both oceans
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] heights, int prev, boolean[][] ocean) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || heights[i][j] < prev || ocean[i][j]) {
            return;
        }
        ocean[i][j] = true;
        dfs(i + 1, j, heights, heights[i][j], ocean);
        dfs(i - 1, j, heights, heights[i][j], ocean);
        dfs(i, j + 1, heights, heights[i][j], ocean);
        dfs(i, j - 1, heights, heights[i][j], ocean);
    }
}
